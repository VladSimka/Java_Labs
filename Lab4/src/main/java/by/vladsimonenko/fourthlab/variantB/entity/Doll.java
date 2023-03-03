package by.vladsimonenko.fourthlab.variantB.entity;

import java.util.Random;

/**
 * Class to represent a Doll
 */
public class Doll extends Toy {
    public Doll() {
        super("Кукла", "Большой", 15.99, 3 + new Random().nextInt(3));
    }
}
