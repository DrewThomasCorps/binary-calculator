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
    void testSquareThrowsExceptionOnOverflow() {
        Assertions.assertThrows(ArithmeticException.class,
                () -> binaryCalculator.square(Long.toBinaryString(Long.MAX_VALUE / 2))
        );
    }

    @Test
    void testSquareHandlesNegatives() {
        Assertions.assertEquals(
                Long.toBinaryString(25),
                binaryCalculator.square("-" + Long.toBinaryString(5)).toString()
        );
    }

    @Test
    void testSquareRoot() {
        Assertions.assertEquals(
                Long.toBinaryString(6),
                binaryCalculator.squareRoot(Long.toBinaryString(36)).toString()
        );
    }

    @Test
    void testSquareRootCastsToInt() {
        Assertions.assertEquals(
                Long.toBinaryString(4),
                binaryCalculator.squareRoot(Long.toBinaryString(18)).toString()
        );
    }

    @Test
    void testSquareRootOfNegative() {
        Assertions.assertThrows(ArithmeticException.class, () -> binaryCalculator.squareRoot("-10"));
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
    void testCalculateAdditionWithNegatives() {
        binaryCalculator.add("-11");
        String actualSum = binaryCalculator.calculate("10").toString();
        String expectedSum = "-1";
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

    @Test
    void testToggleSignNegativeToPositive() {
        Assertions.assertEquals(
                "10",
                binaryCalculator.toggleSign("-10")
        );
    }

    @Test
    void testToggleSignPositiveToNegative() {
        Assertions.assertEquals(
                "-10",
                binaryCalculator.toggleSign("10")
        );
    }

    @Test
    void testToggleSignThrowsOverflowException() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            binaryCalculator.toggleSign(Long.toBinaryString(Long.MIN_VALUE));
        });
    }

    @Test
    void testConvertToBinary() {
        Assertions.assertEquals(
                "100",
                binaryCalculator.convertToBinary("4")
        );
    }

    @Test
    void testConvertToBinaryNegative() {
        Assertions.assertEquals(
                "-1100",
                binaryCalculator.convertToBinary("-12")
        );
    }

    @Test
    void testConvertToDecimal() {
        Assertions.assertEquals(
                "4",
                binaryCalculator.convertToDecimal("100")
        );
    }

    @Test
    void testConvertToDecimalNegative() {
        Assertions.assertEquals(
                "-12",
                binaryCalculator.convertToDecimal("-1100")
        );
    }
}
