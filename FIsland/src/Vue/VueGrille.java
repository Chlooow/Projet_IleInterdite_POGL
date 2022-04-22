package Vue;

import Modele.CModele;
import Modele.Case;
import Modele.WaterState;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;


class VueGrille extends JPanel implements Observer {

    // Attribut
    private CModele modele;
    private final static int taille = 12;

    // Constructeur

    // TODO
    public VueGrille(CModele modele) {
        super(new GridLayout(6, 6));
        this.modele = modele;
        modele.addObserver(this);
        Dimension dim = new Dimension(taille * CModele.largeur,
                taille * CModele.hauteur);
        this.setPreferredSize(dim);

        // Création des cases
        // ajouteElement(cases)

        Case[][] cases = modele.getCase();

        for (Case[] c : cases) {
            for (Case cc : c) {
                this.add(cc);
            }
        }
    }

    //public void update() { repaint();}

    // Getters & Setter


    public static int getTaille() {
        return taille;
    }

    /*
    public void paintComponent(Graphics g) {
        super.repaint();
        for (int i = 1; i <= CModele.largeur; i++) {
            for (int j = 1; j <= CModele.hauteur; j++) {
                paint(g, modele.getCase(i, j), (i - 1) * taille, (j - 1) * taille);
            }
        }
    } */

    /*
    private void paint(Graphics g, Case c, int x, int y) {
        g.setColor(new Color(255, 255, 255));
        g.fillRect(x,y,taille,taille);
        switch (c.getEtat()) {
            case Normal -> g.setColor(Color.white);
            case Flooded -> g.setColor(Color.cyan);
            case Submerged -> g.setColor(Color.blue);
        } */
        /* // tu colories en fonction du niveau d'eau et tu vérifies la pos du joueur dans le Cmodele,
		// et si elle est égale à celle de la case, tu colories la case differemment
	if (c.isAlive()) {
	    g.setColor(Color.BLACK);
	} else {
            g.setColor(Color.WHITE);
        }*/
   // }

    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }
}