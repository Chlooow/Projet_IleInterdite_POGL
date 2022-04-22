package Modele;

import java.awt.Color;

public class Couleurs {
    public static final Color COLOR_NORMAL = Color.WHITE;
    public static final Color COLOR_FLOODED = Color.CYAN;
    public static final Color COLOR_SUBMERGED = Color.BLUE;

    public static Color fromState(WaterState state) {
        return switch (state) {
            case Normal -> COLOR_NORMAL;
            case Flooded -> COLOR_FLOODED;
            case Submerged -> COLOR_SUBMERGED;
        };
    }
}
