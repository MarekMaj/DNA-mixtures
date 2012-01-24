package org.DNA.mixtures.computing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

import org.DNA.mixtures.data.*;

public class DNAProcessor implements Serializable{

	public static final int MAX_NO_OF_PEOPLE = 3;
	public static final int NO_OF_ALLELS_IN_GENOTYPE = 2;
	public static final int MAX_NO_OF_ALLELS = NO_OF_ALLELS_IN_GENOTYPE * MAX_NO_OF_PEOPLE;
	private int nMin = 0;
	
    public DNAProcessor() {
        super();
    }

//    public static void main(String[] args){
//    	DNAProcessor p = new DNAProcessor(); 
//    	MarkersType markers = new MarkersType();
//    	MixtureType mixture = new MixtureType();
//    	mixture.setMarkers(markers);
//    	MarkersType markersForPerson = new MarkersType(1);
//    	
//    	PersonType person = new PersonType();
//    	person.setMarkers(markersForPerson);
//    	p.process(mixture, person);
//    }
    
    /** Calculates all possible profiles for 2 or 3 people, that fulfill given mixture,
     * if profile for one person is supplied result is constrained and during calculations
     * optimization is used.
     * When there is no information concerning person profile, empty object is passed to the method.
     * 
     * @param mixture 		All markers characterizing mixture.	
     * @param personType 	All markers characterizing given person.
     * @return				Solution of the problem
     */
    
    //private Solution s;
    
    public Object process(MixtureType mixture, PersonType personType){
        Algorithms algs = new Algorithms();
    	Solution s;
        
    	ArrayList<MarkerType> mixtureMarkers = (ArrayList<MarkerType>) mixture.getMarkers().getMarker();
    	if (!examineMixture(mixtureMarkers))
    		return null;    	    	
    	
    	// person profile was supplied
    	if(personType.getMarkers() != null){
    		ArrayList<MarkerType> personMarkers = (ArrayList<MarkerType>) personType.getMarkers().getMarker();
    		if(!examinePersonProfile(personMarkers))
    			return null;    		 
    		if(mixtureMarkers.size() != personMarkers.size()){
    			//TODO inform View about this situation
    			System.out.println("Different number of markers in mixture and in person profile.");
    			return null;
    		}    		
    		//TODO optionally check if the names of markers are the same ...     			
    		s = algs.calculateProfiles(nMin, mixtureMarkers, personMarkers);
    	} 
    	else{
    		s = algs.calculateProfiles(nMin, mixtureMarkers);
    	}
    	return s;
    }

    /** Calculates the rest of possible profiles combinations when one profile is given and
     * it wasn't supplied in the first step.
     * This method uses previously calculated data for mixture (form of optimization).
     * That's because two-argument version of this method is always called earlier.
     * 
     * @param personType    Information characterizing given person i.e. markers 
     * @return 				Solution of the problem
     */
    public Object process(PersonType personType){
        //temporarily no functionality.
    	//it will use solution computed thanks to call to two-argument version
    	return null;
    }
    
    /* Checks if mixture doesn't contain any errors,
     * it also calculates the minimal number of people fulfilling the mixture.
     * 
     * @param markers	All markers contained in the mixture
     * @return 			true if mixture can be passed to the algorithm
     */
    private boolean examineMixture(ArrayList<MarkerType> markers){
 	
    	if(markers.size() == 0){
    		//TODO inform View about this situation
    		System.out.println("There is not even one marker in the mixture.");
    		return false;
    	}
    	
    	// prepare variables
    	nMin = 0;
    	
    	for(MarkerType marker : markers){
    		ArrayList<String> allels = (ArrayList<String>) marker.getAllel();
    		int size = allels.size();
    		
    		// calculates minimal number of people in the mixture
    		int n_min = (size + 1)/2;
    		if(n_min > nMin)
    			nMin = n_min;
    			
    		if(size == 0){
    			//TODO inform View about this situation
    			System.out.println("There are no variants given for " + marker.getName() + " marker in the mixture.");
    			return false;
    		}    		 		
    		if(size > MAX_NO_OF_ALLELS){
    			//TODO inform View about this situation
    			System.out.println("More than " + MAX_NO_OF_ALLELS + " variants for " + marker.getName() + " marker in the mixture, trying to eliminate possible repetitions.");
    			HashSet<String> set = new HashSet<String>();
    			ArrayList<Integer> indexesOfRepetitions = new ArrayList<Integer>();
    			for(int i=0; i<size; ++i)
    				if(!set.add(allels.get(i)))
    					indexesOfRepetitions.add((Integer)i);
    			
    			if(set.size() > MAX_NO_OF_ALLELS){
    				System.out.println("Failure, after all, there are more than " + MAX_NO_OF_ALLELS + " variants.");
    				return false;
    			}
    			else{
    				System.out.println("Success, there were some repetitions, without them there is a proper number of variants.");
    				for(int i=indexesOfRepetitions.size()-1; i>=0; --i)
    					allels.remove(indexesOfRepetitions.get(i).intValue());
    			}			
    		}  		 		
    	}
    	
    	return true;
    }
    
    /* Checks if additional person profile doesn't contain any errors.
     * 
     * @param markers	All markers characterizing person
     * @return 			true if profile can be passed to the algorithm
     */
    private boolean examinePersonProfile(ArrayList<MarkerType> markers){
    	
    	if(markers.size() == 0){
    		//TODO inform View about this situation
    		System.out.println("There is not even one marker defined in additional person profile.");
    		return false;
    	}
    	for(MarkerType marker : markers){
    		ArrayList<String> allels = (ArrayList<String>) marker.getAllel();
    		if(allels.size() != NO_OF_ALLELS_IN_GENOTYPE){
    			//TODO inform View about this situation
    			System.out.println("Wrong number of allels defined for " + marker.getName() + " marker in the additional person profile.");
    			return false;
    		}
    	}
    	return true;
    }
}
