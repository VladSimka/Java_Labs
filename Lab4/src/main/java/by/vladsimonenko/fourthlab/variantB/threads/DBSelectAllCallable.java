package by.vladsimonenko.fourthlab.variantB.threads;

import by.vladsimonenko.fourthlab.variantB.dao.impls.ToyDaoImpl;
import by.vladsimonenko.fourthlab.variantB.entity.Toy;
import by.vladsimonenko.fourthlab.variantB.exceptions.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class DBSelectAllCallable implements Callable<List<Toy>> {
    static Logger logger = LogManager.getLogger();

    @Override
    public List<Toy> call() {
        ToyDaoImpl toyDao = new ToyDaoImpl();

        List<Toy> result = null;

        try {
            result = new ArrayList<>(toyDao.findAll());
        } catch (DaoException e) {
            logger.error(e.getMessage());
        }
        return result;
    }
}
