package Vue;

import Controleur.Controleur;
import Modele.CModele;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;

public class VueCommandes extends JPanel {

    // Attributs
    private CModele modele;
    private int height = 20;
    private int width = 100;


    // Constructeur
    public VueCommandes(CModele modele) {
        this.modele = modele;
        // Bouton fin de tour
        JButton finDeTour = new JButton("Fin de Tour");
        this.add(finDeTour);

        // Bouton de deplacements
        JButton right = new JButton("right");
        JButton left = new JButton("left");
        JButton up = new JButton("up");
        JButton down = new JButton("down");

        right.addActionListener((ActionEvent e) -> {
            // TODO
            // Action quand le bouton right est cliqué
        });

        left.addActionListener((ActionEvent e) -> {
            // TODO
            // Action quand le bouton left est cliqué
        });

        up.addActionListener((ActionEvent e) -> {
            // TODO
            // Action quand le bouton up est cliqué
        });

        down.addActionListener((ActionEvent e) -> {
            // TODO
            // Action quand le bouton down est cliqué
        });

        this.add(right);
        this.add(left);
        this.add(up);
        this.add(down);

        // Ajouter un actionListener aux bouton
        Controleur ctrl = new Controleur(modele);
        finDeTour.addActionListener(ctrl);
    }

}
