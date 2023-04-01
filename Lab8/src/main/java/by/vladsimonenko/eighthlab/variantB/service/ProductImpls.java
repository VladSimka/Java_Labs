package by.vladsimonenko.eighthlab.variantB.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class that implements Product
 */

public class ProductImpls implements Product {
    static final Logger logger = LogManager.getLogger();
    private int id;
    private String name;
    private String upc;
    private String manufacturer;
    private double price;
    private String shelfLife;
    private int quantity;
    private boolean isInStore;
    private boolean isInWarehouse;

    public ProductImpls(int id, String name, String upc, String manufacturer, double price, String shelfLife, int quantity) {
        this.id = id;
        this.name = name;
        this.upc = upc;
        this.manufacturer = manufacturer;
        this.price = price;
        this.shelfLife = shelfLife;
        this.quantity = quantity;
        isInWarehouse = false;
        isInStore = false;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getUPC() {
        return this.upc;
    }

    @Override
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getShelfLife() {
        return this.shelfLife;
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setUPC(String UPC) {
        this.upc = UPC;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;

    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void moveToWarehouse() {
        if (isInWarehouse) {
            logger.info("Товар уже находится на складе");
        } else {
            isInWarehouse = true;
            isInStore = false;
            logger.info("Товар перемещен на склад");
        }
    }

    @Override
    public void moveToStore() {
        if (isInStore) {
            logger.info("Товар уже находится в торговом зале");
        } else {
            isInWarehouse = false;
            isInStore = true;
            logger.info("Товар перемещен в торговый зал");
        }
    }

    @Override
    public void pay() {
        logger.info("Товар оплачен");
    }

    @Override
    public void writeOff() {
        if (quantity > 0) {
            logger.info("Товар списан!");
            quantity--;
        } else {
            logger.error("Товар закончился");
        }

    }

    @Override
    public String toString() {
        return "Товар: " +
                "id=" + id +
                ", имя='" + name + '\'' +
                ", штрих-код='" + upc + '\'' +
                ", производитель='" + manufacturer + '\'' +
                ", цена=" + price +
                ", срок годности='" + shelfLife + '\'' +
                ", количество=" + quantity;
    }
}
