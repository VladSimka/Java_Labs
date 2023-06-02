package by.vladsimonenko.twelfthlab.dao.impl;

import by.vladsimonenko.twelfthlab.dao.WordDao;
import by.vladsimonenko.twelfthlab.db.ConnectionCreator;
import by.vladsimonenko.twelfthlab.entity.InfoForDataBase;
import by.vladsimonenko.twelfthlab.entity.Word;
import by.vladsimonenko.twelfthlab.exceptions.DaoException;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WordDaoImpl implements WordDao {
    private static final String SQL_CREATE_WORDS_TABLE =
    //"DROP TABLE IF EXISTS word;" +
                    "CREATE TABLE word(" +
                    "word_id     INT PRIMARY KEY AUTO_INCREMENT," +
                    "belarusianWord     VARCHAR(50)," +
                    "englishWord        VARCHAR(30)" +
                    ")";

    private static final String SQL_DELETE_WORDS_TABLE =
            "DROP TABLE word";
    private static final String SQL_INSERT_VALUES_INTO_WORDS =
            "INSERT INTO word (belarusianWord, englishWord) VALUES (? , ?)";
    private static final String SQL_SELECT_ALL_WORDS =
            "SELECT belarusianWord, englishWord FROM word";
    private static final String SQL_SELECT_ALL_BELARUSIAN_WORDS =
            "SELECT belarusianWord FROM word";
    private static final String SQL_SELECT_BELARUSIAN_WORDS =
            "SELECT belarusianWord FROM word WHERE englishWord = ?";

    @Override
    public List<Word> findAll() throws DaoException {
        return null;
    }

    @Override
    public Word findEntityById(Integer id) throws DaoException {
        return null;
    }

    @Override
    public boolean delete() throws DaoException {
        Connection connection = null;
        Statement statement = null;
        boolean result = false;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();

            statement.executeUpdate(SQL_DELETE_WORDS_TABLE);

            result = true;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
            return result;
        }
    }

    @Override
    public boolean delete(Integer id) throws DaoException {
        return false;
    }

    @Override
    public boolean create(Word word) throws DaoException {
        return false;
    }

    @Override
    public Word update(Word word) throws DaoException {
        return null;
    }

    @Override
    public boolean createTable() throws DaoException {
        Connection connection = null;
        Statement statement = null;
        boolean result = false;
        try {
            connection = ConnectionCreator.createConnection();
            statement = connection.createStatement();

            statement.executeUpdate(SQL_CREATE_WORDS_TABLE);

            result = true;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(statement);
            close(connection);
            return result;
        }
    }

    @Override
    public boolean insert() throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean result = false;
        try {
            connection = ConnectionCreator.createConnection();
            preparedStatement = connection.prepareStatement(SQL_INSERT_VALUES_INTO_WORDS);
            InfoForDataBase info = new InfoForDataBase();
            List<Word> words = info.getInfo();
            for (int i = 0; i < words.size(); i++) {
                preparedStatement.setString(1,words.get(i).getBelarusianWord());
                preparedStatement.setString(2,words.get(i).getEnglishWord());
                preparedStatement.executeUpdate();
            }
            result = true;
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(connection);
            return result;
        }
    }

    @Override
    public List<String> selectBelarusianTranslate(String englishWord) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<String> words = null;
        try {
            connection = ConnectionCreator.createConnection();
            preparedStatement = connection.prepareStatement(SQL_SELECT_BELARUSIAN_WORDS);
            words = new ArrayList<>();
            preparedStatement.setString(1,englishWord);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
               // System.out.println(resultSet.getString("belarusianWord"));
                words.add(resultSet.getString("belarusianWord"));
            }

        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            close(connection);
            close(preparedStatement);
            return words;
        }
    }

    @Override
    public List<String> selectEnglishTranslate(String belarusianWord) throws DaoException {
        return null;
    }

    @Override
    public boolean isExistSuchValue(Word word) throws DaoException {
        return false;
    }
}
