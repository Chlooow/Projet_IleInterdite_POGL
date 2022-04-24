package Vue;

import Modele.CModele;
import Modele.Case;
import Modele.Cles;
import Modele.WaterState;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;


class VueGrille extends JPanel implements Observer {

    //private final Cles cles;
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

        Case[][] cases = modele.getCase();

        for (Case[] c : cases) {
            for (Case cc : c) {
                this.add(cc);
            }
        }
    }

    public static int getTaille() {
        return taille;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }
}