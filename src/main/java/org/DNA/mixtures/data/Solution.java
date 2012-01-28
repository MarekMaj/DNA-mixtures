
package org.DNA.mixtures.data;

import javax.annotation.Generated;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for solution complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solution">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="markers" type="{}markers"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solution", propOrder = {

})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:31:42+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
public class Solution {

    @XmlElementWrapper
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:31:42+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected List<SolutionMarker> marker;

    /**
     * Gets the value of the marker property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the marker property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMarker().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SolutionMarker }
     *
     *
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:31:42+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public List<SolutionMarker> getMarker() {
        if (marker == null) {
            marker = new ArrayList<SolutionMarker>();
        }
        return this.marker;
    }

	@Override
	public boolean equals(Object obj) {
		//check for self-comparison
		if(this == obj) return true;
		
		if( !(obj instanceof Solution) )
			return false;
		
		Solution solution = (Solution) obj;
		
		if(marker == null && solution.marker == null)
			return false;
		else if(marker == null || solution.marker == null)
			return false;
		else{
			if(marker.size() != solution.marker.size())
				return false;
			boolean result = true;
			for(int i=0; i<marker.size(); ++i){
				result = ( (marker.get(i) == null) ? solution.marker.get(i) == null : marker.get(i).equals(solution.marker.get(i)) );
				if(!result)
					return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		for(SolutionMarker m : marker)
			result = result * prime + m.hashCode();
		return result;
		
	}	
}
