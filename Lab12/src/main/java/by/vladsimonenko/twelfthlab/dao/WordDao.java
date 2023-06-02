package by.vladsimonenko.twelfthlab.dao;

import by.vladsimonenko.twelfthlab.entity.Word;
import by.vladsimonenko.twelfthlab.exceptions.DaoException;

import java.util.List;

public interface WordDao extends BaseDao<Integer, Word> {
    boolean createTable() throws DaoException;
    boolean insert() throws DaoException;
    List<String> selectBelarusianTranslate(String englishWord) throws DaoException;
    List<String> selectEnglishTranslate(String belarusianWord) throws DaoException;
    boolean isExistSuchValue(Word word) throws DaoException;
}
