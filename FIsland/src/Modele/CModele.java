package Modele;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

import static Modele.Cles.*;
import static Modele.Cles.CLETERRE;

//import static Modele.Cles.CLEAIR;

public class CModele extends Observable {

    // Attribut
    public static final int hauteur = 6;
    public static final int largeur = 6;
    private Case[][] island;
    //private ArrayList<Joueur> players;
    private Joueur player;
    private Color color;
    private Inventaire keys;
    //private Cles key;
    private boolean helicopter;

    // Constructeur

    public CModele() {
        island = new Case[largeur][hauteur];
        for(int colonne = 0; colonne < largeur; colonne++){
            for(int ligne = 0; ligne < hauteur; ligne++) {
                island[colonne][ligne] = new Case(this, 60, 60);
            }
        }
        
        // TODO : je pense qu'il faut faire un input pour laisser le
        // le joueur choisir son pseudo?

        /* Scanner input = new Scanner(System.in);
         System.out.print("Choisissez des pseudos pour les personnages : ");
         String pseudo = scanner.nextLine();
         */

        // joueur
        // Attention ici, je crois que j'ai fais une erreur quand tu vas ajouter les personnage, car il faut que
        // le joueur choisisse son propre nom et il faut que l'id change en fonction du joueur et sa place
        // dans le tableau de jouer
        //this.player = new Joueur("BigBoss", Color.getHSBColor(0, 0, 0), aCase);

        // Heliport
        this.helicopter = true;
        this.randomCase().draw(Couleurs.COLOR_Heli);

        // Artefact
        this.setArtefact();

        // Cles
        //this.setKey();
        // Ici je me suis trompé, les clés ne sont pas sur le plateau de jeu c'est quand on clique
        this.keys = new Inventaire();

    }

    // Getter & Setter
    public Case getCase(int x, int y) {
        return island[x][y];
    }

    public Case[][] getCase() {
        return island;
    }

    /*public Cles getKey() {
        return key;
    }*/

    /** mettre les artefacts */
    public void setArtefact(){
        this.randomCase().draw(Couleurs.COLOR_TERRE);
        this.randomCase().draw(Couleurs.COLOR_AIR);
        this.randomCase().draw(Couleurs.COLOR_FEU);
        this.randomCase().draw(Couleurs.COLOR_EAU);
    }
    /** mettre les cles */
    /*public void setKey() {
        this.randomCase().draw(Couleurs.COLOR_TERRE_KEY);
        this.randomCase().draw(Couleurs.COLOR_AIR_KEY);
        this.randomCase().draw(Couleurs.COLOR_FEU_KEY);
        this.randomCase().draw(Couleurs.COLOR_EAU_KEY);
    }*/

    // Methode
    /** Innonder une case aleatoirement */
    public void randomFlood(CModele modele) {
        Random random = new Random();
        int randomIndex_x = random.nextInt(modele.largeur);
        int randomIndex_y = random.nextInt(modele.hauteur);
        Case aCase = island[randomIndex_x][randomIndex_y];
        aCase.innonde();
        notifyObservers();
    }

    /** choisis une case au hasard*/
    public Case randomCase() {
        Random random = new Random();
        int randomIndex_x = random.nextInt(this.largeur);
        int randomIndex_y = random.nextInt(this.hauteur);
        return island[randomIndex_x][randomIndex_y];
    }

    /** genere un nombre au hasard entre deux bornes
     *
     * @param borneInf
     * @param borneSup
     * @return
     */
    int genererInt(int borneInf, int borneSup){
        Random random = new Random();
        int nb;
        nb = borneInf+random.nextInt(borneSup-borneInf);
        return nb;
    }

    /** random key generator*/
    public Cles randomKey() {
        Cles cle = CLEAIR;
        if (genererInt(1, 5) == 1) {
            cle = CLEAIR;
        } else if (genererInt(1, 5) == 2) {
            cle = CLEEAU;
        } else if (genererInt(1, 5) == 3) {
            cle = CLEFEU;
        } else if (genererInt(1, 5) == 4) {
            cle = CLETERRE;
        } else if (genererInt(1, 5) == 5){
            cle = null;
        }
        return cle;
    }

    public void ajouterCle(){
        if (randomKey() == CLEAIR) {
            this.keys.addKey(randomKey());
            System.out.print(" Ajout de Cle air à l'inventaire\n ");
        } else if (randomKey() == CLEFEU) {
            this.keys.addKey(randomKey());
            System.out.print(" Ajout de Cle feu à l'inventaire\n ");
        } else if (randomKey() == CLEEAU) {
            this.keys.addKey(randomKey());
            System.out.print(" Ajout de Cle eau à l'inventaire\n ");
        } else if (randomKey() == CLETERRE) {
            this.keys.addKey(randomKey());
            System.out.print(" Ajout de Cle terre à l'inventaire\n ");
        } else if (randomKey() == null) {
            System.out.print(" Rien désolé...\n ");
        }
    }

    /** Assecher une case sur lequel le personnage est ou adjacant */


    // Is Player on the field
    /*public boolean isAlive(ArrayList<Joueur> j, Case cas) {
    }*/

    /* protected int compteVoisines(int x, int y) {
        int res=0;
        for(int i=x-1; i<=x+1; i++) {
        for(int j=y-1; j<=y+1; j++) {
        if (island[i][j].etat) { res++; }
        }
        }
        return (res - ((island[x][y].etat)?1:0)); */

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