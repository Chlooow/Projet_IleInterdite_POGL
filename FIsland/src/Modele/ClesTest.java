package Modele;
import static org.junit.Assert.*;
import org.junit.Test;


public class ClesTest {
    @Test
    public void ClesTests(){
        Cles keyA = new Cles(ElementArtefact.AIR);
        Cles keyF = new Cles(ElementArtefact.FEU);
        Cles keyE = new Cles(ElementArtefact.EAU);
        Cles keyT = new Cles(ElementArtefact.TERRE);
        assertEquals(ElementArtefact.AIR, keyA.getElementOfKey());
        assertEquals(ElementArtefact.FEU, keyF.getElementOfKey());
        assertEquals(ElementArtefact.EAU, keyE.getElementOfKey());
        assertEquals(ElementArtefact.TERRE, keyT.getElementOfKey());
    }
}
