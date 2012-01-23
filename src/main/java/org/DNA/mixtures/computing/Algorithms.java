package org.DNA.mixtures.computing;

import java.util.ArrayList;

import org.DNA.mixtures.data.*;

public class Algorithms {
		
	//TODO add comments to fields
	private ArrayList<Genotype> genotypesList = new ArrayList<Genotype>();
	private int slots;			
	private int iter;
	private ArrayList<String> allels;	//gives comfortable access to mapping
	private ArrayList<MarkerType> combination;		//easily passed to recursive function	
	//ArrayList<Genotype> possibleProfiles2 = new ArrayList<Genotype>();	
	int[] unusedArr;
	ArrayList<Genotype> result = new ArrayList<Genotype>();
	int cntr;	//liczba alleli ktore nie trafily do profili
	
	private void initUnusedArr(){
		for(int i=0; i<unusedArr.length; ++i)
			unusedArr[i] = 0;
		//if(gottaGivenProfile){
		//	++unusedArr[givenProfile.first]; ++unusedArr[givenProfile.second];
		//}
	}
	
	private void countUnusedAllels(){
		cntr = 0;
		for(int i=0; i<unusedArr.length; ++i)
			if(unusedArr[i] == 0)
				++cntr;
	}
	
	private void generateGenotypes(int nMin){
		//TODO change the name of product
		genotypesList.clear();
		int i, j, size = allels.size(), product = nMin * DNAProcessor.NO_OF_ALLELS_IN_GENOTYPE;
		for(i=0; i<size; ++i)
			for(j=i; j<size; ++j)
				if( !(i==j && allels.size() == product) )
					genotypesList.add(new Genotype(i,j));		
	}

	private void placeInSolutionStructure(ArrayList<Genotype> result){
						
		MarkerType line = new MarkerType();
		ArrayList<String> profiles = (ArrayList<String>) line.getAllel();
		for(Genotype g: result){
			profiles.add(allels.get(g.first));
			profiles.add(allels.get(g.second));
		}		
		combination.add(line);
	}
	
	//TODO add optimization reducing genotypeList for lower levels
	private void generateCombinations(int start){	
		for(int i=start; i<genotypesList.size(); ++i){
			Genotype profile = genotypesList.get(i);
			slots -= 2;
			++unusedArr[profile.first]; ++unusedArr[profile.second];
			countUnusedAllels();
			if(cntr <= slots){
				result.add(profile);
				if(slots == 0){
					++iter;
					//printResult();
					placeInSolutionStructure(result);
				}
				else
					generateCombinations(i);
				result.remove(profile);
			}
			--unusedArr[profile.first]; --unusedArr[profile.second];
			slots +=2;
		}
	}
		
	public Solution calculateProfiles(int noOfPeopleInMixture, ArrayList<MarkerType> mixtureMarkers){
		return calculateProfiles(noOfPeopleInMixture, mixtureMarkers, null);
	}
	
	public Solution calculateProfiles(int noOfPeopleInMixture, ArrayList<MarkerType> mixtureMarkers, ArrayList<MarkerType> personMarkers){
		Solution solution = new Solution();
		ArrayList<Marker> markersInSolution = (ArrayList<Marker>)solution.getMarkers();
		
		int i=0;	
		for(MarkerType marker : mixtureMarkers){
			Marker combinations = new Marker(marker.getName());
			combination = (ArrayList<MarkerType>) combinations.getCombinations();
			
			allels = (ArrayList<String>) marker.getAllel();

			if(allels.size() == 1){
				//TODO put same profiles to the solution structure
				// in the second version of this method should personMarkers be checked for consistency ? 
			}
			//TODO it would probably be better if those 5 structures would reside in memory
			generateGenotypes(noOfPeopleInMixture);
			
			slots = noOfPeopleInMixture * DNAProcessor.NO_OF_ALLELS_IN_GENOTYPE;
			unusedArr = new int[allels.size()];		//TODO different place of initialization maybe
			initUnusedArr();
			if(personMarkers != null){	//TODO put this code into separate method
				ArrayList<String> genotype = (ArrayList<String>) personMarkers.get(i).getAllel();
				if( !(allels.contains(genotype.get(0))) || !(allels.contains(genotype.get(1))) ){
					//TODO inform View about this situation
					System.out.println("Allels from person profile does not occur in the mixture (for " + marker.getName() + " marker).");
					return null;
				}
				int index1 = allels.indexOf(genotype.get(0));
				int index2 = allels.indexOf(genotype.get(1));
				++unusedArr[index1];
				++unusedArr[index2];
				result.add(new Genotype(index1, index2));
				++i;
				slots -= 2;
			}
			iter = 0; 		//for debugging purposes only, combinations counter
			
			generateCombinations(0);
			
			//System.out.print(iter + "\n\n\n");
			markersInSolution.add(combinations);
			
			result.clear(); //if personMarkers were supplied
		}
		//TODO should combinations be cleared as well? allels.clear();?
		return solution;	
	}
				
	private void printResult(){				
		for(Genotype p: result){
			System.out.print(String.valueOf(p.first) + String.valueOf(p.second) + " ");
		}
		System.out.println("");
	}
	
	private void print(){
		int i = 1;
		for(Genotype p : genotypesList)
			System.out.println(String.valueOf(i++) + ". " + p);
	}
	
}
