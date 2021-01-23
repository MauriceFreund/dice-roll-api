package com.mauricefreund.dicerollapi.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.mauricefreund.dicerollapi.rng.FixedNumberGenerator;
import org.junit.jupiter.api.Test;

public class TestDiceRollService {

    @Test
    public void rollDice_returnsCorrectResult_forConstant() {
        DiceRollService service = new DiceRollService(new FixedNumberGenerator(0));
        assertEquals(4, service.generateResultForDiceRoll("4"));
    }

    @Test
    public void rollDice_returnsCorrectLowerBound_forASingleD6() {
        DiceRollService service = new DiceRollService(new FixedNumberGenerator(0));
        assertEquals(1, service.generateResultForDiceRoll("1d6"));
    }

    @Test
    public void rollDice_returnsCorrectUpperBound_forASingleD6() {
        DiceRollService service = new DiceRollService(new FixedNumberGenerator(1));
        assertEquals(6, service.generateResultForDiceRoll("1d6"));
    }

    @Test
    public void rollDice_returnsCorrectMiddleValue_forASingleD6() {
        DiceRollService service = new DiceRollService(new FixedNumberGenerator(0.5));
        assertEquals(4, service.generateResultForDiceRoll("1d6"));
    }

    @Test
    public void rollDice_returnsCorrectLowerBound_forTwoD6() {
        DiceRollService service = new DiceRollService(new FixedNumberGenerator(0));
        assertEquals(2, service.generateResultForDiceRoll("2d6"));
    }

    @Test
    public void rollDice_returnsCorrectCorrectUpperBound_forTwoD6() {
        DiceRollService service = new DiceRollService(new FixedNumberGenerator(1));
        assertEquals(12, service.generateResultForDiceRoll("2d6"));
    }

    @Test
    public void rollDice_returnsCorrectMiddleValue_forTwoD6() {
        DiceRollService service = new DiceRollService(new FixedNumberGenerator(0.5));
        assertEquals(8, service.generateResultForDiceRoll("2d6"));
    }

    @Test
    public void rollDice_returnsCorrectLowerBound_forOneDiceAndAConstant() {
        DiceRollService service = new DiceRollService(new FixedNumberGenerator(0));
        assertEquals(5, service.generateResultForDiceRoll("1d6+4"));
    }

    @Test
    public void rollDice_returnsCorrectUpperBound_forOneDiceAndAConstant() {
        DiceRollService service = new DiceRollService(new FixedNumberGenerator(1));
        assertEquals(10, service.generateResultForDiceRoll("1d6+4"));
    }

    @Test
    public void rollDice_returnsCorrectUpperBound_forTwoDifferentDiceAndTwoConstants() {
        DiceRollService service = new DiceRollService(new FixedNumberGenerator(1));
        assertEquals(45, service.generateResultForDiceRoll("1d6+5+3d10+4"));
    }



}
