// Dorcas Kumbu Buthidi 40224424
// COMP249
// Assignment 1
// Part 1
// Due Date: February 3, 2023 

import java.util.Scanner;
public class PlayLadderAndSnake {
	/**
	 * This is a program to play Ladder and Snake game
	 * @param args 
	 */

  public static void main(String[] args) {
	  /**
	   * This is the main method of the program
	   */
	  
	Scanner input = new Scanner(System.in);
	System.out.println("Hello! Welcome to Dory's Ladder & Snake game. ");
	System.out.println("How many players will be playing?");
	int players = input.nextInt();
	input.close();
	
    LadderAndSnake game = new LadderAndSnake(players);
    game.play();

  }

}
