package CIS35A;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

/*
   public static void main(String[] args) {
*/

      /*TicTacToe mygame = new TicTacToe();
      mygame.print();
      mygame.play("A1");
      mygame.print();
      mygame.switchTurn();
      mygame.play("B1");
      mygame.print();
      if (mygame.stalemate()){
         System.out.println("Stalemate");
      }*/


	private char[][] board;
	private char player; // 'X' or 'O'

	/*
        * Instantiate board to be a 3 by 3 char array of spaces.
        * Set player to be 'X'.
        */
	public TicTacToe() {
		board = new char[3][3];
		player = 'X';
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = ' ';
			}
		}

      /*
      * Step 1: create an empty board, with an initial value
      * of a space (' ')
      */
	}

	/*
        * If s represents a valid move, add the current player's symbol to the board and return true.
        * Otherwise return false.
        */
	public boolean play(String s) {
		switch (s) {
			case "A1":
				if (board[0][0] == ' ') {
					board[0][0] = player;
					return true;
				} else {
					return false;
				}
			case "A2":
				if (board[0][1] == ' ') {
					board[0][1] = player;
					return true;
				} else {
					return false;
				}
			case "A3":
				if (board[0][2] == ' ') {
					board[0][2] = player;
					return true;
				} else {
					return false;
				}
			case "B1":
				if (board[1][0] == ' ') {
					board[1][0] = player;
					return true;
				} else {
					return false;
				}
			case "B2":
				if (board[1][1] == ' ') {
					board[1][1] = player;
					return true;
				} else {

					return false;
				}
			case "B3":
				if (board[1][2] == ' ') {
					board[1][2] = player;
					return true;
				} else {
					return false;
				}

			case "C1":
				if (board[2][0] == ' ') {
					board[2][0] = player;
					return true;
				} else {
					return false;
				}
			case "C2":
				if (board[2][1] == ' ') {
					board[2][1] = player;
					return true;
				} else {
					return false;
				}
			case "C3":
				if (board[2][2] == ' ') {
					board[2][2] = player;
					return true;
				} else {
					return false;
				}
			default: return false;

		}
	}




	/*
        * Switches the current player from X to O, or O to X.
        */
	public void switchTurn() {
		// Step 3: Fill in with your code to toggle between
		// 'X' and 'O'
		if (this.player=='X'){
			this.player='O';
		}
		else{
			this.player='X';
		}
	}

	/*
        * Returns true if the current player has won the game.
        * Three in a row, column or either diagonal.
        * Otherwise, return false.
        */
	public boolean won() {
      /* Step 5: Fill in the code for the won method. This method
        * should return true if the current player has 3 in-a-row
      * in any row, column or diagonal. Otherwise, return false.
      */

		for (int i =0; i < 3; i++){
			if ((board[i][0]==board[i][1]) && (board[i][1]==board[i][2])){
				return true;
			}
		}
		for (int i =0; i < 3; i++){
			if ((board[0][i]==board[1][i]) && (board[1][i]==board[2][i])){
				return true;
			}
		}
		if ((board[0][0]==board[1][1])&&(board[1][1]==board[2][2])){
			return true;
		}
		else if ((board[0][2]==board[1][1])&&(board[1][1]==board[2][0])){
			return true;
		}
		return false; // TODO: replace with your own return statement.
	}

	/*
        * Returns true if there are no places left to move
        */
	public boolean stalemate() {
       /*
       * Step 4: Fill in the code for the stalemate method. It
         * should return true if there are no more places to move
       * on the board. Otherwise, return false return false;
       */
		for (int i=0; i<3; i++){
			for (int j=0; j<3; j++){
				if (board[i][j]==' '){
					return false;
				}
			}
		}
		return true;   // replace with your own return
	}
	public char getPlayer() {
		return player;
	}

	public void print() {
		System.out.println();
		System.out.println("\t  1 2 3");
		System.out.println();
		System.out.println("\tA "+board[0][0]+"|"+board[0][1]+"|"+board[0][2]);
		System.out.println("\t  -----");
		System.out.println("\tB "+board[1][0]+"|"+board[1][1]+"|"+board[1][2]);
		System.out.println("\t  "+"-----");
		System.out.println("\tC "+board[2][0]+"|"+board[2][1]+"|"+board[2][2]);
		System.out.println();
	}

   /*
    * Step 6: Main Method for Final Step - Delete your main method
    * and uncomment this one.
    * Runs the game by getting input from the user, making the
    * appropriate moves, and prints who won or if it was a stalemate.
   */

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		TicTacToe mygame = new TicTacToe();
		System.out.println("Welcome to tic-tac-toe");
		System.out.println("Enter coordinates for your move following the X and O prompts");
		String input;

		while(!mygame.stalemate()) {
			//Print the game
			mygame.print();

			//Prompt player for their move
			do {
				System.out.println("Enter your move");
				input = in.nextLine();

				//mygame.play(input);
				//Loop while the method play does not return true when given their move.
				//Body of loop should ask for a different move
				if (mygame.play(input) == false) {
					System.out.println("Enter different move");
					input = in.nextLine();
					mygame.play(input);

				}else{
					mygame.play(input);
				}


				//If the game is won, call break;
				if (mygame.won()) {
					break;
				}

				//Switch the turn
				mygame.switchTurn();

			} while (mygame.play(input));
			if (mygame.won()) {
				break;
			}
		}
		mygame.print();
		if(mygame.won()){
			System.out.println("Player "+mygame.getPlayer()+" Wins!!!!");
		} else {
			System.out.println("Stalemate");
		}
	}

}