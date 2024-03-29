package by.vladsimonenko.fourthlab.variantB.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

/**
 * Abstract class to represent a Toy
 */
public abstract class Toy extends Entity {
    static Logger logger = LogManager.getLogger();
    private int id;
    private String title;
    private String size;
    private double price;
    private int age;

    public Toy(String name, String size, double price, int age) {
        this.title = name;
        this.size = size;
        this.price = price;
        this.age = age;
    }

    public Toy() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "Игрушка:\t" +
                "Название = '" + title + '\'' +
                ", Размер = '" + size + '\'' +
                ", Цена = " + price +
                ", для детей от " + age +
                " лет.";
    }
}
