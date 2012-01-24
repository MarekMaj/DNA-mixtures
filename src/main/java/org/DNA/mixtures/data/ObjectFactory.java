
package org.DNA.mixtures.data;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.DNA.mixtures.data package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Solution_QNAME = new QName("", "solution");
    private final static QName _Mixture_QNAME = new QName("", "mixture");
    private final static QName _Person_QNAME = new QName("", "person");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.DNA.mixtures.data
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProfileCombination }
     *
     */
    public ProfileCombination createProfileCombination() {
        return new ProfileCombination();
    }

    /**
     * Create an instance of {@link SolutionMarker }
     *
     */
    public SolutionMarker createSolutionMarker() {
        return new SolutionMarker();
    }

    /**
     * Create an instance of {@link Solution }
     *
     */
    public Solution createSolution() {
        return new Solution();
    }

    /**
     * Create an instance of {@link PersonMarker }
     *
     */
    public PersonMarker createPersonMarker() {
        return new PersonMarker();
    }

    /**
     * Create an instance of {@link Person }
     *
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link MixtureMarker }
     *
     */
    public MixtureMarker createMixtureMarker() {
        return new MixtureMarker();
    }

    /**
     * Create an instance of {@link Mixture }
     *
     */
    public Mixture createMixture() {
        return new Mixture();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Mixture }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "mixture")
    public JAXBElement<Mixture> createMixture(Mixture value) {
        return new JAXBElement<Mixture>(_Mixture_QNAME, Mixture.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Person }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "person")
    public JAXBElement<Person> createPerson(Person value) {
        return new JAXBElement<Person>(_Person_QNAME, Person.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Solution }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "", name = "solution")
    public JAXBElement<Solution> createSolution(Solution value) {
        return new JAXBElement<Solution>(_Solution_QNAME, Solution.class, null, value);
    }



}
