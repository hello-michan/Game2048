Name
this is 2048.

Description
4*4 grid board which initally has two random number, 2 or 4, the rest of the cells are empty.
when you run this code, the game starts.
you have to press any one of the following four keys to move: up, down, left, right.
when pressing any keys, numbers in the cells move in that direction or merge if they have same number and then the sum of the two numbers shows up.
To end this game, either the player makes 2048 by merging in any of the cell or there is no empty cell and no valid moves.
Press x to exit :)

Visuals
GUI is made with java swing.
The code consists of 3 files: Game2048Contoller.java, Borad.java, GameLogic.java
Game2048Contoller: this is the runner and its only job is to call play() in Board.java.
Board is a gamelogic host. This class extends JFrame to display the game and implements keylistner to interact with the player.
KeyPressed method in this class has switch case that call GameLogic. Based on the pressed key, the different method in Gamelogic are called.
GameLogic is a logic that numbers in cells merge and move.

DEMO

https://github.com/user-attachments/assets/593fdf10-3e07-4260-a0c5-1f09609e8452

