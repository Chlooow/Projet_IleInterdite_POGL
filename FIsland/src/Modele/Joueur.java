package Modele;

import java.awt.*;
import java.util.ArrayList;

public class Joueur {

    // Attribut
    private String nomJoueur;
    private CModele modele;
    private ArrayList<Cles> invKeyJoueur;
    // il manquait l'inventaire d'artefact
    // faire une hashmap c'est se compliquer la vie et on ne peu faire de double tableau du coup
    // pour prendre un art, il faudra faire la methode "roumain" comme dit Amine
    /* TODO : tu récupe la clé dans l'inventaire de cle du joueur, puis tu le compare si il ont le même elem
     alors, addArt to the Inventaire de Artefacts*/
    private ArrayList<ElementArtefact> invArtJoueur;
    private int idJoueur;
    private static int id = 0;
    private Color couleur;
    private Case position;
    private int actions;

    // Constructeur
    public Joueur(String nom, Color c, Case cas) {
        this.couleur = c;
        this.idJoueur = ++id;
        this.nomJoueur = nom;
        this.position = cas; // il faut l'initialiser au même stade de que l'heliport
        this.invKeyJoueur = new ArrayList<Cles>();
        this.invArtJoueur = new ArrayList<ElementArtefact>();
        this.actions = 0;
    }

    // Getter & Setter

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public CModele getModele() {
        return modele;
    }

    public void setModele(CModele modele) {
        this.modele = modele;
    }

    public ArrayList<Cles> getInvKeyJoueur() {
        return invKeyJoueur;
    }

    /*public void setInvJoueur(ArrayList<Cles> invJoueur) {
        this.invJoueur = invJoueur;
    }*/

    public int getIdJoueur() {
        return idJoueur;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public int getPositionX() {
        return this.position.getX();
    }

    public int getPositionY() {
        return this.position.getY();
    }

    public Case getPosition() {
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }

    public int getActions() {
        return actions;
    }

    public void setActions(int actions) {
        this.actions = actions;
    }

    // Methodes

    // add cle

    // add artefact

    // isDrowned
    // verifier si un joueur se noie
    /*public boolean isDrowned(Joueur j, Case cas) {
        if(j.getPositionY().equals(cas.getY()) && j.getPositionX().equals(cas.getX())){
            return true;
        } else {
            return false;
        }
    }*/

    // Actions à effectuer
    public void actionsJoueur() {
        this.actions = this.actions + 1;
    }

    // Assecher une case

}
