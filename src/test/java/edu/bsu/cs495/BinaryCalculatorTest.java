package edu.bsu.cs495;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryCalculatorTest {

    private final BinaryCalculator binaryCalculator = new BinaryCalculator();

    @Test
    void testSquareReturnsBinarySquare() {
        String two = "10";
        String four = "100";
        Assertions.assertEquals(four, binaryCalculator.square(two).toString());
    }

    @Test
    void testSquareReturnsEmptyStringBuilder_emptyString() {
        Assertions.assertEquals("", binaryCalculator.square("").toString());
    }

    @Test
    void testSquareReturnsEmptyStingBuilder_null() {
        Assertions.assertEquals("", binaryCalculator.square(null).toString());
    }
}
