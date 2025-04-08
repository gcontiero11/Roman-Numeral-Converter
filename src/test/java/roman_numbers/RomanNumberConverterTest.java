package roman_numbers;

import org.example.RomanNumberConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class RomanNumberConverterTest {
    RomanNumberConverter romanNumberConverter;


    @BeforeEach
    public void setUp() {
        romanNumberConverter = new RomanNumberConverter();
    }


    @ParameterizedTest
    @CsvSource({
            "I,1",
            "IV,4",
            "V,5",
            "VI,6",
            "X,10",
            "XIII,18",
            "XIX,19",
            "XX,20",
            "L,50",
            "C,100",
            "D,500",
            "M,1000"
    })
    @DisplayName("Should convert roman numeral to arabic numeral")
    void shouldConvertRomanNumeralToArabicNumeral(String romanNumeral, int arabicNumeral) {
        assertThat(romanNumberConverter.of(romanNumeral)).isEqualTo(arabicNumeral);
    }

    @Test
    void shouldThrowExceptionOnEmptyString() {
        assertThatException().isThrownBy(() -> romanNumberConverter.of(""));
    }

    @Test
    void shouldThrowExceptionOnNullString() {
        assertThatException().isThrownBy(() -> romanNumberConverter.of(null));
    }
}
