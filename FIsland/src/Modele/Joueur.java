package Modele;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Joueur {

    // Attribut
    private String nomJoueur;
    private CModele modele;
    private ArrayList<Inventaire> invJoueur;
    private int idJoueur;
    private int id;
    private Color couleur;
    private Case position;
    private int actions;

    // Constructeur
    public Joueur(String nom, Color c, Case cas) {
        this.couleur = c;
        this.id = idJoueur++;
        this.nomJoueur = nom;
        this.position = cas; // il faut l'initialiser au même stade de que l'heliport
        this.invJoueur = new ArrayList<Inventaire>();
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

    public ArrayList<Inventaire> getInvJoueur() {
        return invJoueur;
    }

    public void setInvJoueur(ArrayList<Inventaire> invJoueur) {
        this.invJoueur = invJoueur;
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
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
    /*public ArrayList<Inventaire> addKeyInInv(Cle keys) {

    }*/
    // add artefact
    // remove artefact
    // remove Cle

    // isDrowned
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
