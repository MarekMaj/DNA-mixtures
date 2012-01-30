package org.DNA.mixtures.computing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

import org.DNA.mixtures.data.Mixture;
import org.DNA.mixtures.data.MixtureMarker;
import org.DNA.mixtures.data.Person;
import org.DNA.mixtures.data.PersonMarker;
import org.DNA.mixtures.data.ProfileCombination;
import org.DNA.mixtures.data.Solution;
import org.DNA.mixtures.data.SolutionMarker;
import org.DNA.mixtures.tests.ExampleDataSet;

public class DNAProcessor implements Serializable{

	public static final int MAX_NO_OF_PEOPLE = 3;
	public static final int NO_OF_ALLELS_IN_GENOTYPE = 2;
	public static final int MAX_NO_OF_ALLELS = NO_OF_ALLELS_IN_GENOTYPE * MAX_NO_OF_PEOPLE;
	private int nMin = 0;
	
	private Solution mixtureSolution;					//solution calculated when only mixture was given
	private ArrayList<MixtureMarker> mixtureMarkers;	//markers will be of some help when we want to calculate solution based on solution calculated for mixture only
	private Solution solutionWithGivenProfile;			//solution when AFTER calculating solution for mixture, profile is supplied 
	
    public DNAProcessor() {
        super();
    }
    
    /** Calculates all possible profiles for 2 or 3 people, that fulfill given mixture,
     * if profile for one person is supplied result is constrained and during calculations
     * optimization is used.
     * When there is no information concerning person profile, empty object is passed to the method.
     * 
     * @param mixture 		Mixture with all markers characterizing it.	
     * @param person 		Given person with all markers characterizing it.
     * @return				Solution of the problem.
     */
    public Solution process(Mixture mixture, Person person) throws ErrorInInputDataException{
        
    	mixtureMarkers = (ArrayList<MixtureMarker>) mixture.getMarker();
    	examineMixture(mixtureMarkers);
    	
    	Algorithms algs = new Algorithms(nMin);
    		
    	// person profile was supplied
    	if(person.getMarker().size() != 0){
    		ArrayList<PersonMarker> personMarkers = (ArrayList<PersonMarker>) person.getMarker();
    		examinePersonProfile(personMarkers);    		 
    		
    		examinePersonProfileAgainstMixture(mixtureMarkers, personMarkers);
    		     			
    		mixtureSolution = algs.calculateProfiles(mixtureMarkers, personMarkers);
    	} 
    	else{
    		mixtureSolution = algs.calculateProfiles(mixtureMarkers);
    	}
    	return mixtureSolution;
    }

    /** Calculates the rest of possible profiles combinations when one profile is given and
     * it wasn't supplied in the first step (solution for mixture only was calculated before).
     * This method uses previously calculated data for mixture (form of optimization).
     * We have a guarantee that two-argument version of this method is always called earlier.
     * 
     * @param person    Information characterizing given person i.e. markers 
     * @return 			Solution of the problem
     */
    public Solution process(Person person) throws ErrorInInputDataException{
    	
    	ArrayList<PersonMarker> personMarkers = (ArrayList<PersonMarker>) person.getMarker();
    	examinePersonProfile(personMarkers);
    	examinePersonProfileAgainstMixture(mixtureMarkers, personMarkers);
    	solutionWithGivenProfile = new Solution();
    	ArrayList<SolutionMarker> solutionMarkers = (ArrayList<SolutionMarker>) solutionWithGivenProfile.getMarker();    	
    	ArrayList<SolutionMarker> mixtureSolutionMarkers = (ArrayList<SolutionMarker>) mixtureSolution.getMarker();
    	
    	for(int i=0; i<mixtureSolutionMarkers.size(); ++i){
    		ArrayList<ProfileCombination> mixtureProfilesCombinations = (ArrayList<ProfileCombination>) mixtureSolutionMarkers.get(i).getProfileCombination();
    		SolutionMarker solutionMarker = new SolutionMarker();
    		ArrayList<ProfileCombination> profilesCombinations = (ArrayList<ProfileCombination>)solutionMarker.getProfileCombination();
    		
    		for(int j=0; j<mixtureProfilesCombinations.size(); ++j){
    			ArrayList<PersonMarker> mixtureProfiles = (ArrayList<PersonMarker>) mixtureProfilesCombinations.get(j).getMarker();		
    			
    			if(mixtureProfiles.contains(personMarkers.get(i))){
    				ProfileCombination combination = new ProfileCombination();
    				ArrayList<PersonMarker> profiles = (ArrayList<PersonMarker>)combination.getMarker();
    				
    				for(PersonMarker mixtureProfile : mixtureProfiles){
    					profiles.add(mixtureProfile);
    				}
    				profilesCombinations.add(combination);
    			}
    		}
    		solutionMarkers.add(solutionMarker);
    	}
    	
		return solutionWithGivenProfile;
    }
    
    /* Checks if mixture doesn't contain any errors,
     * it also calculates the minimal number of people fulfilling the mixture.
     * 
     * @param markers	All markers contained in the mixture
     * @return 			true if mixture can be passed to the algorithm
     */
    private boolean examineMixture(ArrayList<MixtureMarker> markers)throws ErrorInInputDataException{
 	
    	if(markers.size() == 0){
    		throw new ErrorInInputDataException("There is not even one marker in the mixture.");
    	}
    	
    	// prepare variables
    	nMin = 0;
    	
    	for(MixtureMarker marker : markers){
    		ArrayList<String> allels = (ArrayList<String>) marker.getAllel();
    		int size = allels.size();
    		
    		if(size == 0){
    			throw new ErrorInInputDataException("There are no variants given for " + marker.getName() + " marker in the mixture.");
    		}
    		
    		// remove all possible repetitions from the mixture
			HashSet<String> set = new HashSet<String>();
			ArrayList<Integer> indexesOfRepetitions = new ArrayList<Integer>();
			for(int i=0; i<size; ++i)
				if(!set.add(allels.get(i)))
					indexesOfRepetitions.add((Integer)i);
    		
			size = set.size();			
			if(size > MAX_NO_OF_ALLELS){
				throw new ErrorInInputDataException("More than " + MAX_NO_OF_ALLELS + " variants for " + marker.getName() + " marker in the mixture.");
			}
			for(int i=indexesOfRepetitions.size()-1; i>=0; --i)
				allels.remove(indexesOfRepetitions.get(i).intValue());
			
			// calculates minimal number of people in the mixture
    		int n_min = (size + 1)/2;
    		if(n_min > nMin)
    			nMin = n_min;
    			   		 		 		 		
    	} 	
    	return true;
    }
    
    /* Checks if additional person profile doesn't contain any errors.
     * 
     * @param markers	All markers characterizing person
     * @return 			true if profile can be passed to the algorithm
     */
    private boolean examinePersonProfile(ArrayList<PersonMarker> markers) throws ErrorInInputDataException{
    	
    	for(PersonMarker marker : markers){
    		ArrayList<String> allels = (ArrayList<String>) marker.getAllel();
    		if(allels.size() != NO_OF_ALLELS_IN_GENOTYPE){
    			throw new ErrorInInputDataException("Wrong number of allels defined for " + marker.getName() + " marker in the additional person profile.");
    		}
    	}
    	return true;
    }
    
    private boolean examinePersonProfileAgainstMixture(ArrayList<MixtureMarker> mixtureMarkers, ArrayList<PersonMarker> personMarkers) throws ErrorInInputDataException{
		if(mixtureMarkers.size() != personMarkers.size()){
			throw new ErrorInInputDataException("Different number of markers in mixture and in person profile.");
		}		
		for(int i=0; i<mixtureMarkers.size(); ++i){
			ArrayList<String> allelsInMixture = (ArrayList<String>) mixtureMarkers.get(i).getAllel();
			ArrayList<String> personAllels = (ArrayList<String>) personMarkers.get(i).getAllel();

			if( !(allelsInMixture.contains(personAllels.get(0))) || !(allelsInMixture.contains(personAllels.get(1))) ){
				throw new ErrorInInputDataException("Allel from person profile does not occur in the mixture (for " + mixtureMarkers.get(i).getName() + " marker).");
			}
		}
    	return true;
    }
}
