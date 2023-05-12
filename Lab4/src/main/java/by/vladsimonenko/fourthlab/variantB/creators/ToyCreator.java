package by.vladsimonenko.fourthlab.variantB.creators;

import by.vladsimonenko.fourthlab.variantB.entity.*;
import by.vladsimonenko.fourthlab.variantB.exceptions.CreatorException;

public class ToyCreator {
    public static Toy generateToy(String title, String size, double price, int age, String colour, String brand) throws CreatorException {
        return switch (title) {
            case "Мячик" -> new Ball(title,size,price,age,colour);
            case "Машинка" -> new Car(title,size,price,age,brand);
            case "Кубик" -> new Cube(title,size,price,age);
            case "Кукла" -> new Doll(title,size,price,age);
            default -> throw new CreatorException("Невозможное значение");
        };
    }
}
