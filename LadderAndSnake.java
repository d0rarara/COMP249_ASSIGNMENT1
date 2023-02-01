// Dorcas Kumbu Buthidi 40224424
// COMP249
// Assignment 1
// Part 1
// Due Date: February 3, 2023 

/**/

public class LadderAndSnake {

	private int[][] board;
	private int numPlayers = 2;
	private int[] players; 
	
	public LadderAndSnake(int numPlayers) {
		this.numPlayers = numPlayers;
		this.board = new int[10][10];
		this.players = new int[numPlayers];
		
		if(numPlayers > 2) {
			System.out.println("Error: player limit is set to 2");
			this.numPlayers = 2;
		}else if(numPlayers == 2) {
			System.out.println("Ready to play!");
		} else {
			System.exit(1);
		}
	}
	 public int flipDice() {
		 return (int)(Math.random()*6+1);
	 }
	public int play() {
		// Determine the order of players
		int roll1 = this.flipDice(); // 1
		int roll2 = this.flipDice(); // 1
		
		System.out.println("Now deciding which player will start playing: ");
		System.out.println("Player 1 got a dice value of: " + roll1);
		System.out.println("Player 2 got a dice value of: " + roll2);
		
		int attempt = 1;
		
		while(roll1==roll2) {
			System.out.println("A tie was achieved between Player 1 and Player 2. Attempting to break the tie");
			roll1 = this.flipDice();
			roll2 = this.flipDice();
			System.out.println("Player 1 got a dice value of: " + roll1);
			System.out.println("Player 2 got a dice value of: " + roll2);
			attempt++;
		}
		
		int[] order = new int[2];
		
		// Set the order based on player rolls
		if(roll1 > roll2) {
			order[0] = 1;
			order[1] = 2;
		} else {
			order[0] = 2;
			order[1] = 1;
		}
		
		System.out.println("Player " + order[0] + " then Player " + order[1] + ". It took " + attempt + " attempt(s)");
		
		// Alternate rolling the dice for each player
		return 0;
	}
}
