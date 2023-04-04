package by.vladsimonenko.ninthlab.variantB._main;

import by.vladsimonenko.ninthlab.variantB.action.PalindromeAction;

public class PalindromeMain {
    public static void main(String[] args) {
        PalindromeAction action = new PalindromeAction();
        System.out.println(action.findMaxPalindromeInString(" AmanaplanacanalPanamaWasitacaroracatisawMadamInEde  " +
                "  \n  nImAdamRacecarNoxinNixon   "));
    }
}
