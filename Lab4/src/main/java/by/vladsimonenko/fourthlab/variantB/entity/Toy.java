package by.vladsimonenko.fourthlab.variantB.entity;

public abstract class Toy {
    private String name;
    private String size;
    private double price;
    private int age;

    public Toy(String name, String size, double price, int age) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.age = age;
    }

    public Toy() {
        super();
    }

    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return "Игрушка:" +
                "Название ='" + name + '\'' +
                ", Размер ='" + size + '\'' +
                ", Цена =" + price +
                ", для детей от " + age +
                " лет";
    }
}
