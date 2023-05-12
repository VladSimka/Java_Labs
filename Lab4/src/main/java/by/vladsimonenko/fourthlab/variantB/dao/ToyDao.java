package by.vladsimonenko.fourthlab.variantB.dao;

import by.vladsimonenko.fourthlab.variantB.entity.Toy;
import by.vladsimonenko.fourthlab.variantB.exceptions.DaoException;

import java.util.List;

public interface ToyDao extends BaseDao<Integer, Toy> {
    List<Toy> findToysByPriceRange(double minPrice, double maxPrice) throws DaoException;
}
