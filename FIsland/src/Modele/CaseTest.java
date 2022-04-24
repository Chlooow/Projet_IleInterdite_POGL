package Modele;
import static org.junit.Assert.*;
import org.junit.Test;

public class CaseTest {
    private CModele modele;

    @Test
    public void CaseTests(){

        Case c = new Case(modele, 6, 7);

        //on teste les coordonnees de la case dans la grille
        assertEquals(6, c.getX());
        assertEquals(7, c.getY());

        //on teste le niveau de l'eau
        assertEquals(WaterState.Normal, c.getEtat());

        c.innonde();
        //apres inondation
        assertEquals(WaterState.Flooded, c.getEtat());

        c.asseche();
        //apres assechement
        assertEquals(WaterState.Normal, c.getEtat());

        //on teste la gestion manuelle du niveau de l'eau
        c.setEtat(WaterState.Submerged);
        assertEquals(WaterState.Submerged, c.getEtat());
    }
}
