package Modele;

import java.awt.*;

public class Heliport {
    // Attribut
    private CModele modele;
    private Case positionH;
    private Color colorH = Color.BLACK;
    private boolean heli;

    // Constructeurs
    public Heliport(Case posH) {
        this.positionH = posH;
        this.heli = true;
    }



}
