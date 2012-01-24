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
		return "Pair [first=" + first + ", second=" + second + "]";
	}			
}
