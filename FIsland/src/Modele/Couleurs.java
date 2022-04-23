package Modele;

import java.awt.Color;

/** class pour les couleurs */

public class Couleurs {

    // Attributs
    // stades d'inondation
    public static final Color COLOR_NORMAL = Color.WHITE;
    public static final Color COLOR_FLOODED = Color.CYAN;
    public static final Color COLOR_SUBMERGED = new Color(0,0,153);

    // couleurs des artefact
    public static final Color COLOR_FEU = Color.red;
    public static final Color COLOR_TERRE = Color.GREEN;
    public static final Color COLOR_AIR = Color.GRAY;
    public static final Color COLOR_EAU = new Color(51, 153, 255);

    // couleurs des zones special
    public static final Color COLOR_ZONE_FEU = new Color(245,174,174);
    public static final Color COLOR_ZONE_TERRE = new Color(178, 255, 102);
    public static final Color COLOR_ZONE_AIR = Color.LIGHT_GRAY;
    public static final Color COLOR_ZONE_EAU = new Color(174, 245, 242);

    // couleurs de l'heliport
    public static final Color COLOR_Heli = Color.black;

    public static Color fromState(WaterState state) {
        return switch (state) {
            case Normal -> COLOR_NORMAL;
            case Flooded -> COLOR_FLOODED;
            case Submerged -> COLOR_SUBMERGED;
        };
    }

    public static Color fromElement(ElementArtefact artefact) {
        return switch (artefact) {
            case EAU -> COLOR_EAU;
            case AIR -> COLOR_AIR;
            case TERRE -> COLOR_TERRE;
            case FEU -> COLOR_FEU;
        };
    }
}
