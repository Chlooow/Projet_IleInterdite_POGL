package Modele;

import java.awt.Color;

/** class pour les couleurs */

public class Couleurs {

    // Attributs
    // stades d'inondation
    public static final Color COLOR_NORMAL = Color.WHITE;
    public static final Color COLOR_FLOODED = Color.CYAN;
    public static final Color COLOR_SUBMERGED = Color.BLUE;

    // couleurs des elements
    public static final Color COLOR_FEU = Color.red;
    public static final Color COLOR_TERRE = Color.GREEN;
    public static final Color COLOR_AIR = Color.LIGHT_GRAY;
    public static final Color COLOR_EAU = Color.getHSBColor(193,59,60);

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
