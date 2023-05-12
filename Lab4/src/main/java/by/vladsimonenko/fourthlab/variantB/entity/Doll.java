package by.vladsimonenko.fourthlab.variantB.entity;

import java.io.Serializable;
import java.util.Random;

/**
 * Class to represent a Doll
 */
public class Doll extends Toy implements Serializable {
    public Doll(String name, String size, double price, int age) {
        super(name, size, price, age);
    }
}
