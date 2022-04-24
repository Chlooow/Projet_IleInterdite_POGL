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
        for (int colonne = 0; colonne < largeur; colonne++) {
            for (int ligne = 0; ligne < hauteur; ligne++) {
                island[colonne][ligne] = new Case(this, 60, 60, ligne, colonne);
            }
        }
       // island[0][0].artefact = ElementArtefact.FEU;

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
    public Case getSpawn() {
        return spawn;
    }
    public Case getCase(int x, int y) {
        return island[x][y];
    }
    public Case[][] getCase() {
        return island;
    }
    public Joueur getJoueur() { return players.get(this.currentJoueur); }

    /**
     * mettre les artefacts
     */
    public void setArtefact() {
        Case t = this.randomCase();
        t.draw(Couleurs.COLOR_TERRE);
        t.artefact = ElementArtefact.TERRE;
        Case a = this.randomCase();
        a.draw(Couleurs.COLOR_AIR);
        a.artefact = ElementArtefact.AIR;
        Case f = this.randomCase();
        f.draw(Couleurs.COLOR_FEU);
        f.artefact = ElementArtefact.FEU;
        Case e = this.randomCase();
        e.draw(Couleurs.COLOR_EAU);
        e.artefact =ElementArtefact.EAU;
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

    /**
     * Innonder une case aleatoirement
     */
    public void randomFlood(CModele modele) {
        Random random = new Random();
        int randomIndex_x = random.nextInt(modele.largeur);
        int randomIndex_y = random.nextInt(modele.hauteur);
        Case aCase = island[randomIndex_x][randomIndex_y];
        aCase.innonde();
        notifyObservers();
    }

    /**
     * choisis une case au hasard
     */
    public Case randomCase() {
        Random random = new Random();
        int randomIndex_x = random.nextInt(this.largeur);
        int randomIndex_y = random.nextInt(this.hauteur);
        return island[randomIndex_x][randomIndex_y];
    }

    /**
     * genere un nombre au hasard entre deux bornes
     *
     * @param borneInf
     * @param borneSup
     * @return
     */
    int genererInt(int borneInf, int borneSup) {
        Random random = new Random();
        int nb;
        nb = borneInf + random.nextInt(borneSup - borneInf);
        return nb;
    }

    /**
     * random key generator
     */
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
        } else if (genererInt(1, 5) == 5) {
            cle = null;
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


    /**
     * Renvoie une liste contenant les cases voisines disponibles pour un déplacement
     *
     * @param pos La case dans laquelle se trouve le joueur actuellement
     * @return Une ArrayList
     */
    public ArrayList<Case> getNeighbour(Case pos) {
        ArrayList<Case> res = new ArrayList<>();

        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                if (island[i][j] == pos) {
                    if (i + 1 < island.length) {
                        res.add(island[i + 1][j]);
                    }

                    if (i - 1 >= 0) {
                        res.add(island[i - 1][j]);
                    }

                    if (j + 1 < island[i].length) {
                        res.add(island[i][j + 1]);
                    }

                    if (j - 1 >= 0) {
                        res.add(island[i][j - 1]);
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

    public void assechement(Direction dir) {
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
                        Case next = island[i + offi][j + offj];
                        next.asseche();
                    } else {
                        return;
                    }
                    nextAction();
                    return;
                }
            }
        }
    }


    public void move(Direction dir) {
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
                        Case next = island[i + offi][j + offj];
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

    public void recupArtefact() {
        Joueur p = players.get(currentJoueur);
        ElementArtefact a = p.getPosition().artefact;
        if(a == null) {
            System.out.print(" Aucun artefact ");
        }else{
            if(p.invJoueur.getCles().contains(a)){
                p.invJoueur.invArtJoueur.add(a);
                p.invJoueur.retirerCle(a);
                System.out.print(" Artefact OK ");
                nextAction();
            }
            System.out.print(" Pas de cle ");
        }

    }
}