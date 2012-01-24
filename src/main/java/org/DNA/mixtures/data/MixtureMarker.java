
package org.DNA.mixtures.data;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for mixtureMarker complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="mixtureMarker">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element name="allel" type="{}stringType"/>
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
@XmlType(name = "mixtureMarker", propOrder = {
    "allel"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:28:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
public class MixtureMarker {

    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:28:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    protected List<String> allel;
    @XmlAttribute
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:28:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
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
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:28:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
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
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:28:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
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
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2012-01-24T03:28:20+01:00", comments = "JAXB RI vJAXB 2.1.10 in JDK 6")
    public void setName(String value) {
        this.name = value;
    }

}
