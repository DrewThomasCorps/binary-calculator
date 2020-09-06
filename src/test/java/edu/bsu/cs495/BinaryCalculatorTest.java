package edu.bsu.cs495;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ranges.RangeException;

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

    @Test
    void testCalculateAddition() {
        binaryCalculator.add("1");
        String actualSum = binaryCalculator.calculate("101").toString();
        String expectedSum = "6";

        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Test
    void testCalculateAdditionThrowsRangeError() {
        binaryCalculator.add("111111111111111111111111111111111111111111111111111111111111111");

        Assertions.assertThrows(RangeException.class, () -> binaryCalculator.calculate("1"));
    }
}
