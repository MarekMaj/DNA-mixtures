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

public class AlgorithmsTest {

	@Test
	public void testMixtureWithDifferentNoOfVariants(){
		Algorithms alg = new Algorithms(2);
		Mixture mixture = createMixture1M(new ArrayList<String>(Arrays.asList("A")));
		
		Solution expectedSolution = new Solution();
		ArrayList<SolutionMarker> solutionMarkers = (ArrayList<SolutionMarker>) expectedSolution.getMarker();
		SolutionMarker solutionMarker = new SolutionMarker();
		solutionMarkers.add(solutionMarker);
		ArrayList<ProfileCombination> combinations = (ArrayList<ProfileCombination>) solutionMarker.getProfileCombination();
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","A","A","A"))) );
		
		assertTrue("", expectedSolution.equals(
				alg.calculateProfiles( (ArrayList<MixtureMarker>)mixture.getMarker() ) ) );
		
		mixture = createMixture1M(new ArrayList<String>(Arrays.asList("A", "B")));
		combinations.clear();
		
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","A","A","B") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","A","B","B") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","A","B") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","B","B") ) ) );
		
		assertTrue("", expectedSolution.equals(
				alg.calculateProfiles( (ArrayList<MixtureMarker>)mixture.getMarker() ) ) );
		
		mixture = createMixture1M(new ArrayList<String>(Arrays.asList("A", "B", "C")));
		combinations.clear();
		
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","A","B","C") ) ) );		
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","A","C") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","B","C") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","C","C") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","C","B","B") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","C","B","C") ) ) );

		assertTrue("", expectedSolution.equals(
				alg.calculateProfiles( (ArrayList<MixtureMarker>)mixture.getMarker() ) ) );
		
		mixture = createMixture1M(new ArrayList<String>(Arrays.asList("A", "B", "C", "D")));
		combinations.clear();
		
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","C","D") ) ) );		
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","C","B","D") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","C") ) ) );
		
		assertTrue("", expectedSolution.equals(
				alg.calculateProfiles( (ArrayList<MixtureMarker>)mixture.getMarker() ) ) );
		
		//for three people
		alg = new Algorithms(3);
		mixture = createMixture1M(new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E")));
		combinations.clear();
		
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","A","B","C","D","E") ) ) );		
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","A","B","D","C","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","A","B","E","C","D") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","A","C","D","E") ) ) );	
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","A","D","C","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","A","E","C","D") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","B","C","D","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","B","D","C","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","B","E","C","D") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","C","C","D","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","C","D","C","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","C","D","D","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","C","D","E","E") ) ) );	 
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","C","E","D","D") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","C","E","D","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","C","A","D","B","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","C","A","E","B","D") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","C","B","B","D","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","C","B","C","D","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","C","B","D","B","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","C","B","D","C","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","C","B","D","D","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","C","B","D","E","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","C","B","E","C","D") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","C","B","E","D","D") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","C","B","E","D","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","A","E","B","C") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","B","C","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","C","B","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","C","C","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","C","D","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","C","E","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","D","C","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","E","C","C") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","E","C","D") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","E","C","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","E","B","B","C","D") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","E","B","C","B","D") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","E","B","C","C","D") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","E","B","C","D","D") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","E","B","C","D","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","E","B","D","C","C") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","E","B","D","C","D") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","E","B","D","C","E") ) ) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","E","B","E","C","D") ) ) );
	
		assertTrue("", expectedSolution.equals(
				alg.calculateProfiles( (ArrayList<MixtureMarker>)mixture.getMarker() ) ) );
		
		mixture = createMixture1M(new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F")));
		combinations.clear();
		
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","C","D","E","F"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","C","E","D","F"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","C","F","D","E"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","C","B","D","E","F"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","C","B","E","D","F"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","C","B","F","D","E"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","C","E","F"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","E","C","F"))) );		
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","B","F","C","E"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","E","B","C","D","F"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","E","B","D","C","F"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","E","B","F","C","D"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","F","B","C","D","E"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","F","B","D","C","E"))) );	
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","F","B","E","C","D"))) );
		
		assertTrue("", expectedSolution.equals(
				alg.calculateProfiles( (ArrayList<MixtureMarker>)mixture.getMarker() ) ) );
	}
	
	@Test
	public void testMixture2PWithGivenHomoProfile(){
		Algorithms alg = new Algorithms(2);
		
		Mixture mixture = createMixture1M(new ArrayList<String>(Arrays.asList("A","B","C")));
		Person person = createPerson1M(new ArrayList<String>(Arrays.asList("C","C")));
		
		Solution expectedSolution = new Solution();
		ArrayList<SolutionMarker> solutionMarkers = (ArrayList<SolutionMarker>) expectedSolution.getMarker();
		SolutionMarker solutionMarker = new SolutionMarker();
		solutionMarkers.add(solutionMarker);
		ArrayList<ProfileCombination> combinations = (ArrayList<ProfileCombination>) solutionMarker.getProfileCombination();
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("C","C","A","B"))) );
		
		assertTrue("", expectedSolution.equals(
				alg.calculateProfiles( (ArrayList<MixtureMarker>)mixture.getMarker(), (ArrayList<PersonMarker>)person.getMarker() ) ) );
	}
	
	@Test
	public void testMixture2PWithGivenHeteroProfile(){
		Algorithms alg = new Algorithms(2);
		
		Mixture mixture = createMixture1M(new ArrayList<String>(Arrays.asList("A","B","C")));
		Person person = createPerson1M(new ArrayList<String>(Arrays.asList("A","B")));
		
		Solution expectedSolution = new Solution();
		ArrayList<SolutionMarker> solutionMarkers = (ArrayList<SolutionMarker>) expectedSolution.getMarker();
		SolutionMarker solutionMarker = new SolutionMarker();
		solutionMarkers.add(solutionMarker);
		ArrayList<ProfileCombination> combinations = (ArrayList<ProfileCombination>) solutionMarker.getProfileCombination();
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","A","C"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","B","C"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","C","C"))) );
		
		assertTrue("", expectedSolution.equals(
				alg.calculateProfiles( (ArrayList<MixtureMarker>)mixture.getMarker(), (ArrayList<PersonMarker>)person.getMarker() ) ) );
	}
	
	@Test
	public void testMixture3PWithGivenProfile(){
		Algorithms alg = new Algorithms(3);
		
		Mixture mixture = createMixture1M(new ArrayList<String>(Arrays.asList("A","B","C","D","E")));
		Person person = createPerson1M(new ArrayList<String>(Arrays.asList("A","D")));
		
		Solution expectedSolution = new Solution();
		ArrayList<SolutionMarker> solutionMarkers = (ArrayList<SolutionMarker>) expectedSolution.getMarker();
		SolutionMarker solutionMarker = new SolutionMarker();
		solutionMarkers.add(solutionMarker);
		ArrayList<ProfileCombination> combinations = (ArrayList<ProfileCombination>) solutionMarker.getProfileCombination();
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","A","B","C","E"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","D","A","C","B","E"))) );
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
				alg.calculateProfiles( (ArrayList<MixtureMarker>)mixture.getMarker(), (ArrayList<PersonMarker>)person.getMarker() ) ) );
	}
	
	@Test
	public void testMixtureWith3Markers(){
		Algorithms alg = new Algorithms(3);
		
		Mixture mixture = new Mixture();
		ArrayList<MixtureMarker> markers = (ArrayList<MixtureMarker>) mixture.getMarker();
		MixtureMarker marker = new MixtureMarker();
		markers.add(marker);
		ArrayList<String> allels = (ArrayList<String>) marker.getAllel();
		allels.add("A"); allels.add("B");
		marker = new MixtureMarker();
		markers.add(marker);
		allels = (ArrayList<String>) marker.getAllel();
		allels.add("12");
		marker = new MixtureMarker();
		markers.add(marker);
		allels = (ArrayList<String>) marker.getAllel();
		allels.add("11"); allels.add("12"); allels.add("13"); allels.add("14"); allels.add("15"); allels.add("16");
		
		Solution expectedSolution = new Solution();
		ArrayList<SolutionMarker> solutionMarkers = (ArrayList<SolutionMarker>) expectedSolution.getMarker();
		SolutionMarker solutionMarker = new SolutionMarker();
		solutionMarkers.add(solutionMarker);
		ArrayList<ProfileCombination> combinations = (ArrayList<ProfileCombination>) solutionMarker.getProfileCombination();
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","A","A","A","A","B"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","A","A","A","B","B"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","A","A","B","A","B"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","A","A","B","B","B"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","A","B","B","B","B"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","A","B","A","B"))) );		
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","A","B","B","B"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","B","B","B","B"))) );
		
		solutionMarker = new SolutionMarker();
		solutionMarkers.add(solutionMarker);
		combinations = (ArrayList<ProfileCombination>) solutionMarker.getProfileCombination();
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("12","12","12","12","12","12"))) );
		
		solutionMarker = new SolutionMarker();
		solutionMarkers.add(solutionMarker);
		combinations = (ArrayList<ProfileCombination>) solutionMarker.getProfileCombination();
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("11","12","13","14","15","16"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("11","12","13","15","14","16"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("11","12","13","16","14","15"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("11","13","12","14","15","16"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("11","13","12","15","14","16"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("11","13","12","16","14","15"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("11","14","12","13","15","16"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("11","14","12","15","13","16"))) );		
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("11","14","12","16","13","15"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("11","15","12","13","14","16"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("11","15","12","14","13","16"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("11","15","12","16","13","14"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("11","16","12","13","14","15"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("11","16","12","14","13","15"))) );	
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("11","16","12","15","13","14"))) );		

		assertTrue("", expectedSolution.equals(
				alg.calculateProfiles( (ArrayList<MixtureMarker>)mixture.getMarker() ) ) );
	}
	
	@Test
	public void testMixtureWith3MarkersWithGivenProfile(){
		Algorithms alg = new Algorithms(3);
		
		Mixture mixture = new Mixture();
		ArrayList<MixtureMarker> markers = (ArrayList<MixtureMarker>) mixture.getMarker();
		MixtureMarker marker = new MixtureMarker();
		markers.add(marker);
		ArrayList<String> allels = (ArrayList<String>) marker.getAllel();
		allels.add("A"); allels.add("B");
		marker = new MixtureMarker();
		markers.add(marker);
		allels = (ArrayList<String>) marker.getAllel();
		allels.add("12");
		marker = new MixtureMarker();
		markers.add(marker);
		allels = (ArrayList<String>) marker.getAllel();
		allels.add("11"); allels.add("12"); allels.add("13"); allels.add("14"); allels.add("15"); allels.add("16");
		
		Person person = new Person();
		ArrayList<PersonMarker> personMarkers = (ArrayList<PersonMarker>) person.getMarker();
		PersonMarker personMarker = new PersonMarker();
		personMarkers.add(personMarker);
		ArrayList<String> personAllels = (ArrayList<String>) personMarker.getAllel();
		personAllels.add("A"); personAllels.add("B");
		personMarker = new PersonMarker();
		personMarkers.add(personMarker);
		personAllels = (ArrayList<String>) personMarker.getAllel();
		personAllels.add("12"); personAllels.add("12");
		personMarker = new PersonMarker();
		personMarkers.add(personMarker);
		personAllels = (ArrayList<String>) personMarker.getAllel();
		personAllels.add("11"); personAllels.add("15");
		
		Solution expectedSolution = new Solution();
		ArrayList<SolutionMarker> solutionMarkers = (ArrayList<SolutionMarker>) expectedSolution.getMarker();
		SolutionMarker solutionMarker = new SolutionMarker();
		solutionMarkers.add(solutionMarker);
		ArrayList<ProfileCombination> combinations = (ArrayList<ProfileCombination>) solutionMarker.getProfileCombination();
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","A","A","A","A"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","A","A","A","B"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","A","A","B","B"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","A","B","A","B"))) );		
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","A","B","B","B"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("A","B","B","B","B","B"))) );
		
		solutionMarker = new SolutionMarker();
		solutionMarkers.add(solutionMarker);
		combinations = (ArrayList<ProfileCombination>) solutionMarker.getProfileCombination();
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("12","12","12","12","12","12"))) );

		solutionMarker = new SolutionMarker();
		solutionMarkers.add(solutionMarker);
		combinations = (ArrayList<ProfileCombination>) solutionMarker.getProfileCombination();
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("11","15","12","13","14","16"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("11","15","12","14","13","16"))) );
		combinations.add( generateCombination(new ArrayList<String>(Arrays.asList("11","15","12","16","13","14"))) );
		
		assertTrue("", expectedSolution.equals(
				alg.calculateProfiles( (ArrayList<MixtureMarker>)mixture.getMarker(), (ArrayList<PersonMarker>)person.getMarker() ) ) );
	}
	
	//create mixture from list of variants, 1M stands for 1 Marker
	private Mixture createMixture1M(ArrayList<String> variants){
		Mixture mixture = new Mixture();
		ArrayList<MixtureMarker> markers = (ArrayList<MixtureMarker>) mixture.getMarker();
		MixtureMarker marker = new MixtureMarker();
		markers.add(marker);
		ArrayList<String> allels = (ArrayList<String>) marker.getAllel();
		for(String allel : variants)
			allels.add(allel);
		
		return mixture;
	}
	
	//create person with one marker from list of variants
	private Person createPerson1M(ArrayList<String> variants){
		
		Person person = new Person();
		ArrayList<PersonMarker> markers = (ArrayList<PersonMarker>) person.getMarker();
		PersonMarker marker = new PersonMarker();
		markers.add(marker);
		ArrayList<String> allels = (ArrayList<String>) marker.getAllel();
		for(String allel : variants)
			allels.add(allel);
		
		return person;
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
