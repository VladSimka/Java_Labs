package by.vladsimonenko.eighthlab.variantB.service;

/**
 * Interface that describes Product
 */
public interface Product {
    int getId();
    String getName();
    String getUPC();
    String getManufacturer();
    double getPrice();
    String getShelfLife();
    int getQuantity();

    void setId(int id);
    void setName(String name);
    void setUPC(String upc);
    void setManufacturer(String manufacturer);
    void setPrice(double price);
    void setShelfLife(String shelfLife);
    void setQuantity(int quantity);
    void moveToWarehouse();
    void moveToStore();
    void pay();
    void writeOff();
}
