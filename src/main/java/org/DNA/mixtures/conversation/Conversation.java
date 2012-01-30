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
    private SolutionMarker selectedMarker;              // Marker selected in result view.
    private Collection<Object> selection;               // Items selected in result view.
    private boolean solutionWithPerson;                 // Flag states if solution was computed with some person profile.
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

    /**Starts conversation. Turns {@link javax.enterprise.context.Conversation} to long-running.
     *
     * @return          Outcome will be handled by NavigationHandler to resolve new view.
     */
    public String start(){
        if (conversation.isTransient()){
            conversation.begin();
        }
        return "insert";
    }

    /**Starts conversation. Turns {@link javax.enterprise.context.Conversation} to transient state.
     *
     * @return          Outcome will be handled by NavigationHandler to resolve new view.
     */
    public String end(){
        if (!conversation.isTransient()){
            conversation.end();
        }
        return "exit";
    }

    /** Invokes {@link DNAProcessor} in order to compute all possible person profiles in given mixture.
     * This method tries to retrieve Mixture and Person from {@link FileUploader}. Only mixture is
     * obligatory. If successfully loaded, then computes profiles, otherwise sets {@link FacesMessage}.
     *
     * @return          Outcome will be handled by NavigationHandler to resolve new view.
     */
    public String compute(){
        this.selectedMarker = null;                       // clears all selections
        this.selection = null;

        if (fileUploader.getMixture() == null){           // if mixture file is missing or cannot be parsed properly
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Wrong or missing mixture file."));
            return null;
        }
        try {
            if (fileUploader.getPerson() == null){        // if person file is missing or cannot be parsed properly
                this.solutionWithPerson = false;          // solution was computed based on mixture only
                results = dnaProcessor.process(fileUploader.getMixture(), new Person());                // get solution
            }
            else {
                this.solutionWithPerson = true;            // solution was computed with one profile
                results = dnaProcessor.process(fileUploader.getMixture(), fileUploader.getPerson());    // get solution
            }
        }catch (ErrorInInputDataException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Wrong semantics: "+e.getMessage() ));
            return null;
        }
        return "compute";
    }

    /** Invokes {@link DNAProcessor} in order to select all possible profiles from previously saved solution..
     * It is assumed that given profile is for sure in mixture. One person profile must be given.
     * If person profile file is correct then computes other profiles. Otherwise sets {@link FacesMessage}.
     */
    public void computePerson(){
        this.selectedMarker = null;                         // clears all selections
        this.selection = null;

        if (fileUploader.getPerson() == null){              // if person file is missing or cannot be parsed properly
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Wrong or missing person file."));
            return;
        }
        try {
            results = dnaProcessor.process(fileUploader.getPerson());       // select profiles from solution
        } catch (ErrorInInputDataException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Wrong semantics: "+e.getMessage() ));
            return;
        }
        fileUploader.setPerson(null);   // clean person in fileUploader to make possible to insert new Person
    }

    /**Listens for {@link AjaxBehaviorEvent} in order to set proper selected marker from {@link UIExtendedDataTable}
     * All combinations from selected marker will be visible in table.
     *
     * @param event       row selection event
     */
    public void selectionListener(AjaxBehaviorEvent event) {
        UIExtendedDataTable dataTable = (UIExtendedDataTable) event.getComponent();    // get events' parent component
        Object originalKey = dataTable.getRowKey();           // save selected row
        if (!selection.isEmpty()){
            dataTable.setRowKey(selection.iterator().next()); // only one selection is allowed, so first is the one
            if (dataTable.isRowAvailable()) {
                this.selectedMarker = (SolutionMarker) dataTable.getRowData();   // set selected marker
            }
        }

        dataTable.setRowKey(originalKey);                     // retrieve selected row
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