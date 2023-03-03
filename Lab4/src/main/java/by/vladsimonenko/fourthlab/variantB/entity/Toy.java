package by.vladsimonenko.fourthlab.variantB.entity;

public abstract class Toy {
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
        return "Игрушка: " +
                "Название = '" + title + '\'' +
                ", Размер = '" + size + '\'' +
                ", Цена = " + price +
                ", для детей от " + age +
                " лет";
    }
}
