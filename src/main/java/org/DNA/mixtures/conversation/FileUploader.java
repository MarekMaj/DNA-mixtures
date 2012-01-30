package org.DNA.mixtures.conversation;

import org.DNA.mixtures.JAXB.JAXBHandler;
import org.DNA.mixtures.data.Mixture;
import org.DNA.mixtures.data.Person;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;


public class FileUploader {

    private JAXBHandler handler = new JAXBHandler();
	private Mixture mixture;
	private Person person;

    private UploadedFile uploadedMixtureFile;
    private UploadedFile uploadedPersonFile;

	public FileUploader() {
		super();
	}

    public void mixtureListener(FileUploadEvent event) throws Exception {
        clearMixture();
        this.uploadedMixtureFile = event.getUploadedFile();
        this.mixture = handler.createMixture(this.uploadedMixtureFile.getInputStream());
    }
 
    public void personListener(FileUploadEvent event) throws Exception {
        clearPerson();
        this.uploadedPersonFile = event.getUploadedFile();
        this.person = handler.createPerson(this.uploadedPersonFile.getInputStream());
    }

    public void clearMixture (){
        this.uploadedMixtureFile = null;
        this.mixture = null;
    }

    public void clearPerson (){
        this.uploadedPersonFile = null;
        this.person = null;
    }

    public UploadedFile getUploadedPersonFile() {
        return uploadedPersonFile;
    }

    public Mixture getMixture() {
        return mixture;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person){
        this.person = person;
    }

    public UploadedFile getUploadedMixtureFile() {
        return uploadedMixtureFile;
    }
}

