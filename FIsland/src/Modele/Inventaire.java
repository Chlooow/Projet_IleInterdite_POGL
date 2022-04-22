package Modele;

import java.util.ArrayList;

public class Inventaire {

    // Attribut
    private ArrayList<ElementArtefact> artefacts;
    private ArrayList<Cles> cles;

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

    public void ajouterCle(Cles key){
        this.cles.add(key);
    }

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
