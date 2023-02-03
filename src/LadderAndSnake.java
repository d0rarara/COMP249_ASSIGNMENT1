// Dorcas Kumbu Buthidi 40224424
// COMP249
// Assignment 1
// Part 1
// Due Date: February 3, 2023 

/**
 * 
 * @author Dory
 *
 */

public class LadderAndSnake {
	
	/**
	 * This is the Ladder and Snake game
	 */

	private int numPlayers;
	
	/**
	 * 
	 * @param numPlayers the number of players
	 */
	
	public LadderAndSnake(int numPlayers) {
		
		this.numPlayers = numPlayers;
		
		
		if(numPlayers > 2) {
			System.out.println("Initialization was attempted for " + numPlayers + " number of players; however this is only expected for an extended version of the game.");
			System.out.println("Value will be set to 2.");
			this.numPlayers = 2;
		}else if(this.numPlayers == 2) {
			System.out.println("Ready to play!");
		} else {
			System.out.println("Error: Cannot execute game with less than 2 players! Goodbye.");
			System.exit(0);
		}
	}
	
	/**
	 * 
	 * @return random integer between 1 and 6
	 */
	
	 public int flipDice() {
	
		 return (int)(Math.random()*6+1);
	 }
	 
	 /**
	  * This method is the main runner for the game. 
	  * Calling this method runs through full game until completed.
	  * 
	  * @return 0 when completed
	  */
	 
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
		int[] square = {0,0};
		
		while(true) { // one iteration is one full turn (both players)
			
			for (int playerNum = 0; playerNum < 2; playerNum++) {
				
				//Roll dice
				
				roll1 = this.flipDice();
				
				//Change positions 
				
				square[playerNum] += roll1;
				
				if(square[playerNum] > 100) {
					square[playerNum] = (100 - (square[playerNum]-100));
					System.out.println("Cannot exceed 100. Move back to cell: " + square[playerNum]);
				}
				
				//Check for ladder and snake positions 
					
				int[][] ladders = {
					{1, 38}, 
					{4, 14}, 
					{9, 31},
					{21, 42},
					{28, 84},
					{36, 44},
					{51, 67},
					{71, 91},
					{80, 100}
				};
				
			int[][] snakes = {
					{16, 6}, 
					{48, 30}, 
					{62, 19},
					{64, 60},
					{93, 68},
					{95, 24},
					{97, 68},
					{98, 78},
				};
				
					
				//Move to ladder positions 
			
				for(int i = 0; i < ladders.length; i++) {
					if(square[playerNum] == ladders[i][0]) {
						square[playerNum] = ladders[i][1];             
					}
				}
				
				//Move to snake positions 
				
				for(int i = 0; i < snakes.length; i++) {
					if(square[playerNum] == snakes[i][0]) {
						square[playerNum] = snakes[i][1];             
					}
				}
				
				//Check if players are in the same position
				
				if (square[playerNum] == square[(playerNum + 1) % 2]) {
					square[playerNum] = 0;
					System.out.println("Boohoo! Back to cell 0 Player " + order[playerNum] + " :-( " );
				}
				
				System.out.println("Player " + order[playerNum] + " got a dice value of: " + roll1 + "; now in square " + (square[playerNum]));
			}
			
			//Check if game is over
			
			
			if(square[0] == 100) {
				System.out.println("Game over. Player " + order[0] + " wins!");
				break;
			} else if(square[1] == 100) {
				System.out.println("Game over. Player " + order[1] + " wins!");
				break;
			} else {
				//Print "Game not over"
				System.out.println("Game not over; flipping again");
			}
		} 
		
		
		return 0;
	}
}
