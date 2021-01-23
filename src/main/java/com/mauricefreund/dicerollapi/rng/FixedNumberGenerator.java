package com.mauricefreund.dicerollapi.rng;

import java.util.List;

public class FixedNumberGenerator implements IRandomNumberGenerator {
    private final double fixedValue;

    public FixedNumberGenerator(double fixedValue) {
        if (fixedValue < 0 || fixedValue > 1) {
            throw new IllegalArgumentException("Error in constructor of FixedNumberGenerator: " +
                    "fixedValue must be between 0 and 1 to ensure compatibility with IRandomNumberGenerator." +
                    String.format("The value passed was %f", fixedValue));
        }
        this.fixedValue = fixedValue;
    }

    @Override
    public double getRandomNumber(double lowerBound, double upperBound) {
        return lowerBound + fixedValue  * (upperBound - lowerBound);
    }
}
