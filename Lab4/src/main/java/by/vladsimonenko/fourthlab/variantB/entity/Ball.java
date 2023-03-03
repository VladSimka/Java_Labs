package by.vladsimonenko.fourthlab.variantB.entity;

import by.vladsimonenko.fourthlab.variantB.creators.CreateColour;

import java.util.Random;

/**
 * Class to represent a Ball
 */
public class Ball extends Toy {
    Colour colour;

    public Ball() {
        super("Мячик", "Средний", 12.5 + new Random().nextInt(3), 2 + new Random().nextInt(3));
        colour = new CreateColour().createColour();
    }

    @Override
    public String toString() {
        return "Игрушка:\t" +
                "Название = '" + this.getTitle() + '\'' +
                ", Цвет = '" + colour.getColour() + '\'' +
                ", Размер = '" + this.getSize() + '\'' +
                ", Цена = " + this.getPrice() +
                ", для детей от " + this.getAge() +
                " лет.";
    }
}
