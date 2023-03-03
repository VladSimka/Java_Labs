package by.vladsimonenko.fourthlab.variantB.entity;

import java.util.Random;

/**
 * Class to represent a Cube
 */
public class Cube extends Toy {
    public Cube() {
        super("Кубик", "Маленький", 10.99 + new Random().nextInt(4), 2 + new Random().nextInt(4));
    }

}
