# Exercise 16: Ski Jumping

> Once again, you can train to build the program structure yourself; the appearance of the user interface and its functionality are pre-defined.   

> Note: you can create only one Scanner object lest the tests fail. Also, no not use static variables: the tests execute your program many different times, and the static variable values left from the previous execution would possibly disturb them!   
 
> Ski jumping is a beloved sport for Finns; they attempt to land as far as possible down the hill below, in the most stylish way. In this exercise, you create a simulator for a ski jumping tournament.   

> First, the simulator asks the user for the jumper names. If the user inputs an empty string (i.e. presses enter), we move to the jumping phase. In the jumping phase, the jumpers jump one by one in reverse order according to their points. The jumper with the less points always jumps first, then the ones with more points, till the person with the most points.   

> The total points of a jumper are calculated by adding up the points from their jumps. Jump points are decided in relation to the jump length (use a random integer between 60-120) and judge decision. Five judges vote for each jump (a vote is a random number between 10-20). The judge decision takes into consideration only three judge votes: the smallest and the greatest votes are not taken into account. For instance, if Mikael jumps 61 meters and the judge votes are 11, 12, 13, 14, and 15, the total points for the jump are 100.   

> There are as many rounds as the user wants. When the user wants to quit, we print the tournament results. The tournament results include the jumpers, the jumper total points, and the lengths of the jumps. The final results are sorted against the jumper total points, and the jumper who received the most points is the first.   

> Among the other things, you will need the method Collections.sort and Collections.reverse. First, you should start to wonder what kind of classes and objects there could be in your program. Also, it would be good to arrive to a situation where your user interface is the only class with printing statements.
```
Kumpula ski jumping week

Write the names of the participants one at a time; an empty string brings you to the jumping phase.
  Participant name: Mikael
  Participant name: Mika
  Participant name:

The tournament begins!

Write "jump" to jump; otherwise you quit: jump

Round 1

Jumping order:
  1. Mikael (0 points)
  2. Mika (0 points)

Results of round 1
  Mikael
    length: 95
    judge votes: [15, 11, 10, 14, 14]
  Mika
    length: 112
    judge votes: [14, 12, 18, 18, 17]

Write "jump" to jump; otherwise you quit: jump

Round 2

Jumping order:
  1. Mikael (134 points)
  2. Mika (161 points)

Results of round 2
  Mikael
    length: 96
    judge votes: [20, 19, 15, 13, 18]
  Mika
    length: 61
    judge votes: [12, 11, 15, 17, 11]

Write "jump" to jump; otherwise you quit: jump

Round 3

Jumping order:
  1. Mika (260 points)
  2. Mikael (282 points)

Results of round 3
  Mika
    length: 88
    judge votes: [11, 19, 13, 10, 15]
  Mikael
    length: 63
    judge votes: [12, 19, 19, 12, 12]

Write "jump" to jump; otherwise you quit: quit

Thanks!

Tournament results:
Position    Name
1           Mikael (388 points)
            jump lengths: 95 m, 96 m, 63 m
2           Mika (387 points)
            jump lengths: 112 m, 61 m, 88 m
```          
> Note1: it is essential that the user interface works exactly as displayed above; for instance, the number of spaces at the beginning of the lines must be right. The space at the beginning of the lines must be made of spaces, the tests do not work if you use tabulatation. Also, it is good that you copy the text which has to be printed by your program and you paste it into your code; you can copy it either from the exercise layout or from the test error messages. The exercise is worth of four separate exercise points.      

> The program has to start when we execute the main method in the example layout. Also, remember again that you can create only one Scanner object in your exercise.      

1. ask for jumper names, empty string = move to jumping phase
2. jumping phase = jumpers jump one by one in reverse order according to their points
  - 2.5. least points always jumps first, most points jumps last
3. random generator (60-120) for jump lengths.
4. Judge decisions = 5 judges vote (random 10-20), three middle jumps are added to points
5. Tournament results
