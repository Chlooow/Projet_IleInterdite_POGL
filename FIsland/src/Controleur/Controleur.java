package Controleur;

import Modele.CModele;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur implements ActionListener {
    CModele modele;
    public Controleur(CModele modele) { this.modele = modele; }
    /**
     * Action effectuée à réception d'un événement : appeler la
     * méthode [avance] du modèle.
     */
    public void actionPerformed(ActionEvent e) {
        // Inonder une case au hasard
       modele.randomFlood(modele);
       modele.randomFlood(modele);
       modele.randomFlood(modele);
    }
}

/** Fin du contrôleur. */

