package org.DNA.mixtures.conversation;

import org.DNA.mixtures.JAXB.JAXBHandler;
import org.DNA.mixtures.data.Mixture;
import org.DNA.mixtures.data.Person;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

import java.io.IOException;


public class FileUploader {

    private JAXBHandler handler = new JAXBHandler();
	private Mixture mixture;
	private Person person;

    private UploadedFile uploadedMixtureFile;
    private UploadedFile uploadedPersonFile;

	public FileUploader() {
		super();
	}

    /** Method listens for {@link FileUploadEvent} and parses given mixture file. Result is saved in
     * mixture member.
     *
     * @param event          file upload event
     * @throws IOException   wrong io
     */
    public void mixtureListener(FileUploadEvent event) throws IOException {
        clearMixture();
        this.uploadedMixtureFile = event.getUploadedFile();
        this.mixture = handler.createMixture(this.uploadedMixtureFile.getInputStream());
    }

    /** Method listens for {@link FileUploadEvent} and parses given person file. Result is saved in
     * person member.
     *
     * @param event          file upload event
     * @throws IOException   wrong io
     */
    public void personListener(FileUploadEvent event) throws IOException {
        clearPerson();
        this.uploadedPersonFile = event.getUploadedFile();
        this.person = handler.createPerson(this.uploadedPersonFile.getInputStream());
    }

    /**
     *  Clears mixture and uploadedMixtureFile members.
     */
    public void clearMixture (){
        this.uploadedMixtureFile = null;
        this.mixture = null;
    }

    /**
     *  Clears mixture and uploadedMixtureFile members.
     */
    public void clearPerson (){
        this.uploadedPersonFile = null;
        this.person = null;
    }

    // getters and setters
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

