package by.vladsimonenko.eighthlab.variantB.service;

/**
 * Class that implements Milk
 */
public class MilkImpls extends ProductImpls implements Milk {
    private double fatContent;

    public MilkImpls(int id, String upc, String manufacturer, double price, String shelfLife, int quantity, double fatContent) {
        super(id, "Молоко", upc, manufacturer, price, shelfLife, quantity);
        this.fatContent = fatContent;

    }

    @Override
    public double getFatContent() {
        return this.fatContent;
    }

    @Override
    public void setFatContent(double fatContent) {
        this.fatContent = fatContent;
    }


    @Override
    public String toString() {
        return "Товар: " +
                "id= " + this.getId() +
                ", имя= " + this.getName() + ",\n" +
                "штрих-код= " + this.getUPC() + ",\n" +
                "производитель= " + this.getManufacturer() + ",\n" +
                "цена= " + this.getPrice() +
                ", срок годности= " + this.getShelfLife() + ",\n" +
                "количество= " + this.getQuantity() +
                ", жирность= " + fatContent + "%";
    }
}
