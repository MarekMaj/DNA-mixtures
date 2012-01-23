package org.DNA.mixtures.data;

import java.util.ArrayList;
import java.util.List;

public class Marker {
	protected List<MarkerType> combinations;
	protected String name;
	
	public Marker(){
		
	}
	
	public Marker(String n){
		name = n;
	}
	
    public List<MarkerType> getCombinations() {
        if (combinations == null) 
            combinations = new ArrayList<MarkerType>();
        
        return combinations;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String value) {
        name = value;
    }
}
