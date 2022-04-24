package Modele;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;

import static Modele.Couleurs.*;

public class Case extends JLabel {

    private WaterState etat;
    private WaterState nextState;
    protected ElementArtefact artefact;
    protected int ligne, colonne;
    private ArrayList<Joueur> joueurs = new ArrayList<>();
    private CModele modele;
    protected final int width, height;

    private Color color = Couleurs.COLOR_NORMAL;

    // Constructeur
    public Case(CModele modele, int width, int height, int ligne , int colonne) {
        this.modele = modele;
        this.etat = WaterState.Normal;
        this.width = width;
        this.height = height;
        this.ligne = ligne;
        this.colonne = colonne;

        setPreferredSize(new Dimension(width, height));
        draw();
    }
    public WaterState getEtat() { return etat; }

    public void setEtat(WaterState state){ this.etat = state; }
    @Override

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void etatSuivant(WaterState etat){
        switch (etat) {
            case Normal -> nextState = WaterState.Flooded;
            case Flooded, Submerged -> nextState = WaterState.Submerged;
        }
    }

    /**HasArtefact*/
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
        if(artefact != null){
            switch (artefact){
                case EAU -> graphics.setColor(COLOR_EAU);
                case AIR -> graphics.setColor(COLOR_AIR);
                case FEU -> graphics.setColor(COLOR_FEU);
                case TERRE -> graphics.setColor(COLOR_TERRE);
            }

            graphics.fillRect( 1 + 14, 1, 14, 14);
        }

        this.setIcon(new ImageIcon(img));
    }

    public void draw(Color newColor) {
        this.color = newColor;
        draw();
    }
}