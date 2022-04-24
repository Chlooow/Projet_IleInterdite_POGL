package Modele;

import java.awt.*;
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
    private ArrayList<Joueur> players = new ArrayList<>();
    private Joueur player;
    private Color color;
    private Inventaire keys;
    //private Cles key;
    private boolean helicopter;

    private int currentJoueur = 0;
    private int nbAction = 0;
    Case spawn;

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
        island[2][2].draw(Couleurs.COLOR_Heli);

        // Artefact
        this.setArtefact();

        // Case de depart
        spawn = island[2][2];
    }

    // Getter & Setter
    public Case getCase(int x, int y) {
        return island[x][y];
    }
    public Case getSpawn() {
        return spawn;
    }
    public Case[][] getCase() {
        return island;
    }
    public Joueur getJoueur() { return players.get(this.currentJoueur); }

    /** mettre les artefacts */
    public void setArtefact(){
        this.randomCase().draw(Couleurs.COLOR_TERRE);
        this.randomCase().draw(Couleurs.COLOR_AIR);
        this.randomCase().draw(Couleurs.COLOR_FEU);
        this.randomCase().draw(Couleurs.COLOR_EAU);
    }

    // Methode
    public void ajouteJoueur(Joueur j) {
        players.add(j);
        spawn.ajouteJoueur(j);
    }

    /** assecher une case voulu */
    public void sacDeSable(Case c){
        if (c.getEtat() != WaterState.Submerged) {
            getCase(c.getX(), c.getY());
            c.asseche();
            System.out.print(" Assechement avec succes");
        } else {
            System.out.print(" Pas possible d'assecher cette case, réessayez");
        }
    }

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
        Cles cle = null;
        int rand = genererInt(0, 3);
        switch (rand) {
            case 0 : cle = CLEAIR;
            break;
            case 1 : cle = CLETERRE;
            break;
            case 2 : cle = CLEEAU;
            break;
            case 3 : cle = CLEFEU;
            break;
        }
        return cle;
    }

    /** ajouter une cle à l'inventaire du joueur*/

    public void ajouterCle(Joueur i){
        if (randomKey() == CLEAIR) {
            i.getInvKeyJoueur().add(randomKey());
            System.out.print(" Ajout de Cle air à l'inventaire\n ");
        } else if (randomKey() == CLEFEU) {
            i.getInvKeyJoueur().add(randomKey());
            System.out.print(" Ajout de Cle feu à l'inventaire\n ");
        } else if (randomKey() == CLEEAU) {
            i.getInvKeyJoueur().add(randomKey());
            System.out.print(" Ajout de Cle eau à l'inventaire\n ");
        } else if (randomKey() == CLETERRE) {
            i.getInvKeyJoueur().add(randomKey());
            System.out.print(" Ajout de Cle terre à l'inventaire\n ");
        } else if (randomKey() == null) {
            System.out.print(" Rien désolé...\n ");
        }
    }

    /** Assecher une case sur lequel le personnage est ou adjacant */


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
    // on garde on sait jamais
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

    public void update() {
        for (Case[] c : island) {
            for (Case cc : c) {
                cc.draw();
            }
        }
    }


    /** droit de faire 3 actions */
    public boolean nextAction() {
        nbAction++;

        if (nbAction >= 3) {
            nbAction = 0;
            currentJoueur++;

            randomFlood(this);
            randomFlood(this);
            randomFlood(this);

            if (currentJoueur >= players.size()) {
                currentJoueur = 0;
            }
            return true;
        }
        return false;
    }

    /**
     * Deplacement des pers
     * @param dir
     */

    public void move(Direction dir) {
        //System.out.println("move called");
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                if (island[i][j] == players.get(currentJoueur).getPosition()) {
                    int offi = 0, offj = 0;

                    switch (dir) {
                        case UP -> offi = -1;
                        case DOWN -> offi = 1;
                        case LEFT -> offj = -1;
                        case RIGHT -> offj = 1;
                    }

                    if (i + offi < island.length && i + offi >= 0 && j + offj < island[i].length && j + offj >= 0) {
                        Case next = island[i+offi][j+offj];
                        Joueur joueur = players.get(currentJoueur);

                        joueur.getPosition().removeJoueur(joueur);
                        joueur.getPosition().draw();
                        joueur.setPosition(next);
                        next.ajouteJoueur(joueur);
                        next.draw();
                    } else {
                        System.err.println("Erreur: déplacement impossible");
                        return;
                    }

                    nextAction();
                    return;
                }
            }
        }
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

/*au moment de creer les artefacts
* recup une case au hasard et donner un artefact au hasard
* 
*
* */