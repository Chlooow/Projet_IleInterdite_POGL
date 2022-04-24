import Modele.CModele;
import Modele.Couleurs;
import Vue.CVue;

import java.awt.*;

import Modele.Joueur;
import java.util.ArrayList;

/* Classe Principale*/

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            CModele modele = new CModele();
            ArrayList<Joueur> joueurs = new ArrayList<Joueur>();

            for (int i = 0; i < 4; i++) {
                Joueur next = new Joueur("Test", Couleurs.getPlayerColor(i), modele.getSpawn());
                joueurs.add(next);
                modele.ajouteJoueur(next);
            }


            CVue vue = new CVue(modele);
            modele.update();
            Music mus = new Music();
            mus.jouerEnBoucle();
        });
    }

}
