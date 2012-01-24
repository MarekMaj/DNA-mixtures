
package org.DNA.mixtures.data;

import javax.annotation.Generated;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for person complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="person">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="markers" type="{}markers"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "person", propOrder = {

})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:29:39+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
public class Person {

    @XmlElementWrapper
    @XmlElement(required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:29:39+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
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
