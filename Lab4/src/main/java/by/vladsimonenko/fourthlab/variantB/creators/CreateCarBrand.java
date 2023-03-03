package by.vladsimonenko.fourthlab.variantB.creators;

import by.vladsimonenko.fourthlab.variantB.entity.CarBrand;

import java.util.Random;

public class CreateCarBrand {
    public CarBrand createBrand() {
        int mode = new Random().nextInt(5);

        return switch (mode) {
            case 0 -> CarBrand.BENTLEY;
            case 1 -> CarBrand.AUDI;
            case 2 -> CarBrand.BMW;
            case 3 -> CarBrand.LADA;
            case 4 -> CarBrand.OPEL;
            default -> throw new IllegalArgumentException("illegal mode");
        };

    }
}
