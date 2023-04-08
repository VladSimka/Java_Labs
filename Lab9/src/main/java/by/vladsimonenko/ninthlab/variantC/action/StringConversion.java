package by.vladsimonenko.ninthlab.variantC.action;

import java.util.ArrayList;
import java.util.List;

public class StringConversion {

    public String inverseBurrowsWheelerTransform(String str, int position) {
        List<StringBuffer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(new StringBuffer());
        }


        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                list.get(j).insert(0, str.charAt(j));
            }
            System.out.println("Добавление " + (i + 1));
            for (StringBuffer stringBuffer : list) {
                System.out.println(stringBuffer);
            }

            list.sort(StringBuffer::compareTo);

            System.out.println("После " + (i + 1) + " сортировки: ");
            for (StringBuffer stringBuffer : list) {
                System.out.println(stringBuffer);
            }
            System.out.println();
        }


        return list.get(position - 1).toString();
    }
}
