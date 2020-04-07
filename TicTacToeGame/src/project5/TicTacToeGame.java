package project5;
import java.awt.*;

import javax.swing.JOptionPane;
import javax.swing.plaf.FontUIResource;
import java.awt.Dialog;
import java.util.Random;

import javax.swing.JOptionPane;


/**
*COP 2551: Project 5- Tic Tac Toe Game
*
 * This is the summary for the main of TicTacToe Game.  The main uses JOptionPane.ShowConfirmdialog with a yes no option is used
 *  to ask the player(user) to select an X or O. The show confirm dialog also communicates to the user the game name, my name, and the 
 *  project and the class id number. Once the user has selected an X or O, a randomizer is run to determine who goes first, the player
 *  or the computer.  If the user goes first, a counter in a do while loop is used to count the number of times data has been selected
 *  by either the computer or player. If the player is randomly chosen to go first a method is called, requesting (a space to be selected
 *  from the array)and evaluating (ensuring the selection is valid) the user's input. Another method is called in order to evaluate
 *  if the the selection created a win for the player. If the selection didn't create a winner the array is evaluated for a draw.  If 
 *  neither a win or draw occurred.  Where the computer goes first or goes second, a method is called for the computer's selection this
 *  method evaluates where the computer will select by looking to win , block the user, or randomly select a location in the array.  A
*  method is used to evaluate whether the computer won or tied, if neither. The program uses JPaneOption to show the computer's 
*  selection and request next player selection.
* 
*
*Input- PlayerCharacter
*Output- Winning Joption Pane, Tie Joption Pane
*@author Brandi Lauria
*@version 04-09-17
*
*/




/*Algorithm
 * 
 * Tic Tac Toe Game Class
*
*1Main declares array of characters 
*2 Sets the button to JPane Option to X or O
*3Prints to screen a intro to Player asking them what Player Character they would like in JPane Option
*4 if statement if player choose X computer is O if player choose O Player is X 
*5 Random generator to say who goes first pulls playermove method if they go first or computers method if computer goes first
*6 do while statement to evaluate second move and how the game will go back and forth in players moves calling players move and computers move 
*
*7helper method Players move takes the array from main and Players Character choice
*8 gets input from printable board by calling it
*9 parses the info given by printable board
*10 evaluates players position and determines by calculation where it should go in the array
*11 declare new array and declares new to tic tac board
*12 calls determine winner method from tic tac board to evaluate return value if char of Player was returned they won 
*13 JPane Option in if statement if character of Player won print-exit system
*14 Jpane Option in if statement if character of T - representing Tie returned print tie-exit system
*
*15Computers move helper method gets computers chosen character and updated array 
*16 declares value of find winning spot and calls method from tic tac toe board
*17 declares value of Pick  Random and calls method from tic tac toe board
*18if statement for if finding winning spot value or Pick random value will update the array
*19 Parse's the position and inputs computers spot in array
*20 determine winner value is assigned and method called if computer character has won prints Jpane option computer won-exit system
*21 if value returned from determine value is T than Tie Joption pane is prompted to print-exit system
*
*/
public class TicTacToeGame {//beginning class
	public static void main(String[] args){//main begins
		//declare character Array and initialize
		char[][] board2= {{'1','2','3'},{'4','5', '6'}, {'7','8','9'}};
		//Renaming of Joption Pane Buttons for Selection of X or O
	javax.swing.UIManager.put("OptionPane.yesButtonText", "X");
		 javax.swing.UIManager.put("OptionPane.noButtonText", "O");	
		 
			//Prints to Screen an intro and retrieves Players Choosen Character
int PlayersChoosenCharacterReturn=JOptionPane.showConfirmDialog (null, "COP 2251 Project 5 - Brandi Lauria\n\n" + 
			"Let's Play a game of Tic-Tac-Toe\n\n" + " Would you like to X or O? ","Tic-Tac-Toe",
			JOptionPane.YES_NO_OPTION,  JOptionPane.PLAIN_MESSAGE);
//set players and computers choosen characters initialized
char PlayersChoosenCharacter = 0;
char ComputersChoosenCharacter = 0;
//specifys the players choosen character from the return on the Joption buttons
if(PlayersChoosenCharacterReturn== 0)
{	PlayersChoosenCharacter ='X';
	ComputersChoosenCharacter ='O';}
if(PlayersChoosenCharacterReturn==1)
	{PlayersChoosenCharacter ='O';
ComputersChoosenCharacter='X';}
//define max for random player selection
			int max = 2;
			// define min for random player selection
			int min = 1;						
			// use java rand to select a number between 0 and 1 at random
			Random rand = new Random ();
			// set random value as who is first
			int whoIsFirst = rand.nextInt((max - min)+1);

//if random value is 0 player goes first calls method first and if random value 1 computer goes first calls method first
			if( whoIsFirst == 0)
			{PlayersMove(PlayersChoosenCharacter, board2);}
			if (whoIsFirst == 1){ComputersMove(ComputersChoosenCharacter, board2);}
//count for do while statement initializer
		int count=0;
		//do statement inacted and count determines the rest of the moves 
		//by interpreting who did the first move with an if statement
			do{count=count +1;
			if(whoIsFirst== 0)
				{ComputersMove(ComputersChoosenCharacter, board2);
			PlayersMove(PlayersChoosenCharacter, board2);}
			if(whoIsFirst ==1)
			{	PlayersMove(PlayersChoosenCharacter, board2);
			ComputersMove(ComputersChoosenCharacter, board2);}
			}while(count<14);
}//main end
	
	private static void PlayersMove(char PlayersChoosenCharacter, char[][] board2){//begin method for player moves gets playersChoosenCharacter, and array
		//pulls return and calls method from Printable board class tictactoe board
		String PlayersChoosenPosition = (TicTacToeBoard.printableBoard(PlayersChoosenCharacter, board2));
		//parse returned PlayersChoosenPosition to integer
		Integer.parseInt (PlayersChoosenPosition);
		//find row and column of players choosen position
		int playerRow=  (((Integer.parseInt(PlayersChoosenPosition))-1)/3);
		int playerColumn=  (((Integer.parseInt(PlayersChoosenPosition))-1)%3);
		//add players position to array with their choosen character
		board2 [playerRow][playerColumn]= PlayersChoosenCharacter;
		//declares new object in array
		char[][] board = new char[2][2];
		//declares new tic tac toe board
		TicTacToeBoard game  = new TicTacToeBoard();
		//calls return for determining winner from method in tictactoe class
		char winner = TicTacToeBoard.determineWinner(board2);
		//if winner prints a screen of player won if tie prints screen telling them it was a tie
		if(winner == PlayersChoosenCharacter)
		{JOptionPane.showMessageDialog(null,"       Player Wins!    \n\n" + "        "+board2[0][0] + " | " + board2[0][1] + " | " + board2[0][2] + "\n" + 
			"        ---+---+---\n"+"        "+board2[1][0] + " | " + board2[1][1] + " | " + board2[1][2] + "\n" + "        ---+---+---\n"+
			"        " +board2[2][0] + " | " + board2[2][1] + " | " + board2[2][2] +"\n\n",
			"You win!",JOptionPane.PLAIN_MESSAGE);
		System.exit (0);}
		if(winner=='T'){JOptionPane.showMessageDialog 
			(null,"     Cats Game! \n\n" + "        "+board2[0][0] + " | " + board2[0][1] + " | " + board2[0][2] + "\n" + 
					"        ---+---+---\n"+"        "+board2[1][0] + " | " + board2[1][1] + " | " + board2[1][2] + "\n" + "        ---+---+---\n"+
					"        " +board2[2][0] + " | " + board2[2][1] + " | " + board2[2][2] +"\n\n",
					"Tie!",
					JOptionPane.PLAIN_MESSAGE);;
					System.exit (0);
					}	
	}//end PlayerMove
	
	private static void ComputersMove(char ComputersChoosenCharacter,char[][] board2){//declares method for Computers Move 
		//takes both methods from tictac toe board find Winning Spot and Pick Random Available Spot and declare return type
		//to be evaluated
		int findWinSpot = TicTacToeBoard.findWinningSpot(ComputersChoosenCharacter, board2);
		int PickRand = TicTacToeBoard.pickRandomAvailableSpot( ComputersChoosenCharacter, board2);
		//if statement for choosing the WinningSpot or Random Available Spot and inputs from declared if in array
		if(findWinSpot!= 0)
		{int computerRow=  (((findWinSpot)-1)/3);
		int computerColumn=  (((findWinSpot)-1)%3);
		
		board2 [computerRow][computerColumn]=ComputersChoosenCharacter;
		}//end if for find win spot
		if(findWinSpot ==0){
	
		int computerRow=  (((PickRand)-1)/3);
		int computerColumn=  (((PickRand)-1)%3);
		board2 [computerRow][computerColumn]=ComputersChoosenCharacter;
		}//end if for find win spot if return 0 do pick random
		//declares new board
		char[][] board = new char[2][2];
		//calls new Tic Tac Toe Board
		TicTacToeBoard game  = new TicTacToeBoard();
		//Call to determine if from input the Computer has Won or that there was a Tie by taking return value of method Determine Winner
		char winner = TicTacToeBoard.determineWinner(board2);
		if(winner == ComputersChoosenCharacter)
		{JOptionPane.showMessageDialog 
		(null,"       The computer wins!    \n\n" + "        "+board2[0][0] + " | " + board2[0][1] + " | " + board2[0][2] + "\n" + 
		"        ---+---+---\n"+"        "+board2[1][0] + " | " + board2[1][1] + " | " + board2[1][2] + "\n" + "        ---+---+---\n"+
		"        " +board2[2][0] + " | " + board2[2][1] + " | " + board2[2][2] +"\n\n",
		"Computer wins!",
		JOptionPane.PLAIN_MESSAGE);
		System.exit (0);}//end message for if winner print
		if(winner=='T'){JOptionPane.showMessageDialog 
			(null,"     Cats Game! \n\n" + "        "+board2[0][0] + " | " + board2[0][1] + " | " + board2[0][2] + "\n" + 
					"        ---+---+---\n"+"        "+board2[1][0] + " | " + board2[1][1] + " | " + board2[1][2] + "\n" + "        ---+---+---\n"+
					"        " +board2[2][0] + " | " + board2[2][1] + " | " + board2[2][2] +"\n\n",
					"Tie!",
					JOptionPane.PLAIN_MESSAGE);;
					System.exit (0);
					}//end message for if tie print
	}//end computers turn method
}//end class
