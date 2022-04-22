package Modele;

import Modele.CModele;
import Modele.ElementArtefact;
import Modele.WaterState;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import java.awt.*;
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


    // Methode
    public void etatSuivant(WaterState etat){
        switch (etat) {
            case Normal -> nextState = WaterState.Flooded;
            case Flooded -> nextState = WaterState.Submerged;
            case Submerged -> nextState = WaterState.Submerged;
        }
    }

    public void innonde() {
        if (etat == WaterState.Normal) {
            etat = WaterState.Flooded;
        } else if (etat == WaterState.Flooded) {
            etat = WaterState.Submerged;
        }

        this.draw(Couleurs.fromState(etat));
    }

    public void asseche() {
        if (etat != WaterState.Submerged) {
            etat = WaterState.Normal;
        }

        this.draw(Couleurs.fromState(etat));
    }


    public void ajouteJoueur(Joueur j) {
        if (!joueurs.contains(j)) {
            joueurs.add(j);
        }
    }

    public void removeJoueur(Joueur j) {
        joueurs.remove(j);
    }


    public void draw() {
        BufferedImage img = new BufferedImage(width, height, Image.SCALE_DEFAULT);
        Graphics2D graphics = img.createGraphics();

        graphics.setColor(color);
        graphics.fillRect(0, 0, width, height);

        graphics.setColor(Color.BLACK);
        graphics.setStroke(new BasicStroke(2.0f));
        graphics.drawRect(1, 1, width-3, height-2);

        this.setIcon(new ImageIcon(img));
    }


    public void draw(Color newColor) {
        this.color = newColor;
        draw();
    }


    //protected void Random

}