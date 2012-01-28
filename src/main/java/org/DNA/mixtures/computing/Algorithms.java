package org.DNA.mixtures.computing;

import java.util.ArrayList;

import org.DNA.mixtures.data.*;

public class Algorithms {
		
	private int nMin;
	private int noOfUnusedAllels;						//how many allels were not used by the algoritm while creating possible profiles combination
	private int emptySlotsInCombination;				//how many empty slots are left for allels during profiles combination generation				
	private ArrayList<String> allels;					//allels (variants) which occured in mixture
	private ArrayList<Genotype> possibleGenotypesList = new ArrayList<Genotype>();
	private ArrayList<Genotype> innerRepresentationOfCombination = new ArrayList<Genotype>();
	private ArrayList<ProfileCombination> profilesCombinations;		// recursive function	
	private int[] unusedAllelsArr;
	
	private int cntr;									//for debugging purposes, no. of combinations generated 
		
	public Algorithms(int noOfPeopleInMixture){
		nMin = noOfPeopleInMixture;
	}
			
	public Solution calculateProfiles(ArrayList<MixtureMarker> mixtureMarkers){
		return calculateProfiles(mixtureMarkers, null);
	}
	
	public Solution calculateProfiles(ArrayList<MixtureMarker> mixtureMarkers, ArrayList<PersonMarker> personMarkers){
		long start = System.nanoTime();
		
		Solution solution = new Solution();
		ArrayList<SolutionMarker> solutionMarkers = (ArrayList<SolutionMarker>)solution.getMarker();				
		
		int iter = 0;
		for(MixtureMarker marker : mixtureMarkers){
			SolutionMarker solutionMarker = new SolutionMarker();
			profilesCombinations = (ArrayList<ProfileCombination>)solutionMarker.getProfileCombination();
			
			allels = (ArrayList<String>) marker.getAllel();

			if(allels.size() == 1){
				for(int i=0; i<nMin; ++i)
					innerRepresentationOfCombination.add(new Genotype(0,0));
				placeInSolutionStructure(innerRepresentationOfCombination);
			}
			else{ 
				generatePossibleGenotypes();	
				unusedAllelsArr = new int[allels.size()];
				emptySlotsInCombination = nMin * DNAProcessor.NO_OF_ALLELS_IN_GENOTYPE;
				prepareUnusedAllelsArr();	//TODO is it not necessary?

				if(personMarkers != null){
					ArrayList<String> genotype = (ArrayList<String>) personMarkers.get(iter).getAllel();
					int index1 = allels.indexOf(genotype.get(0));
					int index2 = allels.indexOf(genotype.get(1));
					innerRepresentationOfCombination.add(new Genotype(index1, index2));		
					++unusedAllelsArr[index1];
					++unusedAllelsArr[index2];
					emptySlotsInCombination -= 2;
				}
				
				cntr = 0;		
				generateCombinations(0);
				
				possibleGenotypesList.clear();
			}
			solutionMarkers.add(solutionMarker);
			
			++iter;
			//System.out.print(cntr + "\n\n\n");
			innerRepresentationOfCombination.clear();
		}

		profilesCombinations = null;
		
		long elapsedTime = System.nanoTime() - start;
		//System.out.println(String.valueOf(elapsedTime / 1000000000L) + " [s]");

		return solution;	
	}

	private void prepareUnusedAllelsArr(){	
		for(int i=0; i<unusedAllelsArr.length; ++i)
			unusedAllelsArr[i] = 0;
	}
	
	private void countUnusedAllels(){
		noOfUnusedAllels = 0;
		for(int i=0; i<unusedAllelsArr.length; ++i)
			if(unusedAllelsArr[i] == 0)
				++noOfUnusedAllels;
	}
	
	private void generatePossibleGenotypes(){
		int i, j, size = allels.size();
		
		//This variable helps us reject homozygous ... 
		//e.g. if there are 5 allels and we know that in mixture there are 3 people, there can be a person with genotype consisting of the same allels 
		//	   but if there are 6 allels and 3 people none of the allels will occur more than once. 
		int product = nMin * DNAProcessor.NO_OF_ALLELS_IN_GENOTYPE;		
		for(i=0; i<size; ++i)
			for(j=i; j<size; ++j)
				if( !(i==j && size == product) )
					possibleGenotypesList.add(new Genotype(i,j));		
	}	
		
	private void placeInSolutionStructure(ArrayList<Genotype> result){
		ProfileCombination combination = new ProfileCombination();
		ArrayList<PersonMarker> genotypes = (ArrayList<PersonMarker>)combination.getMarker();
		
		for(Genotype g: result){
			PersonMarker genotype = new PersonMarker();
			ArrayList<String> allelsInResult = (ArrayList<String>)genotype.getAllel();
			allelsInResult.add(allels.get(g.first));	//TODO maybe new ?
			allelsInResult.add(allels.get(g.second));
			
			genotypes.add(genotype);
		}
		profilesCombinations.add(combination);
	}
	
	private void generateCombinations(int start){	
		for(int i=start; i<possibleGenotypesList.size(); ++i){
			Genotype profile = possibleGenotypesList.get(i);
			++unusedAllelsArr[profile.first]; ++unusedAllelsArr[profile.second];
			emptySlotsInCombination -= 2;
			countUnusedAllels();
			if(noOfUnusedAllels <= emptySlotsInCombination){
				innerRepresentationOfCombination.add(profile);
				if(emptySlotsInCombination == 0){
					++cntr;
					//printResult();
					placeInSolutionStructure(innerRepresentationOfCombination);
				}
				else{
					generateCombinations(i);
				}
				innerRepresentationOfCombination.remove(profile);
			}
			--unusedAllelsArr[profile.first]; --unusedAllelsArr[profile.second];
			emptySlotsInCombination +=2;
		}
	}
	
	private void printResult(){				
		for(Genotype p: innerRepresentationOfCombination){
			System.out.print(String.valueOf(p.first) + String.valueOf(p.second) + " ");
		}
		System.out.println("");
	}	
}
