# Dice Roll API

This is a small web service supplying an API to determine the results of dice rolls. 

Rolling several dice can be useful for dice based games and tabletop RPGs.

The API accepts requests for dice rolls with an arbitrary positive number of sides. Also allowed is
the simultaneous roll of several dice with the same number of sides as well as the combination of different dice
and the addition of constant values.

A roll is specified as a string of characters. Dice are described by the number of dice to roll as well as the number
of sides of the dice. For example '2d6' would describe the roll of two six-sided dice. The combination of
different dice and constants is expressed by a '+' in between the descriptions of the different dice. As an example, 
'1d6+2d4+10' would be the roll of one six-sided dice, two four-sided dice and the addition of 10 to the roll result.
