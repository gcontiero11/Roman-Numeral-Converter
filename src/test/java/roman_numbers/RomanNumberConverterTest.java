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
            "XIII,13",
            "XVIII,18",
            "XIX,19",
            "XX,20",
            "L,50",
            "C,100",
            "LLL,150",
            "D,500",
            "M,1000"
    })
    @DisplayName("Should convert roman numeral to arabic numeral")
    void shouldConvertRomanNumeralToArabicNumeral(String romanNumeral, int arabicNumeral) {
        assertThat(romanNumberConverter.arabicNumberFrom(romanNumeral)).isEqualTo(arabicNumeral);
    }

    @ParameterizedTest
    @CsvSource({
            "IIII",
            "IIIV",
            "IIV"
    })
    @DisplayName("Should Throw Exception Of Invalid Roman Number")
    void shouldThrowExceptionOfInvalidRomanNumber(String romanNumeral) {
        assertThatIllegalArgumentException().isThrownBy(() -> romanNumberConverter.arabicNumberFrom(romanNumeral));
    }

    @Test
    void shouldThrowExceptionOnEmptyString() {
        assertThatException().isThrownBy(() -> romanNumberConverter.arabicNumberFrom(""));
    }

    @Test
    void shouldThrowExceptionOnNullString() {
        assertThatException().isThrownBy(() -> romanNumberConverter.arabicNumberFrom(null));
    }
}
