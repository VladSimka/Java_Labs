package by.vladsimonenko.fourthlab.variantB.entity;

/**
 * Class to represent a Ball
 */
public class Ball extends Toy {
    String colour;

    public Ball(String name, String size, double price, int age, String colour) {
        super(name, size, price, age);
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Игрушка:\t" +
                "Название = '" + this.getTitle() + '\'' +
                ", Цвет = '" + this.colour + '\'' +
                ", Размер = '" + this.getSize() + '\'' +
                ", Цена = " + this.getPrice() +
                ", для детей от " + this.getAge() +
                " лет.";
    }
}
