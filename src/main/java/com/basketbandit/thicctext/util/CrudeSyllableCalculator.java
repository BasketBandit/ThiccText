package com.basketbandit.thicctext.util;

public class CrudeSyllableCalculator {
    public static int countLonelyVowels(String word) {
        int i = 0;
        for(String letter: word.split("")) {
            if(letter.matches("[AaEeIiOoUuâãäåæçèéêëìíîïðñòóôõøùúûü]")) {
                i++;
            }
        }
        return i;
    }
}
