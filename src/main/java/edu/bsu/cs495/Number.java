package edu.bsu.cs495;

import java.math.BigInteger;

public class Number {
    private final Long value;

    public Number (String binary){
        value = new BigInteger(binary, 2).longValue();
    }

    public Number (long decimal) {
        value = decimal;
    }

    public Long getValue() {
        return value;
    }

    public String toDecimalString() {
        return String.valueOf(value);
    }

    public String toBinaryString() {
        if (value < 0) {
            return "-" + Long.toBinaryString(Math.abs(value));
        } else {
            return Long.toBinaryString(value);
        }
    }
}
