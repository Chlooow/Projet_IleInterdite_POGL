import Modele.CModele;
import Vue.CVue;

import java.awt.*;

/* Classe Principale*/

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {

            CModele modele = new CModele();
            CVue vue = new CVue(modele);
        });
    }

}
