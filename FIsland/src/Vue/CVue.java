package Vue;

import Modele.CModele;

import javax.swing.*;
import java.awt.*;

public class CVue {
    // Attribut
    private JFrame frame;
    private VueGrille grille;
    private VueCommandes commandes;

    /* Construction d'une vue attachée à un modèle. */

    public CVue(CModele modele) {
        /** Définition de la fenêtre principale. */
        frame = new JFrame();
        frame.setTitle("l'Ile Interdite");

        frame.setLayout(new GridLayout(1, 2));

        /** Définition des deux vues et ajout à la fenêtre. */
        grille = new VueGrille(modele);
        frame.add(grille);
        commandes = new VueCommandes(modele);
        frame.add(commandes);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(900, 450);
        frame.setLocation((screenSize.width/2) - (frame.getWidth()/2), (screenSize.height/2) - (frame.getHeight()/2));
        //frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
