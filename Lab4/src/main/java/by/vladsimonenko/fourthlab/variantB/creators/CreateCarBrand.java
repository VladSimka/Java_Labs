package by.vladsimonenko.fourthlab.variantB.creators;

import by.vladsimonenko.fourthlab.variantB.entity.CarBrand;
import by.vladsimonenko.fourthlab.variantB.exceptions.CreatorException;

import java.util.Random;

/**
 * Class - action to create Car Brand
 */
public class CreateCarBrand {
    /**
     * Method that generate random Car Brand
     *
     * @return Car Brand
     */
    public CarBrand createBrand() throws CreatorException {
        int mode = new Random().nextInt(5);

        return switch (mode) {
            case 0 -> CarBrand.BENTLEY;
            case 1 -> CarBrand.AUDI;
            case 2 -> CarBrand.BMW;
            case 3 -> CarBrand.LADA;
            case 4 -> CarBrand.OPEL;
            default -> throw new CreatorException("illegal mode");
        };

    }
}
