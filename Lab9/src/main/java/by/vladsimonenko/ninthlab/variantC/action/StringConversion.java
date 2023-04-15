package by.vladsimonenko.ninthlab.variantC.action;

import java.util.ArrayList;
import java.util.List;

public class StringConversion {

    public String inverseBurrowsWheelerTransform(String str, int position) {
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(new StringBuilder());
        }


        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                list.get(j).insert(0, str.charAt(j));
            }
            System.out.println("Добавление " + (i + 1));
            for (StringBuilder builder : list) {
                System.out.println(builder);
            }

            list.sort(StringBuilder::compareTo);

            System.out.println("После " + (i + 1) + " сортировки: ");
            for (StringBuilder builder : list) {
                System.out.println(builder);
            }
            System.out.println();
        }


        return list.get(position - 1).toString();
    }
}
