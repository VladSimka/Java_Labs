package by.vladsimonenko.fourthlab.variantB.dao;

import by.vladsimonenko.fourthlab.variantB.entity.Entity;
import by.vladsimonenko.fourthlab.variantB.exceptions.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface BaseDao<K, T extends Entity> {
    static Logger logger = LogManager.getLogger();

    List<T> findAll() throws DaoException;

    T findEntityById(K id) throws DaoException;

    boolean delete(T t) throws DaoException;

    boolean delete(K id) throws DaoException;

    boolean create(T t) throws DaoException;

    T update(T t) throws DaoException;

    default void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    default void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }
}
