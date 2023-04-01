package by.vladsimonenko.eighthlab.variantB.service;

/**
 * Class that implements Button
 */
public class ButterImpls extends ProductImpls implements Butter {

    private int calories;

    public ButterImpls(int id, String upc, String manufacturer, double price, String shelfLife, int quantity, int calories) {
        super(id, "Масло", upc, manufacturer, price, shelfLife, quantity);
        this.calories = calories;
    }

    @Override
    public int getCalories() {
        return this.calories;
    }

    @Override
    public void setCalories(int calories) {
        this.calories = calories;
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
                ", количество калорий= " + calories;
    }
}
