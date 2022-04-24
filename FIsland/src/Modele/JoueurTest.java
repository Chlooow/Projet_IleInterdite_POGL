package Modele;
import static org.junit.Assert.*;
import org.junit.Test;

import java.awt.*;

public class JoueurTest {
    private CModele modele;
    @Test

    public void JoueurTests(){

        Case c = new Case(modele, 6, 7);
        Joueur j = new Joueur("Cheima", Color.GREEN, c);
        assertEquals("Cheima", j.getNomJoueur());
        //changement manuel du nom
        j.setNomJoueur("Chloe");
        assertEquals("Chloe", j.getNomJoueur());
        assertEquals(1, j.getIdJoueur());
        assertEquals(Color.GREEN, j.getCouleur());
        j.setCouleur(Color.RED);
        assertEquals(Color.RED, j.getCouleur());
       // assertEquals(6, j.getPositionX());
        //assertEquals(7, j.getPositionY());
        assertEquals(0, j.getActions());
    }
}
