package org.DNA.mixtures.conversation;

import org.DNA.mixtures.computing.DNAProcessor;
import org.DNA.mixtures.computing.ErrorInInputDataException;
import org.DNA.mixtures.data.Person;
import org.DNA.mixtures.data.Solution;
import org.DNA.mixtures.data.SolutionMarker;
import org.richfaces.component.UIExtendedDataTable;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;


@ConversationScoped
@Named
public class Conversation implements Serializable{

    private javax.enterprise.context.Conversation conversation;
    private DNAProcessor dnaProcessor;
    private Solution results;
    private SolutionMarker selectedMarker;
    private Collection<Object> selection;
    private boolean solutionWithPerson;
    @Produces @Named
    private FileUploader fileUploader = new FileUploader();


    public Conversation(){
        super();
    }

    @Inject
    public Conversation(javax.enterprise.context.Conversation conversation, DNAProcessor dnaProcessor1) {
        super();
        this.conversation = conversation;
        conversation.setTimeout(1200000);   // 20min timeout
        this.dnaProcessor = dnaProcessor1;
    }

    public String start(){
        if (conversation.isTransient()){
            conversation.begin();
        }
        return "insert";
    }

    public String end(){
        if (!conversation.isTransient()){
            conversation.end();
        }
        return "exit";
    }

    public String compute(){
        this.selectedMarker = null;
        this.selection.clear();
        if (fileUploader.getMixture() == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nie wprowadzileś poprawnego pliku opisującego mieszaninę"));
            return null;
        }
        try {
            if (fileUploader.getPerson() == null){
                this.solutionWithPerson = false;
                results = dnaProcessor.process(fileUploader.getMixture(), new Person());
            }
            else {
                this.solutionWithPerson = true;
                results = dnaProcessor.process(fileUploader.getMixture(), fileUploader.getPerson());
            }
        }catch (ErrorInInputDataException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nieprawidłowy format: "+e.getMessage() ));
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        }
        return "compute";
    }

    public void computePerson(){
        this.selectedMarker = null;
        this.selection.clear();
        if (fileUploader.getPerson() == null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nie wprowadzileś poprawnego pliku opisującego profil osoby"));
        }
        try {
            results = dnaProcessor.process(fileUploader.getPerson());
        } catch (ErrorInInputDataException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nieprawidłowy format: "+e.getMessage() ));
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return;
        }
        fileUploader.setPerson(null);   // clean person in fileUploader to make possible to insert new Person
    }

    public void selectionListener(AjaxBehaviorEvent event) {
        UIExtendedDataTable dataTable = (UIExtendedDataTable) event.getComponent();
        Object originalKey = dataTable.getRowKey();
        if (!selection.isEmpty()){
            dataTable.setRowKey(selection.iterator().next());
            if (dataTable.isRowAvailable()) {
                this.selectedMarker = (SolutionMarker) dataTable.getRowData();
            }
        }

        dataTable.setRowKey(originalKey);
    }
    // getters and setters

    public FileUploader getFileUploader() {
        return fileUploader;
    }

    public Solution getResults(){
        return this.results;
    }

    public SolutionMarker getSelectedMarker(){
        return this.selectedMarker;
    }

    public void setSelectedMarker(SolutionMarker solutionMarker){
        this.selectedMarker = solutionMarker;
    }

    public Collection<Object> getSelection(){
        return this.selection;
    }

    public void setSelection(Collection<Object> selection) {
        this.selection = selection;
    }

    public boolean isSolutionWithPerson() {
        return solutionWithPerson;
    }
}