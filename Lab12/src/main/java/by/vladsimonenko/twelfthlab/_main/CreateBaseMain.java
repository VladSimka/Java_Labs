package by.vladsimonenko.twelfthlab._main;

import by.vladsimonenko.twelfthlab.dao.impl.WordDaoImpl;
import by.vladsimonenko.twelfthlab.exceptions.DaoException;

public class CreateBaseMain {
    public static void main(String[] args) {
        WordDaoImpl wordDao = new WordDaoImpl();
        try {
            wordDao.createTable();
            wordDao.insert();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
