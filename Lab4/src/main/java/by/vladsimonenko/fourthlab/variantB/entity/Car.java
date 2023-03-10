package by.vladsimonenko.fourthlab.variantB.entity;

import by.vladsimonenko.fourthlab.variantB.creators.CreateCarBrand;
import by.vladsimonenko.fourthlab.variantB.exceptions.CreatorException;

import java.util.Random;

/**
 * Class to represent a Car
 */
public class Car extends Toy {
    CarBrand brand;

    public Car(String size) throws CreatorException {
        super("Машинка", size, 11.99 + new Random().nextInt(4), 3 + new Random().nextInt(3));
        brand = new CreateCarBrand().createBrand();
    }

    @Override
    public String toString() {
        return "Игрушка:\t" +
                "Название = '" + this.getTitle() + '\'' +
                ", Марка = '" + brand.getBrand() + '\'' +
                ", Размер = '" + this.getSize() + '\'' +
                ", Цена = " + this.getPrice() +
                ", для детей от " + this.getAge() +
                " лет.";
    }
}
