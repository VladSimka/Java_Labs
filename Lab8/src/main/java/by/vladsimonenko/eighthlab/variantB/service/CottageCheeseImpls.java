package by.vladsimonenko.eighthlab.variantB.service;

/**
 * Class that implements Cottage Cheese
 */
public class CottageCheeseImpls extends ProductImpls implements CottageCheese {

    private int fatPercentage;

    public CottageCheeseImpls(int id, String upc, String manufacturer, double price,
                              String shelfLife, int quantity, int fatPercentage) {
        super(id, "Творог", upc, manufacturer, price, shelfLife, quantity);
        this.fatPercentage = fatPercentage;
    }

    @Override
    public int getFatPercentage() {
        return this.fatPercentage;
    }

    @Override
    public void setFatPercentage(int fatPercentage) {
        this.fatPercentage = fatPercentage;

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
                ", жирность= " + fatPercentage + "%";
    }
}
