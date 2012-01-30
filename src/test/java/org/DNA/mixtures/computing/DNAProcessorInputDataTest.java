package org.DNA.mixtures.computing;

import java.util.ArrayList;

import org.DNA.mixtures.data.Mixture;
import org.DNA.mixtures.data.MixtureMarker;
import org.DNA.mixtures.data.Person;
import org.DNA.mixtures.data.PersonMarker;
import org.junit.Test;

public class DNAProcessorInputDataTest {
	
	@Test (expected = ErrorInInputDataException.class)
	public void testNoMarkersInMixture() throws ErrorInInputDataException{
		DNAProcessor p = new DNAProcessor();
		
		p.process(new Mixture(), new Person());
	}
	
	@Test (expected = ErrorInInputDataException.class)
	public void testNoVariantsForMarker() throws ErrorInInputDataException{
		DNAProcessor p = new DNAProcessor();
		Mixture mixture = new Mixture();
		ArrayList<MixtureMarker> markers = (ArrayList<MixtureMarker>) mixture.getMarker();
		MixtureMarker marker = new MixtureMarker();
		markers.add(marker);
		ArrayList<String> allels = (ArrayList<String>) marker.getAllel();
		allels.add("A");
		marker = new MixtureMarker();
		markers.add(marker);
		
		p.process(mixture, new Person());
	}
	
	@Test (expected = ErrorInInputDataException.class)
	public void testMoreThan3PeopleInMixture() throws ErrorInInputDataException{
		DNAProcessor p = new DNAProcessor();
		Mixture mixture = new Mixture();
		ArrayList<MixtureMarker> markers = (ArrayList<MixtureMarker>) mixture.getMarker();
		MixtureMarker marker = new MixtureMarker();
		markers.add(marker);
		ArrayList<String> allels = (ArrayList<String>) marker.getAllel();
		allels.add("A"); allels.add("B"); allels.add("C");
		allels.add("D"); allels.add("E"); allels.add("F");
		allels.add("G");
		
		p.process(mixture, new Person());
	}
	
	@Test (expected = ErrorInInputDataException.class)
	public void testWrongNoOfAllelsForPerson() throws ErrorInInputDataException{
		DNAProcessor p = new DNAProcessor();
		Mixture mixture = new Mixture();
		ArrayList<MixtureMarker> markers = (ArrayList<MixtureMarker>) mixture.getMarker();
		MixtureMarker marker = new MixtureMarker();
		markers.add(marker);
		ArrayList<String> allels = (ArrayList<String>) marker.getAllel();
		allels.add("A"); allels.add("B");
		
		Person person = new Person();
		ArrayList<PersonMarker> personMarkers = (ArrayList<PersonMarker>) person.getMarker();
		PersonMarker personMarker = new PersonMarker();
		personMarkers.add(personMarker);
		ArrayList<String> genotype = (ArrayList<String>) personMarker.getAllel();
		genotype.add("A"); genotype.add("A");
		
		personMarker =  new PersonMarker();
		personMarkers.add(personMarker);
		genotype = (ArrayList<String>) personMarker.getAllel();
		genotype.add("A");
		
		p.process(mixture, person);
	}
	
	//person against mixture
	@Test (expected = ErrorInInputDataException.class)
	public void testDifferentNoOfMarkers() throws ErrorInInputDataException{
		DNAProcessor p = new DNAProcessor();
		Mixture mixture = new Mixture();
		ArrayList<MixtureMarker> markers = (ArrayList<MixtureMarker>) mixture.getMarker();
		MixtureMarker marker = new MixtureMarker();
		markers.add(marker);
		ArrayList<String> allels = (ArrayList<String>) marker.getAllel();
		allels.add("A");
		
		Person person = new Person();
		ArrayList<PersonMarker> personMarkers = (ArrayList<PersonMarker>) person.getMarker();
		PersonMarker personMarker = new PersonMarker();
		personMarkers.add(personMarker);
		ArrayList<String> genotype = (ArrayList<String>) personMarker.getAllel();
		genotype.add("A"); genotype.add("A");
		
		personMarker = new PersonMarker();
		personMarkers.add(personMarker);
		genotype = (ArrayList<String>) personMarker.getAllel();
		genotype.add("A"); genotype.add("A");
		
		p.process(mixture, person);
	}
	
	//also person against mixture
	@Test (expected = ErrorInInputDataException.class)
	public void testNoSuchAllelsInMixture() throws ErrorInInputDataException{
		DNAProcessor p = new DNAProcessor();
		Mixture mixture = new Mixture();
		ArrayList<MixtureMarker> markers = (ArrayList<MixtureMarker>) mixture.getMarker();
		MixtureMarker marker = new MixtureMarker();
		markers.add(marker);
		ArrayList<String> allels = (ArrayList<String>) marker.getAllel();
		allels.add("A"); allels.add("B"); allels.add("C");
		
		Person person = new Person();
		ArrayList<PersonMarker> personMarkers = (ArrayList<PersonMarker>) person.getMarker();
		PersonMarker personMarker = new PersonMarker();
		personMarkers.add(personMarker);
		ArrayList<String> genotype = (ArrayList<String>) personMarker.getAllel();
		genotype.add("A"); genotype.add("a");
		
		p.process(mixture, person);
	}
	

}
