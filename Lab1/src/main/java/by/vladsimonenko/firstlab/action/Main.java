package by.vladsimonenko.firstlab.action;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        int amount;

        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Введите количество чисел:");
            amount = in.nextInt();
        }
        while (amount <= 0);

        int[] array = new int[amount];

        System.out.println("Введите числа:");

        for (int i = 0; i < amount; i++) {
            array[i] = in.nextInt();
        }

        System.out.println("Числа которые равны полусумме соседних элементов:");
        for (int i = 1; i < amount - 1; i++) {
            if (2 * array[i] == array[i - 1] + array[i + 1]) {
                System.out.print(array[i] + "  ");
            }
        }
        System.out.println();
        in.close();
    }
}
