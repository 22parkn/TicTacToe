import java.util.Scanner;

public class Game {
  // creating board, users, and variables
  public char[] board = new char[9];
  User player1 = new User();
  User player2 = new User();
  boolean win = false;
  boolean tie = false;
  // you don't need to initialize it here, since you assign it to
  // player1 in the constructor
  User currentPlayer;

  public Game() {
    player1.symbol = 'X';
    player2.symbol = 'O';
    currentPlayer = player1;
    // creates the empty spaces on the board
    for (int i = 0; i < 9; i++) {
      board[i] = ' ';
    }
    printBoard();
    runGame();
  }

  // creates the lines on the board
  public void printBoard() {
    System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
    System.out.println("----------");
    System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
    System.out.println("----------");
    System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
  }

  public void runGame() {
    System.out.println("Welcome to multiplayer tictactoe.");
      System.out.println(
          "Rules: Enter a number 0-8(0 being the top left, 1 top middle, 2 top right, 3 middle left... and so on. If you enter a value in a slot that is already taken, your move will be skipped.");
    // while there is no winner or tie, run the following code
    while ((win == false) && (tie == false)) {
      // putMarker();
      checkWinner();
      Scanner scan = new Scanner(System.in);
        System.out.println("It is " + currentPlayer.symbol + "'s turn");
        // declare the scanner outside of the while loop to save memory
        System.out.println("Enter a number 0-8: ");
        // checks if the input is a number
        while (!scan.hasNextInt()) {
          System.out.print("That is not a valid integer. Please type a valid integer: ");
          scan.nextLine();
          int mark = currentPlayer.symbol;
          // confirm that it is an int first. This will crash if a non-number
          // is given
          // checks if the number input is between 0-8
          if (mark < 0 || mark > 8) {
            System.out.println("Please enter a valid number(0-8): ");
          } else if (board[mark] != ' ') {
            System.out.println("That spot is taken");
          } else {
            board[mark] = currentPlayer.symbol;
            checkWinner();
          }
          // switches turns
          if (currentPlayer.equals(player1)) {
            currentPlayer = player2;
          } else {
            currentPlayer = player1;
          }
        }
        printBoard();
        // if the user inputs an invalid number, it will skip to the next players turn.
      }
    }
  }

  public void checkWinner() {
    // checks if there are three identical symbols lined up
    if ((board[0] == board[1]) && (board[1] == board[2]) && board[0] != ' ') {
      win = true;
    } else if ((board[3] == board[4]) && (board[4] == board[5]) && board[4] != ' ') {
      win = true;
    } else if ((board[6] == board[7]) && (board[7] == board[8]) && board[6] != ' ') {
      win = true;
    } else if ((board[0] == board[3]) && (board[3] == board[6]) && board[6] != ' ') {
      win = true;
    } else if ((board[1] == board[4]) && (board[4] == board[7]) && board[1] != ' ') {
      win = true;
    } else if ((board[2] == board[5]) && (board[5] == board[8]) && board[5] != ' ') {
      win = true;
    } else if ((board[0] == board[4]) && (board[4] == board[8]) && board[0] != ' ') {
      win = true;
    } else if ((board[2] == board[4]) && (board[4] == board[6]) && board[2] != ' ') {
      win = true;
    } else {
      checkTie();
      // running method checkTie here instead of in runGame.
    }
    if (win == true) {
      System.out.println("Congrats! " + currentPlayer.symbol + " has won");
      // this part doesn't print out, nor does the game end when there is a 3 in a row
    }
  }

  public void checkTie() {
    for (int i = 0; i < 9; i++) {
      // if there are any empty spaces on the board, continue the game
      if (board[i] == ' ') {
        return;
      }
      // if not, the game is over as a tie
      else {
        System.out.println("Tie game.");
      }
    }
  }
  /*
   * what the for loop is replacing - Dr. Frewen board[0] = ' '; board[1] = ' ';
   * board[2] = ' '; board[3] = ' ';
   */

  // this needs to go in its own method
  /*
   * public void putMarker() { int mark = currentPlayer.symbol; // confirm that it
   * is an int first. This will crash if a non-number // is given if (mark < 0 ||
   * mark > 8) { System.out.println("Please enter a valid number(0-8): "); } else
   * if (board[mark] != ' ') { System.out.println("That spot is taken"); } else {
   * board[mark] = currentPlayer.symbol; printBoard(); checkWinner(); } if
   * (currentPlayer.equals(player1)) { currentPlayer = player2; } else {
   * currentPlayer = player1; } }
   */
}