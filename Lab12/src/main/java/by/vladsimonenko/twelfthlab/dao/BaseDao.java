package by.vladsimonenko.twelfthlab.dao;

import by.vladsimonenko.twelfthlab.entity.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface BaseDao<K, T extends Entity> {
    static Logger logger = LogManager.getLogger();

    List<T> findAll();
    T findEntityById(K id);
    boolean delete(T t);
    boolean delete(K id);
    boolean create(T t);
    T update(T t);

    default void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            logger.error(e);
        }
    }




}
