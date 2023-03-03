package by.vladsimonenko.fourthlab.variantB.entity;

/**
 * Enum of colours
 */
public enum Colour {
    GREEN("Зеленый"), BLUE("Голубой"), WHITE("Белый"), RED("Красный"), YELLOW("Жёлтый");

    private String colour;

    Colour(String colour) {
        this.colour = colour;
    }

    public String getColour() {
        return colour;
    }
}
