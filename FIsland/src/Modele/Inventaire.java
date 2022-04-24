package Modele;

import java.util.ArrayList;
import java.util.Random;

import static Modele.Cles.*;

public class Inventaire {

    // Attribut
    private ArrayList<ElementArtefact> artefacts;
    private ArrayList<Cles> cles;
    private CModele modele;

    // Constructeur
    public Inventaire(){
        this.artefacts = new ArrayList<ElementArtefact>();
        this.cles = new ArrayList<Cles>();
    }

    // Getter & Setter
    public ArrayList<Cles> getCles() {
        return cles;
    }
    public ArrayList<ElementArtefact> getArtefacts() {
        return artefacts;
    }


    // Methodes

    public void ajouterArtefact(ElementArtefact arte) {
        this.artefacts.add(arte);
    }

    // Reset l'inventaire vide
    public void delete(ElementArtefact element) {
        this.getCles().removeIf(cle -> {
            return cle.getElementOfKey().equals(element);
        });
    }

    public void retirerCle(ElementArtefact elementArtefact){
        cles.removeIf(cle -> {
            return cle.getElementOfKey().equals(elementArtefact);
        });
    }



}
