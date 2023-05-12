package by.vladsimonenko.fourthlab.variantB.entity;

/**
 * Class to represent a Car
 */
public class Car extends Toy {
    String brand;

    public Car(String name, String size, double price, int age, String brand) {
        super(name, size, price, age);
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Игрушка:\t" +
                "Название = '" + this.getTitle() + '\'' +
                ", Марка = '" + this.brand + '\'' +
                ", Размер = '" + this.getSize() + '\'' +
                ", Цена = " + this.getPrice() +
                ", для детей от " + this.getAge() +
                " лет.";
    }
}
