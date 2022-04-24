package Modele;

import java.util.ArrayList;

public class Inventaire {

    // Attribut
    protected ArrayList<ElementArtefact> invArtJoueur;
    protected ArrayList<Cles> invKeyJoueur;
    private CModele modele;

    // Constructeur
    public Inventaire(){
        this.invArtJoueur = new ArrayList<ElementArtefact>();
        this.invKeyJoueur = new ArrayList<Cles>();
    }

    // Getter & Setter
    public ArrayList<Cles> getCles() {
        return invKeyJoueur;
    }
    public ArrayList<ElementArtefact> getArtefacts() {
        return invArtJoueur;
    }

    // Methodes
    public void ajouterArtefact(ElementArtefact arte) {
        this.invArtJoueur.add(arte);
    }

    // Reset l'inventaire vide
    public void delete(ElementArtefact element) {
        this.getCles().removeIf(cle -> {
            return cle.getElementOfKey().equals(element);
        });
    }

    public void retirerCle(ElementArtefact elementArtefact){
        invKeyJoueur.removeIf(cle -> {
            return cle.getElementOfKey().equals(elementArtefact);
        });
    }

    public ArrayList<Cles> addKey(Cles k) {
        this.invKeyJoueur.add(k);
        return invKeyJoueur;
    }
}
