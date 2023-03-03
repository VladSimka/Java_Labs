package by.vladsimonenko.fourthlab.variantB.entity;

import java.util.Random;

public class Cube extends Toy{
    public Cube() {
        super("Кубик","Маленький",10.99,2+new Random().nextInt(4));
    }

}
