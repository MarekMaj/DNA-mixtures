
package org.DNA.mixtures.data;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for solutionMarker complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solutionMarker">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="profileCombination" type="{}profileCombination"/>
 *       &lt;/choice>
 *       &lt;attribute name="name" type="{}stringType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solutionMarker", propOrder = {
    "profileCombination"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:31:42+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
public class SolutionMarker {

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:31:42+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected List<ProfileCombination> profileCombination;
    @XmlAttribute
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:31:42+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String name;
    
    public SolutionMarker(){
    	
    }
    
    public SolutionMarker(String value){
    	name = value;
    }
    /**
     * Gets the value of the profileCombination property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the profileCombination property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProfileCombination().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProfileCombination }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:31:42+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public List<ProfileCombination> getProfileCombination() {
        if (profileCombination == null) {
            profileCombination = new ArrayList<ProfileCombination>();
        }
        return this.profileCombination;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:31:42+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:31:42+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setName(String value) {
        this.name = value;
    }
    
	@Override
	public boolean equals(Object obj) {
		//check for self-comparison
		if(this == obj) return true;
		
		if( !(obj instanceof SolutionMarker) )
			return false;
		
		SolutionMarker solutionMarker = (SolutionMarker) obj;
		
		if( !(name == null ? solutionMarker.name == null : this.equals(solutionMarker.name)) )
			return false;	
			
		if(profileCombination == null && solutionMarker.profileCombination == null)
			return true;
		else if(profileCombination == null || solutionMarker.profileCombination == null)
			return false;
		else{	
			if(profileCombination.size() != solutionMarker.profileCombination.size())
				return false;
			boolean result = true;
			for(int i=0; i<profileCombination.size(); ++i){
				result = ( (profileCombination.get(i) == null) ? solutionMarker.profileCombination.get(i) == null : profileCombination.get(i).equals(solutionMarker.profileCombination.get(i)) );
				if(!result)
					return false;
			}
		}
		return true;
	}    

	@Override
	public int hashCode() {
		
		final int prime = 29;
		int result = 1;
		if(name != null)
			result = prime + name.hashCode();
		for(ProfileCombination p : profileCombination)
		    result = result * prime + p.hashCode();
		return result;
	}
}
