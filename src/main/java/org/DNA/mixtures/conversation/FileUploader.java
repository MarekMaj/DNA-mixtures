package org.DNA.mixtures.conversation;

import org.DNA.mixtures.JAXB.JAXBHandler;
import org.DNA.mixtures.data.MixtureType;
import org.DNA.mixtures.data.PersonType;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;


public class FileUploader {

    private JAXBHandler handler = new JAXBHandler();
	private MixtureType mixture;
	private PersonType person;

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

    public MixtureType getMixture() {
        return mixture;
    }

    public PersonType getPerson() {
        return person;
    }

    public UploadedFile getUploadedMixtureFile() {
        return uploadedMixtureFile;
    }
}

