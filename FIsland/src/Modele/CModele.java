package Modele;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import static Modele.WaterState.Submerged;

public class CModele extends Observable {

    // Attribut
    public static final int hauteur = 6;
    public static final int largeur = 6;
    private Case[][] island;
    //private ArrayList<Joueur> players;
    private Joueur player;

    private Color color;

    // Constructeur

    public CModele() {
        island = new Case[largeur][hauteur];
        for(int colonne = 0; colonne < largeur; colonne++){
            for(int ligne = 0; ligne < hauteur; ligne++) {
                island[colonne][ligne] = new Case(this, 60, 60);
            }
        }
        // TODO
        Random random = new Random();
        int randomX = random.nextInt(largeur);
        int randomY = random.nextInt(hauteur);
        Case aCase = island[randomX][randomY];
        this.player = new Joueur("BigBoss", 1, Color.getHSBColor(0, 0, 0), aCase);
    }

    // Getter & Setter
    public Case getCase(int x, int y) {
        return island[x][y];
    }

    public Case[][] getCase() {
        return island;
    }

    // Methode
    public void randomFlood(CModele modele) {
        Random random = new Random();
        int randomIndex_x = random.nextInt(modele.largeur);
        int randomIndex_y = random.nextInt(modele.hauteur);
        Case aCase = island[randomIndex_x][randomIndex_y];
        aCase.innonde();
    }

    // Is Player on the field
    /*public boolean isAlive(ArrayList<Joueur> j, Case cas) {
    }*/

/*protected int compteVoisines(int x, int y) {
        int res=0;
        for(int i=x-1; i<=x+1; i++) {
        for(int j=y-1; j<=y+1; j++) {
        if (cellules[i][j].etat) { res++; }
        }
        }
        return (res - ((cellules[x][y].etat)?1:0));*/

    /**
     * Renvoie une liste contenant les cases voisines disponibles pour un déplacement
     *
     * @param pos  La case dans laquelle se trouve le joueur actuellement
     *
     * @return Une ArrayList
     */
    public ArrayList<Case> getNeighbour(Case pos) {
        ArrayList<Case> res = new ArrayList<>();

        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                if (island[i][j] == pos) {
                    if (i+1 < island.length) {
                        res.add(island[i+1][j]);
                    }

                    if (i-1 >= 0) {
                        res.add(island[i-1][j]);
                    }

                    if (j+1 < island[i].length) {
                        res.add(island[i][j+1]);
                    }

                    if (j-1 >= 0) {
                        res.add(island[i][j-1]);
                    }
                }
            }
        }

        return res;
    }

    /// # On récupère les cases autour de notre joueur
    /// listeCase = model.getNeighbour(joueur.getPosition);
    /// # user choisis une case dans listeCase
    ///
    /// # Enlever le joueur de sa précédente position
    /// joueur.getPosition().removeJoueur(joueur);
    /// # On met a jour la position du joueur
    /// joueur.setPosition(listeCase[choixUser]);
    /// # On ajoute le joueur dans la nouvelle case
    /// listeCase[choixUser].addJoueur(joueur);
}