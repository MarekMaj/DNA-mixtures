package org.DNA.mixtures.conversation;

import org.DNA.mixtures.computing.DNAProcessor;
import org.DNA.mixtures.data.PersonType;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@ConversationScoped
@Named
public class Conversation implements Serializable{

	@Inject
	private javax.enterprise.context.Conversation conversation;
	@Inject
    private DNAProcessor dnaProcessor;
    private List<PersonType> results;

	@Produces @Named
	private FileUploader fileUploader = new FileUploader();
	
	public Conversation() {
		super();
	}
	
	public FileUploader getFileUploader() {
		return fileUploader;
	}

	public String start(){
        System.out.println("uruchamia sie start");
		if (conversation.isTransient()){
			conversation.begin();
		}
		return "insert";
	}

    public String compute(){
        // TODO nie uruchamia sie
        System.out.println("uruchamiam compute");
        if (fileUploader.getMixture() == null){
            FacesContext.getCurrentInstance().addMessage("Fds", new FacesMessage("Nie wprowadziles poprawnego pliku opisujacego mieszanine"));
            // TODO wyświetlac bledy faces
            return null;
        }
        results = dnaProcessor.process(fileUploader.getMixture(), fileUploader.getPerson() == null ? new PersonType() : fileUploader.getPerson());
        // TODO przechwycic blędy i wyświetlic np. nie zgadza sie liczba markerów w plikach
        // liczba ludzi wieksza niz 3 itp
        return "compute";
    }

    // TODO jeszcze jedna metoda z poziomu result.xhtml zeby wprowadzic i obliczyc person profil

	public String end(){
        // TODO nie uruchamia sie
		if (!conversation.isTransient()){
			conversation.end();
		}
		return "exit";
	}
}
