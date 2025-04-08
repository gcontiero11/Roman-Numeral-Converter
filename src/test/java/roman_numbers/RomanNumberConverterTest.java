package roman_numbers;

import org.example.RomanNumberConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RomanNumberConverterTest {
    RomanNumberConverter romanNumberConverter;


    @BeforeEach
    public void setUp() {
        romanNumberConverter = new RomanNumberConverter();
    }

    @Test
    @DisplayName("Should convert I to the number One")
    public void shouldConvertRomanNumberIToOne() {
        assertThat(romanNumberConverter.of("I")).isEqualTo(1);
    }

    @Test
    @DisplayName("Should convert V to the number Five")
    public void shouldConvertRomanNumberVToFive() {
        assertThat(romanNumberConverter.of("V")).isEqualTo(5);
    }

    @Test
    @DisplayName("Should convert X to the number Ten")
    public void shouldConvertRomanNumberXToTen() {
        assertThat(romanNumberConverter.of("V")).isEqualTo(10);
        assertThatException().isThrownBy(() -> romanNumberConverter.of("X"));
    }


}
