package by.vladsimonenko.thirdlab.variantB._main;

import by.vladsimonenko.thirdlab.variantB.action.PolynomAction;
import by.vladsimonenko.thirdlab.variantB.entity.Polynom;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


/**
 * Class with main method for variantB
 */
public class PolynomMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int degree;
        int amount;


        System.out.println("Введите степень полиномов и их количество:");
        degree = scanner.nextInt() + 1;

        amount = scanner.nextInt();
        PolynomAction action = new PolynomAction();
        Polynom[] array = new Polynom[amount];
        Polynom result;

        for (int i = 0; i < array.length; i++) {
            array[i] = new Polynom(degree);
        }
        result = action.add(array[0], array[1]);

        for (int i = 2; i < array.length; i++) {
            result = action.add(result, array[i]);
        }

        System.out.println();
        System.out.println("Полиномы массива и их сумма:");
        for (int i = 0; i < array.length; i++) {
            System.out.println("\t" + array[i]);
        }
        System.out.println("Сумма : " + result);
        System.out.println();

        ArrayList<Polynom> list = new ArrayList<Polynom>();
        for (int i = 0; i < amount; i++) {
            list.add(new Polynom(degree));
        }
        result = action.add(list.get(0), list.get(1));
        for (int i = 2; i < array.length; i++) {
            result = action.add(result, list.get(i));
        }

        System.out.println("Полиномы списка и их сумма:");
        for (int i = 0; i < array.length; i++) {
            System.out.println("\t" + list.get(i));
        }
        System.out.println("Сумма : " + result);
        action.clearPolynom(result);
        System.out.println();


        HashSet<Polynom> set = new HashSet<Polynom>();

        for (int i = 0; i < amount; i++) {
            set.add(new Polynom(degree));
        }

        System.out.println("Полиномы множества и их сумма:");
        for (Polynom polynom : set) {
            result = action.add(result, polynom);
            System.out.println("\t" + polynom);
        }

        System.out.println("Сумма : " + result);
        System.out.println();
    }
}
