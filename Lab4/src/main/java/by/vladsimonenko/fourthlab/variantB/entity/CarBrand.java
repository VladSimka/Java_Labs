package by.vladsimonenko.fourthlab.variantB.entity;

/**
 * Enum of Brands
 */
public enum CarBrand {
    BMW("БМВ"), AUDI("Ауди"), OPEL("Опель"), LADA("Лада"), BENTLEY("Бентли");
    private String brand;

    CarBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

}
