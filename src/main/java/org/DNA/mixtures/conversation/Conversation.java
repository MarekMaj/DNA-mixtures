package org.DNA.mixtures.conversation;

import org.DNA.mixtures.computing.DNAProcessor;
import org.DNA.mixtures.data.PersonType;

import java.io.Serializable;

import javax.annotation.PostConstruct;
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
    private Object results;

	@Produces @Named
	private FileUploader fileUploader = new FileUploader();
	
	public Conversation() {
		super();
	}

    @PostConstruct
    public void setTimeout(){
        conversation.setTimeout(600000);
    }

	public FileUploader getFileUploader() {
		return fileUploader;
	}

	public String start(){
		if (conversation.isTransient()){
			conversation.begin();
		}
		return "insert";
	}

    public String compute(){
        if (fileUploader.getMixture() == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nie wprowadzileś poprawnego pliku opisującego mieszaninę"));
            return null;
        }
        results = dnaProcessor.process(fileUploader.getMixture(), fileUploader.getPerson() == null ? new PersonType() : fileUploader.getPerson());
        // TODO przechwycic blędy i wyświetlic np. nie zgadza sie liczba markerów w plikach
        // liczba ludzi wieksza niz 3, profil takiej osoby nie mógł się znaleźć w tej mieszaninie itp
        return "compute";
    }

    public void computePerson(){
        if (fileUploader.getPerson() == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nie wprowadzileś poprawnego pliku opisującego profil osoby"));
        }
        results = dnaProcessor.process(fileUploader.getPerson());

        // TODO przechwycic blędy i wyświetlic np. nie zgadza sie liczba markerów w plikach
        // liczba ludzi wieksza niz 3 itp
    }

	public String end(){
		if (!conversation.isTransient()){
			conversation.end();
		}
		return "exit";
	}
}
