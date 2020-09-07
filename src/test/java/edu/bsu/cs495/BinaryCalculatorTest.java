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
        String expectedSum = Long.toBinaryString(6);

        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Test
    void testCalculateAdditionThrowsArithmeticException() {
        String maxVal = Long.toBinaryString(Long.MAX_VALUE);
        binaryCalculator.add(maxVal); //Long.MAX_VALUE

        Assertions.assertThrows(ArithmeticException.class, () -> binaryCalculator.calculate("1"));
    }

    @Test
    void testCalculateSubtraction() {
        binaryCalculator.subtract("101");
        String actualDifference = binaryCalculator.calculate("1").toString();
        String expectedDifference = Long.toBinaryString(4);

        Assertions.assertEquals(expectedDifference, actualDifference);
    }

    @Test
    void testCalculateMultiplication() {
        binaryCalculator.multiply("100");
        String actualProduct = binaryCalculator.calculate("11").toString();
        String expectedProduct = Long.toBinaryString(12);

        Assertions.assertEquals(expectedProduct, actualProduct);
    }

    @Test
    void testCalculateMultiplicationThrowsArithmeticException() {
        binaryCalculator.multiply(Long.toBinaryString(Long.MAX_VALUE));

        Assertions.assertThrows(ArithmeticException.class, () -> binaryCalculator.calculate("10"));
    }

    @Test
    void testCalculateDivision() {
        binaryCalculator.divide("1100");
        String actualQuotient = binaryCalculator.calculate("100").toString();
        String expectedQuotient = Long.toBinaryString(3);

        Assertions.assertEquals(expectedQuotient, actualQuotient);
    }
}
