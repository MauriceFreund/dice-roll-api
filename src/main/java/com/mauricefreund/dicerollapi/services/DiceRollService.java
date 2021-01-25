package com.mauricefreund.dicerollapi.services;

import com.mauricefreund.dicerollapi.rng.IRandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;


@Service
public class DiceRollService {

    IRandomNumberGenerator rng;

    @Autowired
    public DiceRollService(IRandomNumberGenerator randomNumberGenerator) {
        this.rng = randomNumberGenerator;
    }

    private double generateResultForDiceRollSegment(String rollDescriptionSegment) {
        if (!rollDescriptionSegment.contains("d")) {
            return Double.parseDouble(rollDescriptionSegment);
        }
        double quantity = Double.parseDouble(rollDescriptionSegment.split("d")[0]);
        double numSides = Double.parseDouble(rollDescriptionSegment.split("d")[1]);
        return Arrays.stream(new double[(int)quantity])
                .map(x -> this.rng.getRandomNumber(0.0001, numSides))
                .map(Math::ceil)
                .sum();
    }

    public double generateResultForDiceRoll(String rollDescription) {
        List<String> segments = Arrays.asList(rollDescription.split("\\+"));
        return segments.stream()
                .map(this::generateResultForDiceRollSegment)
                .reduce(0.d, Double::sum);
    }
}
