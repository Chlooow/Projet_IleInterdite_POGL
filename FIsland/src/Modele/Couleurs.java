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

    // couleur des joueurs
    public static final Color COLOR_JOUEUR1 = new Color(234, 145, 73);
    public static final Color COLOR_JOUEUR2 = new Color(56, 250, 145);
    public static final Color COLOR_JOUEUR3 = new Color(255, 100, 190);
    public static final Color COLOR_JOUEUR4 = new Color(78, 56, 230);

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

    public static Color getPlayerColor(int value) {
        return switch (value) {
            case 1 -> COLOR_JOUEUR1;
            case 2 -> COLOR_JOUEUR2;
            case 3 -> COLOR_JOUEUR3;
            case 4 -> COLOR_JOUEUR4;
            default -> Color.WHITE;
        };
    }
}
