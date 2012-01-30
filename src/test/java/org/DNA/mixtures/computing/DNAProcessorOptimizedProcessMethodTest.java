package org.DNA.mixtures.computing;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.DNA.mixtures.data.Mixture;
import org.DNA.mixtures.data.MixtureMarker;
import org.DNA.mixtures.data.Person;
import org.DNA.mixtures.data.PersonMarker;
import org.DNA.mixtures.data.ProfileCombination;
import org.DNA.mixtures.data.Solution;
import org.DNA.mixtures.data.SolutionMarker;
import org.junit.Test;


public class DNAProcessorOptimizedProcessMethodTest {

	@Test
	public void personWith1MarkerTest() throws ErrorInInputDataException{
		DNAProcessor p = new DNAProcessor();
		//check if algorithm copes with repetitions in mixture
		Mixture mixture = new Mixture();
		ArrayList<MixtureMarker> markers = (ArrayList<MixtureMarker>) mixture.getMarker();
		MixtureMarker marker = new MixtureMarker();
		markers.add(marker);
		ArrayList<String> allels = (ArrayList<String>) marker.getAllel();
		allels.add("A"); allels.add("B"); allels.add("C"); allels.add("D"); allels.add("E"); allels.add("E"); allels.add("D");
		
		//important part
		p.process(mixture, new Person());
		
		Person person = new Person();
		ArrayList<PersonMarker> personMarkers = (ArrayList<PersonMarker>) person.getMarker();
		PersonMarker personMarker = new PersonMarker();
		personMarkers.add(personMarker);
		ArrayList<String> personAllels = (ArrayList<String>) personMarker.getAllel();
		personAllels.add("A"); personAllels.add("D");
		
		Solution expectedSolution = new Solution();
		ArrayList<SolutionMarker> solutionMarkers = (ArrayList<SolutionMarker>) expectedSolution.getMarker();
		SolutionMarker solutionMarker = new SolutionMarker();
		solutionMarkers.add(solutionMarker);
		ArrayList<ProfileCombination> combinations = (ArrayList<ProfileCombination>) solutionMarker.getProfileCombination();
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","A","D","C","E"))) );		//TODO different order in this two rows
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","C","A","D","B","E"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","A","E","B","C"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","B","C","E"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","C","B","E"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","C","C","E"))) );		
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","C","D","E"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","C","E","E"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","D","C","E"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","E","C","C"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","E","C","D"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","E","C","E"))) );
		
		assertTrue("", expectedSolution.equals(
				p.process( person ) ) );
		
	}
	
	@Test
	public void personWith2MarkersTest() throws ErrorInInputDataException{
		DNAProcessor p = new DNAProcessor();
		
		Mixture mixture = new Mixture();
		ArrayList<MixtureMarker> markers = (ArrayList<MixtureMarker>) mixture.getMarker();
		MixtureMarker marker = new MixtureMarker();
		markers.add(marker);
		ArrayList<String> allels = (ArrayList<String>) marker.getAllel();
		allels.add("A"); allels.add("B");
		marker = new MixtureMarker();
		markers.add(marker);
		allels = (ArrayList<String>) marker.getAllel();
		allels.add("11"); allels.add("12"); allels.add("13"); allels.add("14"); allels.add("15"); allels.add("16");
		
		//important part
		p.process(mixture, new Person());
		
		Person person = new Person();
		ArrayList<PersonMarker> personMarkers = (ArrayList<PersonMarker>) person.getMarker();
		PersonMarker personMarker = new PersonMarker();
		personMarkers.add(personMarker);
		ArrayList<String> personAllels = (ArrayList<String>) personMarker.getAllel();
		personAllels.add("A"); personAllels.add("B");
		personMarker = new PersonMarker();
		personMarkers.add(personMarker);
		personAllels = (ArrayList<String>) personMarker.getAllel();
		personAllels.add("11"); personAllels.add("15");

		Solution expectedSolution = new Solution();
		ArrayList<SolutionMarker> solutionMarkers = (ArrayList<SolutionMarker>) expectedSolution.getMarker();
		SolutionMarker solutionMarker = new SolutionMarker();
		solutionMarkers.add(solutionMarker);
		ArrayList<ProfileCombination> combinations = (ArrayList<ProfileCombination>) solutionMarker.getProfileCombination();
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","A","A","A","A","B"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","A","A","B","A","B"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","A","A","B","B","B"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","A","B","A","B"))) );		
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","A","B","B","B"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","B","B","B","B"))) );
		
		solutionMarker = new SolutionMarker();
		solutionMarkers.add(solutionMarker);
		combinations = (ArrayList<ProfileCombination>) solutionMarker.getProfileCombination();
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("11","15","12","13","14","16"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("11","15","12","14","13","16"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("11","15","12","16","13","14"))) );
		
		assertTrue("", expectedSolution.equals(
				p.process( person ) ) );
	}
	
	//generetes one line (combination) of profiles
	private ProfileCombination generateCombination(ArrayList<String> data){
		ProfileCombination combination = new ProfileCombination();
		ArrayList<PersonMarker> profiles = (ArrayList<PersonMarker>) combination.getMarker();
		for(int i=0; i<data.size(); i+=2){
			PersonMarker profile = new PersonMarker();
			profiles.add(profile);
			ArrayList<String> allels = (ArrayList<String>) profile.getAllel();
			allels.add(data.get(i)); allels.add(data.get(i+1));
		}
		
		return combination;
	}
}
