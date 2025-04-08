package org.example;

public class RomanNumberConverter {
    public int of(String romanNumber) {
        int answer = switch (romanNumber) {
                        case "I" ->  1;
                        case "V" ->  5;
                        case "X" ->  10;
                        case "L" ->  50;
                        case "C" ->  100;
                        case "D" ->  500;
                        case "M" ->  1000;
            default -> throw new IllegalStateException("Unexpected value: " + romanNumber);
        };


        return answer;
    }
}
