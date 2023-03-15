package by.vladsimonenko.fourthlab.variantB.creators;

import by.vladsimonenko.fourthlab.variantB.entity.*;
import by.vladsimonenko.fourthlab.variantB.exceptions.CreatorException;

import java.io.Serializable;

/**
 * Class to generate a Toy
 */
public class CreateInterior implements Serializable {
    /**
     * Method that generate Toy
     *
     * @param mode choice type of Toy
     * @return some type of Toy
     */
    public static Toy generateToy(int mode) throws CreatorException {
        return switch (mode) {
            case 0 -> new Ball();
            case 1 -> new Car("Маленький");
            case 2 -> new Car("Средний");
            case 3 -> new Car("Большой");
            case 4 -> new Cube();
            case 5 -> new Doll();
            default -> throw new CreatorException("Невозможное значение");
        };
    }

}
