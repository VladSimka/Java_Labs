package by.vladsimonenko.twelfthlab._main;

import by.vladsimonenko.twelfthlab.dao.impl.WordDaoImpl;
import by.vladsimonenko.twelfthlab.exceptions.DaoException;

public class DeleteBaseMain {
    public static void main(String[] args) {
        WordDaoImpl wordDao = new WordDaoImpl();
        try {
            wordDao.delete();
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
