package Modele;

import Modele.CModele;
import Modele.ElementArtefact;
import Modele.WaterState;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import java.awt.*;
import java.util.Observable;
import javax.swing.*;

public class Case extends JLabel {
    // Attributs
    // Enum
    private WaterState etat;
    private WaterState nextState;
    private ElementArtefact artefact;

    private ArrayList<Joueur> joueurs = new ArrayList<>();

    private CModele modele;
    private final int width, height;

    protected ElementArtefact element;

    private Color color = Couleurs.COLOR_NORMAL;

    // Constructeurs
    public Case(CModele modele, int width, int height) {
        this.modele = modele;
        this.etat = WaterState.Normal;
        this.width = width;
        this.height = height;

        setPreferredSize(new Dimension(width, height));
        draw();
    }
    // Getter & Setter
    public WaterState getEtat() { return etat; }
    public void setEtat(WaterState state){ this.etat = state; }

    @Override
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // Methodes

    public void etatSuivant(WaterState etat){
        switch (etat) {
            case Normal -> nextState = WaterState.Flooded;
            case Flooded, Submerged -> nextState = WaterState.Submerged;
        }
    }

    /** HasArtefact */
    public boolean hasArtefact(){ return artefact !=null; }

    public void addArtefact(ElementArtefact element){
        artefact = element;
    }

    public void removeArtefact(){
        artefact = null;
    }

    /** verifie si l'heliport est submergé */
    // une des conditions pour perdre
    public boolean subHeliport(){
        if(this.modele.spawn.equals(WaterState.Submerged)){
            return true;
        } else {
            return false;
        }
    }

    public boolean playerDrowned(Joueur j) {
        if (j.getPosition().getEtat().equals(WaterState.Submerged)) {
            return true;
        } else {
            return false;
        }
    }

    /** methode qui innonde */
    public void innonde() {
        if (etat == WaterState.Normal) {
            etat = WaterState.Flooded;
        } else if (etat == WaterState.Flooded) {
            etat = WaterState.Submerged;
        }

        this.draw(Couleurs.fromState(etat));
        //Observable.notifyObservers();
    }

    /** methode qui asseche */
    public void asseche() {
        if (etat != WaterState.Submerged) {
            etat = WaterState.Normal;
            this.draw(Couleurs.fromState(etat));
        } else if(etat == WaterState.Submerged) {
            System.out.print(" Vous ne pouvez pas assecher cette Case ");
        } else if (etat == WaterState.Normal) {
            System.out.print("Case déjà sec ");
        }
    }

    /** ajouter un joueur */
    public void ajouteJoueur(Joueur j) {
        if (!joueurs.contains(j)) {
            joueurs.add(j);
        }
    }

    /** enlever un joueur */
    public void removeJoueur(Joueur j) {
        joueurs.remove(j);
    }


    /** remove un artefact de la case */
    //public void


    /** draw*/
    public void draw() {
        BufferedImage img = new BufferedImage(width, height, Image.SCALE_DEFAULT);
        Graphics2D graphics = img.createGraphics();

        graphics.setColor(color);
        graphics.fillRect(0, 0, width, height);

        graphics.setColor(Color.BLACK);
        graphics.setStroke(new BasicStroke(2.0f));
        graphics.drawRect(1, 1, width-3, height-2);

        if (!joueurs.isEmpty()) {
            for (int i = 0; i != joueurs.size(); i++) {
                graphics.setColor(Couleurs.getPlayerColor(joueurs.get(i).getIdJoueur()));
                int offset = joueurs.get(i).getIdJoueur()-1;
                graphics.fillRect( 1 + (offset * 14), 1, 14, 14);

            }
        }

        this.setIcon(new ImageIcon(img));
    }

    public void draw(Color newColor) {
        this.color = newColor;
        draw();
    }
}