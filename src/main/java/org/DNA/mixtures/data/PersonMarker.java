
package org.DNA.mixtures.data;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for personMarker complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="personMarker">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="2" minOccurs="2">
 *         &lt;element name="allel" type="{}stringType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{}stringType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "personMarker", propOrder = {
    "allel"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:31:42+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
public class PersonMarker {

    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:31:42+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected List<String> allel;
    @XmlAttribute
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:31:42+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected String name;

    /**
     * Gets the value of the allel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:31:42+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public List<String> getAllel() {
        if (allel == null) {
            allel = new ArrayList<String>();
        }
        return this.allel;
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
		
		if( !(obj instanceof PersonMarker) )
			return false;
		
		PersonMarker personMarker = (PersonMarker) obj;
		
		if( !(name == null ? personMarker.name == null : this.equals(personMarker.name)) )
			return false;	
			
		if(allel == null && personMarker.allel == null)
			return true;
		else if(allel == null || personMarker.allel == null)
			return false;
		else{	
			if(allel.size() != personMarker.allel.size())
				return false;
			boolean result = true;
			
			//part responsible for sorting allels, thanks to it order of allels doesn't matter
			if(allel.size() == 2){
				int order1 = allel.get(0).compareTo(allel.get(1));
				int order2 = personMarker.allel.get(0).compareTo(personMarker.allel.get(1));
				if(order1 > 0){
					String temp = allel.get(0);
					allel.set(0, allel.get(1));
					allel.set(1, temp);
				}
				if(order2 > 0){
					String temp = personMarker.allel.get(0);
					personMarker.allel.set(0, personMarker.allel.get(1));
					personMarker.allel.set(1, temp);
				}
			}
			
			for(int i=0; i<allel.size(); ++i){
				result = ( (allel.get(i) == null) ? personMarker.allel.get(i) == null : allel.get(i).equals(personMarker.allel.get(i)) );
				if(!result)
					return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		
		final int prime = 23;
		int result = 1;
		if(name != null)
			result = prime + name.hashCode();
		for(String s : allel)
		    result = result * prime + s.hashCode();
		
		return result;
	}
}
