package com.mauricefreund.dicerollapi.rng;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomNumberGenerator implements IRandomNumberGenerator {

    @Override
    public double getRandomNumber(double lowerBound, double upperBound) {
        if (lowerBound > upperBound) {
            throw new IllegalArgumentException(
                    "Wrong arguments for RandomNumberGenerator.getRandomNumber: " +
                    String.format("lowerBound (was %f) must be lower than upperBound (was %f).",
                            lowerBound, upperBound));
        }
        Random rng = new Random();
        double factor = rng.nextDouble();
        return lowerBound + factor  * (upperBound - lowerBound);
    }
}
