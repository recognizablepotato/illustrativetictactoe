package project5;
import java.awt.*;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.plaf.FontUIResource;
/**
*COP 2551: Project 5- Tic Tac Toe Game
*
*This Program builds a Tic Tac Toe Board that can be is held by an array and updating the values through this class.
*This class first method makes printable board for the array and collects the input from the user on what move they would like to make.
*The printable board class also catches error handling when the play enters something that is larger or smaller than array would allow.
*Other errors it catches are if you want to put a character in a position already taken. 
*The second method in this class pick a random available spot for the computer by generating a random number for a position and evaluating if
*the space is available on the board. The random available goes till a spot can be found on the board. Finding the winning spot is the third method it 
*evaluates if their are any winning spot available for the computer on the board or if they can block a winning spot from the player.
*The fourth method determines if anyone won the game by evaluating the board and the given characters on the board also evaluates if their is a tie.
*
*Outputs-Printable Tic Tac Toe Board, and error handling, Return values to TicTacToeGame Class
*
*
*@author Brandi Lauria
*@version 04-09-17
*@parameter  char PlayersChoosenCharacter, char [][] board2, char ComputersChoosenCharacter,char charToCheck
*/
/*Algorithm
 * 
 * Tic Tac Toe Board Class
*1 Enact Method for Printable Board - to display the array and update values as desired by user input
*2Variable declared for Joption Pane for a input to give a return value when called
*3Print Joption pane to screen
*4 parse data input so can be evaluated in error handling
*5 error handling if players position chosen less than one or greater than 9 joption pane and if position already taken error message
*6 add return statement in error handling to return user to input so they can use another spot
*7Returns Players Chosen Position to be called
*
*8Pick Random Available Spot receives a character for Computers Chosen Character and the updated array
*9declare a variable for the random number generated
*10 evaluates if spot number is already taken if not pass a return value of spot to be evaluated and input in array
*11 do while statement so random number generate keeps working until an available spot is found
*
*12 finding winning spot method parameters char computers character and updated array
*13 if statement evaluating if the number 1 spot help win the game if not an else if statement to evaluate if the Player can be blocked
*14 if statement evaluating if the number 2 spot help win the game if not an else if statement to evaluate if the Player can be blocked
*15if statement evaluating if the number 3 spot help win the game if not an else if statement to evaluate if the Player can be blocked
*16if statement evaluating if the number 4 spot help win the game if not an else if statement to evaluate if the Player can be blocked
*17if statement evaluating if the number 5 spot help win the game if not an else if statement to evaluate if the Player can be blocked
*18if statement evaluating if the number 6 spot help win the game if not an else if statement to evaluate if the Player can be blocked
*19if statement evaluating if the number 7 spot help win the game if not an else if statement to evaluate if the Player can be blocked
*20if statement evaluating if the number 8 spot help win the game if not an else if statement to evaluate if the Player can be blocked
*21if statement evaluating if the number 9 spot help win the game if not an else if statement to evaluate if the Player can be blocked
*22 else return 0 no winning move can be chosen
*
*23 method determine the winner parameter an updated array
*24Evalutes the array for if X won by stating all the ways X could win and comparing to updated array values
*24Evalutes the array for if O won by stating all the ways O could win and comparing to updated array values
*24Evalutes if there is a tie by comparing array values to original values if all are not updated by user or computer and no wins it is a tie
*25return void value if there is no determined winner
*
*/
public class TicTacToeBoard {//begin class tic tac toe board
	
	public static String printableBoard(char PlayersChoosenCharacter, char [][] board2){//begin method for printable board parameter players Choosen Character and Array 
		//gives print out of board and allows user to input the position they would like on the board
		javax.swing.UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Consolas", Font.BOLD, 20)));
		javax.swing.UIManager.put("Panel.background",  new Color(177,211, 177));
		String PlayersChoosenPosition =
		JOptionPane.showInputDialog (null,"       Tic-Tac-Toe\n\n" + "        "+board2[0][0] + " | " + board2[0][1] + " | " + board2[0][2] + "\n" + 
				"        ---+---+---\n"+"        "+board2[1][0] + " | " + board2[1][1] + " | " + board2[1][2] + "\n" + "        ---+---+---\n"+
				"        " +board2[2][0] + " | " + board2[2][1] + " | " + board2[2][2] +"\n\n"+ "     It is your move!\n\n" +
				"    Enter the number of   \n" +  "    an available space  \n\n" + "        You are "+PlayersChoosenCharacter + "     ","Tic-Tac-Toe", JOptionPane.PLAIN_MESSAGE);
//parses data for easier manipulation into array
		int playerRow=  (((Integer.parseInt(PlayersChoosenPosition))-1)/3);
		int playerColumn=  (((Integer.parseInt(PlayersChoosenPosition))-1)%3);
		//declares if statement to error handling in position is not 1-9 or is already choosen
	if((Integer.parseInt(PlayersChoosenPosition)) <1 || (Integer.parseInt(PlayersChoosenPosition)) >9 ||
	board2[playerRow][playerColumn] == 'X'||board2[playerRow][playerColumn] == 'O'){
	JOptionPane.showMessageDialog( null,
	"Invalid space chosen -->" + PlayersChoosenPosition +"\n" +"Please pick and available space."	,
	"Error",JOptionPane.ERROR_MESSAGE);
	//returns to joption input if player input a bad data value
	return printableBoard(PlayersChoosenCharacter, board2);}
	//returns players Choosen Position to PlayersMove
		return PlayersChoosenPosition;
	}//end method printable board
	
	
	public static int pickRandomAvailableSpot(char ComputersChoosenCharacter, char[][] board){//begin method pickRandom Available Spot
		//Parameters are ComputersChoosen Character and updated array
		int spotnumber;
		//do does a random number pick until Value is character number i.e. choosing one that hasn't been already picked
		do{	
		Random generator = new Random();
		spotnumber = (generator.nextInt(9)+1);
		
		if(spotnumber == 1 && board[0][0] == '1')
			return 1;
		if(spotnumber == 2 && board[0][1] == '2')
			return 2;
		if(spotnumber == 3 && board[0][2] == '3')
			return 3;
		if(spotnumber == 4 && board[1][0] =='4')
			return 4;
		if(spotnumber == 5 && board[1][1] == '5')
			return 5;
		if(spotnumber == 6 && board[1][2] =='6')
			return 6;
		if(spotnumber == 7 && board[2][0] == '7')
			return 7;
		if(spotnumber == 8 && board[2][1] == '8')
			return 8;
		if(spotnumber == 9 && board[2][2] == '9')
			return 9;
		else
			spotnumber = 10;
		 }while(spotnumber == 10);
		return spotnumber;
	//return takes spotnumber for computer to ComputersMove
	}//end method for pickRandomAvaliable spot
public static int findWinningSpot(char charToCheck, char[][] board2){//begin method find Winning Spot
			//Parameters are charToCheck i.e. Computers Character and updated array
		if(board2[0][0] == '1' && board2[0][1]==charToCheck &&board2[0][2]==charToCheck||board2[0][0] == '1' && board2[1][0]==charToCheck&&board2[2][0]==charToCheck||board2[0][0] == '1' && board2[1][1] ==charToCheck&& board2[2][2]==charToCheck)
		{return 1;}//evaluates if Computer can find a winning spot for spot 1
		 else if(board2[0][0] == '1' && board2[0][1]==board2[0][2]||board2[0][0] == '1' && board2[1][0] ==board2[2][0]||board2[0][0] == '1' && board2[1][1] == board2[2][2])
		{return 1;}//evaluates if Computer can block player from winning for spot 1
		 if(board2[0][1] == '2'&& board2[0][0]== charToCheck && board2[0][2] ==charToCheck||board2[0][1] == '2'&& board2[1][1]==charToCheck &&board2[1][2]==charToCheck)
		 {return 2;}//evaluates if Computer can find a winning spot for spot 2
		 else if(board2[0][1] == '2'&& board2[0][0]== board2[0][2]||board2[0][1] == '2'&& board2[1][1]==board2[1][2])
		{return 2;}//evaluates if Computer can block player from winning for spot 2
		if (board2[0][2] == '3'&&board2[0][0]==charToCheck && board2[0][1]== charToCheck||board2[0][2] == '3'&& board2[1][1]==charToCheck &&board2[2][0] ==charToCheck|| board2[0][2] == '3'&&board2[1][2]==charToCheck&& board2[2][2]==charToCheck)
		{return 3;}//evaluates if Computer can find a winning spot for spot 3
			else if(board2[0][2] == '3'&&board2[0][0]==board2[0][1]||board2[0][2] == '3'&& board2[1][1]== board2[2][0] || board2[0][2] == '3'&&board2[1][2] == board2[2][2])
		{return 3;}//evaluates if Computer can block player from winning for spot 3
		if(board2[1][0] == '4'&&board2[1][1] == charToCheck && board2[1][2]==charToCheck||board2[1][0] == '4'&& board2[0][0]==charToCheck && board2[2][0]==charToCheck)
		{return 4;}//evaluates if Computer can find a winning spot for spot 4
		else if(board2[1][0] == '4'&&board2[1][1]==board2[1][2]||board2[1][0] == '4'&& board2[0][0] == board2[2][0])
		{return 4;}//evaluates if Computer can block player from winning for spot 4
		if(board2[1][1] == '5'&&board2[1][0]==charToCheck&& board2[1][2]==charToCheck||board2[1][1] == '5'&& board2[0][1]==charToCheck&&board2[2][1]==charToCheck)
		{return 5;}//evaluates if Computer can find a winning spot for spot 5
		else if(board2[1][1] == '5'&&board2[1][0]== board2[1][2]||board2[1][1] == '5'&& board2[0][1]==board2[2][1])
		{return 5;}//evaluates if Computer can block player from winning for spot 5
		if(board2[1][2] == '6'&&board2[1][0]==charToCheck&&board2[1][1]==charToCheck||board2[1][2] == '6'&& board2[0][2]==charToCheck&&  board2[2][2]==charToCheck)
		{return 6;}//evaluates if Computer can find a winning spot for spot 6
		else if(board2[1][2] == '6'&&board2[1][0]==board2[1][1]||board2[1][2] == '6'&& board2[0][2] == board2[2][2])
		{return 6;}//evaluates if Computer can block player from winning for spot 6
		if(board2[2][0] == '7'&&board2[1][0]== charToCheck&& board2[0][0]==charToCheck||board2[2][0] == '7'&& board2[0][2] ==charToCheck &&board2[1][1]==charToCheck||board2[2][0] == '7'&&board2[2][1] == charToCheck && board2[2][2]==charToCheck)
		{return 7;}//evaluates if Computer can find a  winning  spot 7
		else if(board2[2][0] == '7'&&board2[1][0]==  board2[0][0]||board2[2][0] == '7'&& board2[0][2] ==board2[1][1]||board2[2][0] == '7'&&board2[2][1] == board2[2][2])
		{return 7;}//evaluates if Computer can block player from winning for spot 7
		if(board2[2][1] == '8'&&board2[0][1]==charToCheck && board2[1][1]==charToCheck|| board2[2][1] == '8'&&board2[2][0]==charToCheck&&  board2[2][2]==charToCheck)
		{return 8;}//evaluates if Computer can find a  winning  spot 8
		else if(board2[2][1] == '8'&&board2[0][1]== board2[1][1]|| board2[2][1] == '8'&&board2[2][0] == board2[2][2])
		{return 8;}//evaluates if Computer can block player from winning for spot 8
		if(board2[2][2] =='9' && board2[0][2]==charToCheck &&board2[1][2] == charToCheck|| board2[2][2] == '9'&&board2[0][0] ==charToCheck &&board2[1][1]==charToCheck|| board2[2][2] == '9'&&board2[2][1]==charToCheck&&   board2[2][0]==charToCheck)
		{return 9;}//evaluates if Computer can find a  winning  spot 9
			else if(board2[2][2] == '9'&&board2[0][2]== board2[1][2]|| board2[2][2] == '9'&&board2[0][0] ==board2[1][1]|| board2[2][2] == '9'&&board2[2][1] ==  board2[2][0])
		{return 9;}//evaluates if Computer can block player from winning for spot 9
		else 
			return 0;//if none possible returns a 0 which evaluates in Computer Move and PickRandom Move
	}//End Method
public static char determineWinner(char[][] board2){//begin method for determine winner
	//parameter is updated array
if( board2[0][0] =='X' && board2[0][1]=='X'&&board2[0][2] =='X')
	return 'X';//if statement if X won return character
if(board2[1][0] =='X' && board2[1][1]=='X'&&board2[1][2]=='X')
	return 'X';//if statement if X won return character
if(board2[2][0] =='X' && board2[2][1]=='X' &&board2[2][2]=='X')
	return 'X';//if statement if X won return character
if(board2[0][0]=='X'&&board2[1][0]=='X'&&board2[2][0]=='X')
	return 'X';//if statement if X won return character
if(board2[0][1]=='X'&& board2[1][1]=='X'&&board2[2][1]=='X')
	return 'X';//if statement if X won return character
if(board2[0][2] =='X' && board2[1][2]=='X'&&board2[2][2]=='X')
{return 'X';}//if statement if X won return character
if(board2[0][0]=='X' && board2[1][1]=='X'&&board2[2][2]=='X')
{return 'X';}//if statement if X won return character
if(board2[0][2]=='X' &&board2[1][1]=='X'&&board2[2][0]=='X')
	{return 'X';}//if statement if X won return character
if( board2[0][0] =='O' && board2[0][1]=='O'&&board2[0][2] =='O')
	return 'O';//if statement if O won return character
if(board2[1][0] =='O' && board2[1][1]=='O'&&board2[1][2]=='O')
	return'O';//if statement if O won return character
if(board2[2][0] =='O' && board2[2][1]=='O' &&board2[2][2]=='O')
	return 'O';//if statement if O won return character
if(board2[0][0]=='O'&&board2[1][0]=='O'&&board2[2][0]=='O')
	return 'O';//if statement if O won return character
if(board2[0][1]=='O'&& board2[1][1]=='O'&&board2[2][1]=='O')
	return'O';//if statement if O won return character
if(board2[0][2] =='O' && board2[1][2]=='O'&&board2[2][2]=='O')
	return'O';//if statement if O won return character
if(board2[0][0]=='O' && board2[1][1]=='O'&&board2[2][2]=='O')
{return 'O';}//if statement if O won return character
if(board2[0][2]=='O' &&board2[1][1]=='O'&&board2[2][0]=='O')
	{return 'O';}//if statement if O won return character
if (board2[0][0]!='1' && board2[0][1]!='2'&& board2[0][2]!='3'
&& board2[1][0]!='4'&& board2[1][1]!='5'&& board2[1][2]!='6'&& 
board2[2][0]!='7'&& board2[2][1]!='8'&& board2[2][2]!='9')
{return 'T';}//if statement if Tie return character
else
{return 'N';}//else return value that holds no power HAHAHA
}//end method for determining winner

	
	


}
