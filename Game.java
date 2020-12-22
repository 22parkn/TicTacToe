import java.util.Scanner;

public class Game {
  //creating players, board, and ending variables
  public char[] board = new char[9];
  User player1 = new User();
  User player2 = new User();
  boolean win;
  boolean tie;
  // you don't need to initialize it here, since you assign it to
  // player1 in the constructor
  User currentPlayer;
  public Game() {
    //assigning symbols and creating board
    player1.symbol = 'X';
    player2.symbol = 'O';
    currentPlayer = player1;
    for (int i = 0; i < 9; i++) {
      board[i] = ' ';
    }
    printBoard();
    putMarker();
  }

  public void printBoard() {
    System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
    System.out.println("----------");
    System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
    System.out.println("----------");
    System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
  }

  public void checkWinner() { 
    //the board[] doesn't check the symbol when it works. When it doesn't work, I do not know whywin = false; 
    win = false;
    tie = false;
    //checks if there is a winner. looks in rows, columns and diagonals
    while (win = false && tie != true) {
      if ((board[0] == currentPlayer.symbol) && (board[1] == currentPlayer.symbol) && (board[2] == currentPlayer.symbol)) {
        win = true;
      }
      else if ((board[0] == currentPlayer.symbol) && (board[1] == currentPlayer.symbol) && (board[2] == currentPlayer.symbol)) {
        win = true;
      }
      else if ((board[3] == currentPlayer.symbol) && (board[4] == currentPlayer.symbol) && (board[5] == currentPlayer.symbol)) {
        win = true;
      }
      else if ((board[3] == currentPlayer.symbol) && (board[4] == currentPlayer.symbol) && (board[5] == currentPlayer.symbol)) {
        win = true;
      }
      else if ((board[6] == currentPlayer.symbol) && (board[7] == currentPlayer.symbol) && (board[8] == currentPlayer.symbol)) {
        win = true;
      }
      else if ((board[6] == currentPlayer.symbol) && (board[7] == currentPlayer.symbol) && (board[8] == currentPlayer.symbol)) {
        win = true;
      }
      else if ((board[0] == currentPlayer.symbol) && (board[3] == currentPlayer.symbol) && (board[6] == currentPlayer.symbol)) {
        win = true;
      }
      else if ((board[0] == currentPlayer.symbol) && (board[3] == currentPlayer.symbol) && (board[6] == currentPlayer.symbol)) {
        win = true;
      }
      else if ((board[1] == currentPlayer.symbol) && (board[4] == currentPlayer.symbol) && (board[7] == currentPlayer.symbol)) {
        win = true;
      }
      else if ((board[1] == currentPlayer.symbol) && (board[4] == currentPlayer.symbol) && (board[7] == currentPlayer.symbol)) {
        win = true;
      }
      else if ((board[2] == currentPlayer.symbol) && (board[5] == currentPlayer.symbol) && (board[8] == currentPlayer.symbol)) {
        win = true;
      }
      else if ((board[2] == currentPlayer.symbol) && (board[5] == currentPlayer.symbol) && (board[8] == currentPlayer.symbol)) {
        win = true;
      }
      else if ((board[0] == currentPlayer.symbol) && (board[4] == currentPlayer.symbol) && (board[8] == currentPlayer.symbol)) {
        win = true;
      }
      else if ((board[0] == currentPlayer.symbol) && (board[4] == currentPlayer.symbol) && (board[8] == currentPlayer.symbol)) {
        win = true;
      }
      else if ((board[2] == currentPlayer.symbol) && (board[4] == currentPlayer.symbol) && (board[6] == currentPlayer.symbol)) {
        win = true;
      }
      else if ((board[2] == currentPlayer.symbol) && (board[4] == currentPlayer.symbol) && (board[6] == currentPlayer.symbol)) {
        win = true;
    /*if ((board[0] == board[1]) && (board[1] == board[2])) { 
      win = true;
    } else if ((board[3] == board[4]) && (board[4] == board[5])) { 
      win = true;
    } else if ((board[6] == board[7]) && (board[7] == board[8])) { 
      win = true;
    } else if ((board[0] == board[3]) && (board[3] == board[6])) { 
      win = true;
    } else if ((board[1] == board[4]) && (board[4] == board[7])) {
      win = true;
    } else if ((board[2] == board[5]) && (board[5] == board[8])) {
      win = true;
    } else if ((board[0] == board[4]) && (board[4] == board[8])) { 
      win = true;
    } else if ((board[2] == board[4]) && (board[4] == board[6])) {
      win = true;*/
    } else { 
      checkTie(); 
      //running method checkTie here instead of in runGame. 
   }
    if (win = true) {
      //congratulates the winner
      System.out.println ("Congrats! " + currentPlayer.symbol + " has won");
      break;
      //this part doesn't print out, nor does the game end when there is a 3 in a row
    }}}
  
  public void checkTie() {
    //checks for a tie
    for (int i = 0; i < 9; i++) {
      if (board[i] == ' ') {
        return;
      }
      else {
        tie = true;
        System.out.println ("Tie Game");
      }
  }
  }
  /*
   * what the for loop is replacing - Dr. Frewen board[0] = ' '; board[1] = ' ';
   * board[2] = ' '; board[3] = ' ';
   */

  // this needs to go in its own method
  public void putMarker() {
    //creates a variable called pTurn that helps run the while loop. also makes a scanner that helps take user input
    boolean pTurn = true;
    Scanner scan = new Scanner(System.in);
      System.out.println ("Welcome to multiplayer tictactoe.");
      System.out.println ("Rules: Enter a number 0-8 (0 being the top left, 1 top middle, 2 top right, 3 middle left...) If you enter a value in a slot that is already taken, your move will be skipped.");
    while (pTurn) {
      System.out.println("It is " + currentPlayer.symbol + "'s turn");
      // declare the scanner outside of the while loop to save memory
      System.out.println("Enter a number 0-8: ");
      while (!scan.hasNextInt()) {
        //if the user's input is not a number it will print this
        System.out.print("That is not a valid integer. Please type a valid integer: ");
        scan.nextLine();
        //if the user inputs an invalid number, it will skip to the next players turn.
      }
      // confirm that it is an int first. This will crash if a non-number
      // is given
      int mark = scan.nextInt();
      if (mark < 0 || mark > 8) {
        //if the user's input is not a value between 0-8, it will print this
        System.out.println("Please enter a valid number(0-8): ");
      } else if (board[mark] != ' ') {
        System.out.println("That spot is taken");
      } else {
        //places the user's play on the board
        board[mark] = currentPlayer.symbol;
        printBoard();
        checkWinner();
      }
      //switches turns
      if (currentPlayer.equals(player1)) {
        currentPlayer = player2;
      } else {
        currentPlayer = player1;
      }
    }
    }
//runs the methods
  public void runGame() {
    boolean cGame = true;
    if (cGame) {
      putMarker();
  }
}
}