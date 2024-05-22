package ru.bluebasooo.market.mobilemarket.cache.util;

import java.util.function.Predicate;

public class FuzzySearchPredictor implements Predicate<String> {
    private static final int NUMBER_OF_MISTAKES = 3;
    private final char[] valueToFound;

    public FuzzySearchPredictor(String valueToFound) {
        this.valueToFound = valueToFound.toCharArray();
    }

    @Override
    public boolean test(String s) {
        var testValue = s.toCharArray();

        int min = Math.min(valueToFound.length, testValue.length);
        int mistakesCounter = 0;

        for(int i = 0; i < min; i++) {
            if (mistakesCounter > NUMBER_OF_MISTAKES) return false;

            if (valueToFound[i] != testValue[i]) mistakesCounter++;
        }

        return true;
    }


}
