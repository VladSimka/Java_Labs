package by.vladsimonenko.twelfthlab._main;

import by.vladsimonenko.twelfthlab.dao.impl.WordDaoImpl;
import by.vladsimonenko.twelfthlab.entity.InfoForDataBase;
import by.vladsimonenko.twelfthlab.exceptions.DaoException;

import java.util.List;
import java.util.Scanner;

public class DataBaseMain {
    public static void main(String[] args) {


        WordDaoImpl wordDao = new WordDaoImpl();
        try {
            Scanner scanner = new Scanner(System.in);

            while (true){
                System.out.println("Введите английское слово на перевод(0, чтобы выйти):");
                String word = scanner.nextLine();
                if(word.equals("0")){
                    break;
                }
                List<String> result = wordDao.selectBelarusianTranslate(word);

                if(result.size()==0){
                    System.out.println("Таких слов не найдено!");
                }
                else {
                    System.out.println("Перевод слова "+ word+" :");
                    for (int i=0;i<result.size();i++){
                        System.out.println(result.get(i));
                    }

                    System.out.println();
                }

            }




        } catch (DaoException e) {
            e.printStackTrace();
        }

    }
}
