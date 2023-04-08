package by.vladsimonenko.ninthlab.variantB.action;

/**
 * Class - action to interact with palindromes
 */
public class PalindromeAction {


    /**
     * Method that checks if string is palindrome
     *
     * @param str current string
     * @return true, if palindrome,
     * else false
     */
    public boolean isPalindrome(String str) {
        StringBuffer stringBuffer = new StringBuffer(str.toLowerCase());
        stringBuffer.reverse();
        return stringBuffer.toString().equals(str.toLowerCase());
    }

    /**
     * Method that finds max substring palindrome in current string
     *
     * @param str current string
     * @return max substring palindrome, if it exists, else " "
     */
    public String findMaxPalindromeInString(String str) {
        str = str.replaceAll("\\s+", " ");
        int max = 1;
        String result = " ";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                int substringLength = str.substring(i, j).length();

                if (isPalindrome(str.substring(i, j)) && substringLength >= max) {
                    max = substringLength;
                    result = str.substring(i, j);
                }
            }
        }
        return result;
    }
}
