package org.DNA.mixtures.computing;

import org.DNA.mixtures.data.MixtureType;
import org.DNA.mixtures.data.PersonType;

import java.io.Serializable;
import java.util.List;

public class DNAProcessor implements Serializable{

    public DNAProcessor() {
        super();
    }

    public List<PersonType> process(MixtureType mixture, PersonType personType){
        // tutaj masz zawsze plik z mieszanina oraz z osobą
        // jezeli osoba nie zostala podana to personType jest pustym obiektem typu PersonType

        // generalnie sprawdzona juz jest poprawnosc każdego z plików niezależnie
        // z powrotem dostane pewnie liste PersonType
        // lub jakies błędy - tutaj do ustalenia
        return null;
    }

    public List<PersonType> process(PersonType personType){
        // ta metoda wolana gdy uzytkownik nie poda w pierwszym kroku profilu osoby
        return null;
    }
}
