
package org.DNA.mixtures.data;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for profileCombination complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="profileCombination">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded" minOccurs="2">
 *         &lt;element name="marker" type="{}personMarker"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "profileCombination", propOrder = {
    "marker"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:31:42+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
public class ProfileCombination {

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:31:42+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected List<PersonMarker> marker;

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
     * {@link PersonMarker }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:31:42+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public List<PersonMarker> getMarker() {
        if (marker == null) {
            marker = new ArrayList<PersonMarker>();
        }
        return this.marker;
    }

}
