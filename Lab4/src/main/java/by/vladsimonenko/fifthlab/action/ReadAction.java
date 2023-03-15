package by.vladsimonenko.fifthlab.action;

import by.vladsimonenko.fifthlab.exceptions.InvalidNumberException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


/**
 * Class - action for variant C
 */
public class ReadAction {
    static Logger logger = LogManager.getLogger();


    /**
     * Method that find sum of number of different locals
     *
     * @param filename path to file
     */
    public void sumFromFile(String filename) {
        double sum = 0;
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int spaceIndex = line.lastIndexOf(' ');
                String[] parts = line.split(" ");
                if (spaceIndex < 0 || parts.length != 2) {
                    throw new InvalidNumberException("Неверный формат строки: " + line);
                }

                String numberString = line.substring(0, spaceIndex);
                Locale locale = new Locale(line.substring(spaceIndex + 1));
                NumberFormat nf = NumberFormat.getInstance(locale);

                try {
                    double number = nf.parse(numberString.replace(',', '.')).doubleValue();
                    if (Math.abs(number) > 200) {
                        throw new InvalidNumberException("Число выходит за заданный диапазон: " + numberString);
                    }
                    sum += number;
                    count++;
                } catch (ParseException e) {
                    throw new InvalidNumberException("Неверная запись числа : " + numberString);
                } catch (NumberFormatException e) {
                    throw new InvalidNumberException("Невозможно преобразовать к числу : " + numberString);
                }
            }

            if (count == 0) {
                System.out.println("В файле нету чисел");
            } else {
                double average = sum / count;
                System.out.printf("Сумма : %.2f, Среднее чисел : %.2f%n", sum, average);
            }
        } catch (IOException e) {
            logger.error("Ошибка прочтения файла: " + e.getMessage());
        } catch (InvalidNumberException e) {
            logger.error("Произошла следующая ошибка: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Неизвестная ошибка: " + e.getMessage());
        }
    }
}
