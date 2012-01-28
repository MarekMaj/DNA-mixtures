package org.DNA.mixtures.computing;

public class Genotype{
	int first;
	int second;
	
	public Genotype(int f, int s){
		first = f;
		second = s;
	}

	@Override
	public String toString() {
		return "Genotype [first=" + first + ", second=" + second + "]";
	}			
}
