package by.vladsimonenko.tenth.variantA.action;

/**
 * Class - action for text
 */
public class TextAction {

    /**
     * Method that convert text to string array
     * @param text current text
     * @return string array
     */
    public String[] textToArray(String text){

        text = text.replaceAll("\\p{Punct}", "");
        text = text.replaceAll("—", " ");
        text = text.replaceAll("-", " ");
        String[] result = text.split("\\s+");
        return result;
    }
}
