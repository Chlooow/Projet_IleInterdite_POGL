package Modele;

import java.awt.*;
import java.util.ArrayList;

public class Joueur {

    // Attribut
    private String nomJoueur;
    private CModele modele;
    protected Inventaire invJoueur;
    private int idJoueur;
    private static int id = 0;
    private Color couleur;
    protected Case position;
    private int actions;


    // Constructeur
    public Joueur(String nom, Color c, Case cas) {
        this.couleur = c;
        this.idJoueur = ++id;
        this.nomJoueur = nom;
        this.position = cas; // il faut l'initialiser au même stade de que l'heliport
        this.invJoueur = new Inventaire();
        this.actions = 0;
    }

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
        return invJoueur.invKeyJoueur;
    }

    public void setInvJoueur(Inventaire invJoueur) {
        this.invJoueur = invJoueur;
    }

    public int getIdJoueur() {
        return idJoueur;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public Case getPosition() {
        return position;
    }

    public void setPosition(Case position) {
        this.position = position;
    }
    public int getActions(){
        return actions;
    }
}
