package Vue;

import Controleur.Controleur;
import Modele.CModele;
import Modele.Case;
import Modele.Direction;

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

        // Boutons d'assèchement
        JButton dryRight = new JButton(" dry right ");
        JButton dryLeft = new JButton(" dry left ");
        JButton dryUp = new JButton(" dry up ");
        JButton dryDown = new JButton(" dry down ");

        dryRight.addActionListener((ActionEvent e) -> {
            // Action quand le bouton dry up est cliqué
            modele.assechement(Direction.RIGHT);
        });
        dryLeft.addActionListener((ActionEvent e) -> {
            // Action quand le bouton dry up est cliqué
            modele.assechement(Direction.LEFT);
        });
        dryUp.addActionListener((ActionEvent e) -> {
            // Action quand le bouton dry up est cliqué
            modele.assechement(Direction.UP);
        });
        dryDown.addActionListener((ActionEvent e) -> {
            // Action quand le bouton dry up est cliqué
            modele.assechement(Direction.DOWN);
        });

        this.add(dryRight);
        this.add(dryLeft);
        this.add(dryUp);
        this.add(dryDown);







        // Bouton recuperation d'artefact
        JButton recup = new JButton(" Recuperer Artefact ");

        recup.addActionListener((ActionEvent e) -> {
            // Action quand le bouton recuperer est cliqué
            // TODO
            modele.recupArtefact();
        });
        this.add(recup);

        // Bouton de Sac de sable
        JButton sacDeSable = new JButton("Sac de Sable");
        sacDeSable.addActionListener((ActionEvent e) -> {
            // Action quand le bouton asseche une zone voulu est cliqué
            // TODO
            System.out.print(" Choisissez une case que vous voulez assecher\n");
            Scanner input = new Scanner(System.in);
            System.out.print("Choisissez un x : ");
            int casX = input.nextInt();
            System.out.print("Choisissez un y : ");
            int casY = input.nextInt();
            Case cas1 = modele.getCase(casX, casY);
            cas1.asseche();
        });
        this.add(sacDeSable);
        // Bouton de Heliport
        JButton transport = new JButton("utiliser l'helicoptère");
        transport.addActionListener((ActionEvent e) -> {
            // Action quand le bouton helicoptere est clique
            // TODO
            Scanner input = new Scanner(System.in);
            System.out.print(" Choisissez une case ou vous voulez aller \n");
            System.out.print("Choisissez un x : \n");
            int casX = input.nextInt();
            System.out.print("Choisissez un y : \n");
            int casY = input.nextInt();
            Case cas1 = modele.getCase(casX, casY);
            // fonction qui enleve l'héliport de la case et la met sur une nouvelle choisis
        });
        this.add(transport);
        // Bouton de deplacements
        JButton right = new JButton("right");
        JButton left = new JButton("left");
        JButton up = new JButton("up");
        JButton down = new JButton("down");

        right.addActionListener((ActionEvent e) -> {
            // TODO
            // Action quand le bouton right est cliqué
            modele.move(Direction.RIGHT);
        });

        left.addActionListener((ActionEvent e) -> {
            // TODO
            // Action quand le bouton left est cliqué
            modele.move(Direction.LEFT);
        });

        up.addActionListener((ActionEvent e) -> {
            // TODO
            // Action quand le bouton up est cliqué
            modele.move(Direction.UP);
        });

        down.addActionListener((ActionEvent e) -> {
            // TODO
            // Action quand le bouton down est cliqué
            modele.move(Direction.DOWN);
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
