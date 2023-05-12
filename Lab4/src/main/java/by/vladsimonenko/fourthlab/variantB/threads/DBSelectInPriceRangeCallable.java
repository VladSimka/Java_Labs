package by.vladsimonenko.fourthlab.variantB.threads;

import by.vladsimonenko.fourthlab.variantB.dao.impls.ToyDaoImpl;
import by.vladsimonenko.fourthlab.variantB.entity.Toy;
import by.vladsimonenko.fourthlab.variantB.exceptions.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class DBSelectInPriceRangeCallable implements Callable<List<Toy>> {
    static Logger logger = LogManager.getLogger();
    double minPrice;
    double maxPrice;

    public DBSelectInPriceRangeCallable(double minPrice, double maxPrice) {
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    @Override
    public List<Toy> call() {
        ToyDaoImpl toyDao = new ToyDaoImpl();
        List<Toy> toys = null;

        try {
            toys = new ArrayList<>(toyDao.findToysByPriceRange(minPrice, maxPrice));
        } catch (DaoException e) {
            logger.error(e.getMessage());
        }
        return toys;
    }
}
