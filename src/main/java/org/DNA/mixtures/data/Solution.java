package org.DNA.mixtures.data;

import java.util.ArrayList;
import java.util.List;
/** Class represents algorithm's result
 * 
 * @author Krzysztof Korbacz
 * 
 */
public class Solution {
	
	protected List<Marker> markers;
	
    public List<Marker> getMarkers() {
        if (markers == null) {
            markers = new ArrayList<Marker>();
        }
        return markers;
    }
}
