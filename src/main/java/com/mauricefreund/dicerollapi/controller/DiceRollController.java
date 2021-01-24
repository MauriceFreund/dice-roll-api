package com.mauricefreund.dicerollapi.controller;

import com.mauricefreund.dicerollapi.services.DiceRollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DiceRollController {

    private final DiceRollService rollService;

    @Autowired
    public DiceRollController(DiceRollService rollService) {
        this.rollService = rollService;
    }

    @GetMapping("/rolldice")
    public double calculateResultForDiceRoll(@RequestParam(value="roll", defaultValue = "1d6") String rollDescription) {
        return this.rollService.generateResultForDiceRoll(rollDescription);
    }
}
