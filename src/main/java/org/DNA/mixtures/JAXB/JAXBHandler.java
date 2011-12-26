package org.DNA.mixtures.JAXB;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.DNA.mixtures.data.MixtureType;
import org.DNA.mixtures.data.PersonType;
import org.xml.sax.SAXException;

public class JAXBHandler {
	
	@SuppressWarnings("unchecked")
	public MixtureType createMixture(InputStream is){
        JAXBElement<MixtureType> obj = null;
        try {
            JAXBContext jc = JAXBContext.newInstance("org.DNA.mixtures.data");
            Unmarshaller unmarshaller = jc.createUnmarshaller();

            //Setting the Validation
            SchemaFactory schemaFactory = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );

            URL url = JAXBHandler.class.getResource("JAXBHandler.class");
            String className = url.getFile();
            String s = className.substring(0, className.indexOf("WEB-INF"));

            /*String r = JAXBHandler.class.getProtectionDomain().getCodeSource().getLocation().getPath();

            System.out.println(r +"     albo   "+s+"schemas/DNAmixture-schema.xsd");
            System.out.println( "  albo  " + url.getPath());
            */
            Schema schema = schemaFactory.newSchema(new File(s+"schemas/DNAmixture-schema.xsd"));
            unmarshaller.setSchema(schema);
            obj = (JAXBElement<MixtureType>) unmarshaller.unmarshal(is);
        } catch (JAXBException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SAXException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return obj.getValue();
	}
	
	@SuppressWarnings("unchecked")
	public PersonType createPerson(InputStream is){
        JAXBElement<PersonType> obj = null;
        try {
            JAXBContext jc = JAXBContext.newInstance("org.DNA.mixtures.data");
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            //Setting the Validation
            SchemaFactory schemaFactory = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
            URL url = JAXBHandler.class.getResource("JAXBHandler.class");
            String className = url.getFile();
            String s = className.substring(0, className.indexOf("WEB-INF"));
            Schema schema = schemaFactory.newSchema(new File(s+"schemas/DNAperson-schema.xsd"));
            unmarshaller.setSchema(schema);
            obj = (JAXBElement<PersonType>) unmarshaller.unmarshal(is);
        } catch (JAXBException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SAXException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return obj.getValue();
    }
}