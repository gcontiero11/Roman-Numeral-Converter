package org.example;

public class RomanNumberConverter {
    public int of(String romanNumber) {
        int answer = switch (romanNumber) {
                        case "I" ->  1;
                        case "V" ->  5;
            default -> throw new IllegalStateException("Unexpected value: " + romanNumber);
        };


        return answer;
    }
}
