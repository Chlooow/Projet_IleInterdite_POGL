package Vue;

import Controleur.Controleur;
import Modele.CModele;
import Modele.Case;

import java.awt.event.*;
import java.util.Scanner;

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

        // Bouton d'assèchement
        JButton dry = new JButton(" dry case ");
        /*dry.addActionListener((ActionEvent e) -> {
            // Action quand le bouton assecher est cliqué
            // TODO
            //asseche();
        };*/
        this.add(dry);

        // Bouton recuperation d'artefact
        JButton recup = new JButton(" Recuperer Artefact ");

        /*recup.addActionListener((ActionEvent e) -> {
            // Action quand le bouton recuperer est cliqué
            // TODO
            //recuperer();
        };*/
        this.add(recup);

        // Bouton de Sac de sable
        JButton sacDeSable = new JButton("Sac de Sable");
        sacDeSable.addActionListener((ActionEvent e) -> {
            // Action quand le bouton asseche une zone voulu est cliqué
            // TODO
            Scanner input = new Scanner(System.in);
            System.out.print("Choisissez un x : ");
            int casX = input.nextInt();
            System.out.print("Choisissez un y : ");
            int casY = input.nextInt();
            Case cas1 = modele.getCase(casX, casY);
            modele.sacDeSable(cas1);
        });
        this.add(sacDeSable);

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

        // Ajouter un actionListener aux boutons
        Controleur ctrl = new Controleur(modele);
        finDeTour.addActionListener(ctrl);
    }

}
