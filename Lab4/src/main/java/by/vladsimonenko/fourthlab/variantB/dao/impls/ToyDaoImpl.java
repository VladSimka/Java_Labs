package by.vladsimonenko.fourthlab.variantB.dao.impls;

import by.vladsimonenko.fourthlab.variantB.creators.ToyCreator;
import by.vladsimonenko.fourthlab.variantB.dao.ToyDao;
import by.vladsimonenko.fourthlab.variantB.db.ConnectionCreator;
import by.vladsimonenko.fourthlab.variantB.entity.Toy;
import by.vladsimonenko.fourthlab.variantB.exceptions.CreatorException;
import by.vladsimonenko.fourthlab.variantB.exceptions.DaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToyDaoImpl implements ToyDao {

    private static final String SQL_SELECT_ALL_TOYS =
            "SELECT toy_id, title, size, price, age, colour, brand FROM toy";

    private static final String SQL_SELECT_TOYS_IN_GIVEN_PRICE_RANGE =
            "SELECT toy_id, title, size, price, age, colour, brand FROM toy WHERE price BETWEEN ? AND ?";

    private static final String SQL_FIND_ENTITY_BY_ID =
            "SELECT toy_id, title, size, price, age, colour, brand FROM toy WHERE toy_id = ?";

    @Override
    public List<Toy> findAll() throws DaoException {
        List<Toy> toys = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_TOYS);
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String size = resultSet.getString("size");
                double price = resultSet.getDouble("price");
                int age = resultSet.getInt("age");
                String colour = resultSet.getString("colour");
                String brand = resultSet.getString("brand");

                Toy toy = ToyCreator.generateToy(title, size, price, age, colour, brand);
                toys.add(toy);
            }
        } catch (SQLException | CreatorException e) {
            throw new DaoException();
        } finally {
            close(statement);
            close(connection);
        }

        return toys;
    }

    @Override
    public Toy findEntityById(Integer id) throws DaoException {
        Connection connection = null;
        PreparedStatement statement = null;
        Toy toy = null;


        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_FIND_ENTITY_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            String title = resultSet.getString("title");
            String size = resultSet.getString("size");
            double price = resultSet.getDouble("price");
            int age = resultSet.getInt("age");
            String colour = resultSet.getString("colour");
            String brand = resultSet.getString("brand");

            toy = ToyCreator.generateToy(title, size, price, age, colour, brand);
        } catch (SQLException | CreatorException e) {
            throw new DaoException();
        }

        return toy;
    }

    @Override
    public boolean delete(Toy toy) throws DaoException {
        throw new DaoException();
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        throw new DaoException();
    }

    @Override
    public boolean create(Toy toy) throws DaoException {
        throw new DaoException();
    }

    @Override
    public Toy update(Toy toy) throws DaoException {
        throw new DaoException();
    }

    @Override
    public List<Toy> findToysByPriceRange(double minPrice, double maxPrice) throws DaoException {
        List<Toy> toys = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.prepareStatement(SQL_SELECT_TOYS_IN_GIVEN_PRICE_RANGE);
            statement.setDouble(1, minPrice);
            statement.setDouble(2, maxPrice);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String size = resultSet.getString("size");
                double price = resultSet.getDouble("price");
                int age = resultSet.getInt("age");
                String colour = resultSet.getString("colour");
                String brand = resultSet.getString("brand");

                Toy toy = ToyCreator.generateToy(title, size, price, age, colour, brand);
                toys.add(toy);
            }


        } catch (SQLException | CreatorException e) {
            throw new DaoException();
        }


        return toys;
    }
}
