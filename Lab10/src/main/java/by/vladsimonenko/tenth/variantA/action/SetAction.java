package by.vladsimonenko.tenth.variantA.action;
import java.util.HashSet;
import java.util.Set;

/**
 * Class - action for set
 */
public class SetAction {
    /**
     * Method that find all unique words in string array
     * @param words current array
     */
    public void findAllUniqueWords(String[] words) {
        Set<String> stringSet = new HashSet<>();


        System.out.println("Все уникальные слова текста:");
        for (int i = 0; i < words.length; i++) {
            if (stringSet.add(words[i].toLowerCase())) {
                System.out.print(words[i] + "  ");
            }
            if ((i+1) % 10 == 0){
                System.out.println();
            }
        }

    }
}
