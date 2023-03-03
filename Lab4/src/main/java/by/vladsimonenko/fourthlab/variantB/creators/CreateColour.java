package by.vladsimonenko.fourthlab.variantB.creators;

import by.vladsimonenko.fourthlab.variantB.entity.Colour;

import java.util.Random;

/**
 * Class - action to create a Colour
 */
public class CreateColour {

    /**
     * Method that generate random Colour
     *
     * @return Colour
     */
    public Colour createColour() {
        int mode = new Random().nextInt(5);

        return switch (mode) {
            case 0 -> Colour.BLUE;
            case 1 -> Colour.RED;
            case 2 -> Colour.WHITE;
            case 3 -> Colour.GREEN;
            case 4 -> Colour.YELLOW;
            default -> throw new IllegalArgumentException("illegal mode");
        };

    }
}
