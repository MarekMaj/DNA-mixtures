package org.DNA.mixtures.computing;

import org.DNA.mixtures.data.MixtureType;
import org.DNA.mixtures.data.PersonType;

import java.io.Serializable;

public class DNAProcessor implements Serializable{

    public DNAProcessor() {
        super();
    }

    public Object process(MixtureType mixture, PersonType personType){
        // tutaj masz zawsze obiekt z mieszanina oraz z osobą
        // jezeli osoba nie zostala podana to personType jest pustym obiektem typu PersonType

        // generalnie sprawdzona juz jest poprawnosc (struktury a nie treści) każdego z plików niezależnie
        // z powrotem dostane jakas strukture ?? - do ustalenia
        // lub jakies błędy - tutaj do ustalenia
        // TODO uzgodnic czy dla jednej osoby piszemy raz czy dwa razy ten sam allel w przypadku homozygoty
        // i ewewntualnie poprawic XML Schema
        // TODO czy określamy nazwy markerów, czy przyjmujemy ze kolejnność w pliku identyfikuje marker
        return null;
    }

    public Object process(PersonType personType){
        // ta metoda wolana gdy uzytkownik nie poda w pierwszym kroku profilu osoby
        return null;
    }
}
