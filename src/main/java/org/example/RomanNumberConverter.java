package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RomanNumberConverter {

    public int arabicNumberFrom(String romanNumber) {
        if (romanNumber == null || romanNumber.isEmpty()) {
            throw new IllegalArgumentException("Invalid roman number, should not be empty");
        }
        char[] charsIn = romanNumber.toCharArray();
        List<Integer> arabicNumerals = new ArrayList<>();
        List<Character> romanNumeralChars = new ArrayList<>();

        for (char c : charsIn) {
            romanNumeralChars.add(c);
        }

        romanNumeralChars.forEach(c -> {
            arabicNumerals.add(RomanCharToArabicConverter(c));
        });

        if (hasTheSameFourIntsOnSequence(arabicNumerals))
            throw new IllegalArgumentException("Invalid roman number format");

        return sumArabicNumeralsWithRomanNumeralsLogic(arabicNumerals);
    }

    private boolean hasTheSameFourIntsOnSequence(List<Integer> arabicNumerals) {
        if (arabicNumerals.size() < 4) return false;

        final int LIMIT_OF_REPS = 3;
        int currentNum;
        int previousNum = 0;
        int currentReps = 0;

        for (Integer num : arabicNumerals) {
            currentNum = num;
            if (currentNum == previousNum) {
                currentReps += 1;
                if (currentReps >= LIMIT_OF_REPS) return true;
            } else {
                currentReps = 0;
            }
            previousNum = currentNum;
        }
        return false;
    }

    private int sumArabicNumeralsWithRomanNumeralsLogic(List<Integer> arabicNumerals) {
        int sum = 0;
        int currentNum;
        int previousNum = 0;

        for (int i = 0; i < arabicNumerals.size(); i++) {
            currentNum = arabicNumerals.get(i);
            if (i != arabicNumerals.size() - 1) {
                if (arabicNumerals.get(i + 1) > currentNum) {
                    if (currentNum >= previousNum && i > 0)
                        throw new IllegalArgumentException("Invalid roman number format");
                    sum = sum - currentNum;
                } else {
                    sum = sum + currentNum;
                }
            } else {
                sum = sum + currentNum;
            }
            previousNum = currentNum;
        }
        System.out.println(sum);
        return sum;
    }

    private int RomanCharToArabicConverter(Character romanNumber) {
        return (
                switch (romanNumber) {
                    case 'I' -> 1;
                    case 'V' -> 5;
                    case 'X' -> 10;
                    case 'L' -> 50;
                    case 'C' -> 100;
                    case 'D' -> 500;
                    case 'M' -> 1000;
                    default -> 0;
                }
        );
    }
}
