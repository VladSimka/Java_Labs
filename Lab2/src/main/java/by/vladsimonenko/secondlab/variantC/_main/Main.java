package by.vladsimonenko.secondlab.variantC._main;

import java.util.Date;
import java.util.Scanner;

import by.vladsimonenko.secondlab.variantC.action.Action;

/**
 * Class in which the task is performed.
 *
 * @author Симоненко В.А.
 * @version 1.0
 */
public class Main {


    /**
     * The main method.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        int dimension;

        Scanner in = new Scanner(System.in);
        System.out.println("Введите размерность матрицы:");

        do {
            dimension = in.nextInt();
        }
        while (dimension <= 0);

        int[][] matrix = new int[dimension][dimension];


        // Fill matrix with random values from [-dimension,dimension]


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = (int) (Math.random() * (2 * dimension + 1) - dimension);
            }
        }

        System.out.println("Сгенерированная матрица:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%4d\t", matrix[i][j]);
            }
            System.out.println();
        }

        int countPoints = 0;
        Action action = new Action();

        System.out.println();
        System.out.println("Седловые точки:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (action.isMinInRow(matrix, i, j) && action.isMaxInColumn(matrix, i, j)) {
                    countPoints++;
                    System.out.printf("%4d%s\t", matrix[i][j], "'");
                } else {
                    System.out.printf("%4d\t", matrix[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Количество седловых точек: " + countPoints);

        Date date = new Date();


        System.out.println();
        System.out.println("Разработчик: Симоненко В.А.");
        System.out.println("Задание получено: Sat Feb 11 09:45:00 MSK 2023 ");
        System.out.println("Дата сдачи задания: " + date);
        in.close();
    }
}
