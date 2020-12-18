import java.util.Scanner;

public class Game {
  public char[] board = new char[9];
  User player1 = new User();
  User player2 = new User();
  boolean win;
  boolean tie;
  // you don't need to initialize it here, since you assign it to
  // player1 in the constructor
  User currentPlayer;

  public Game() {
    player1.symbol = 'X';
    player2.symbol = 'O';
    currentPlayer = player1;
    for (int i = 0; i < 9; i++) {
      board[i] = ' ';
    }
  }

  public void printBoard() {
    System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
    System.out.println("----------");
    System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
    System.out.println("----------");
    System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
  }

  public void checkWinner() { 
    if ((board[0] == board[1]) && (board[1] == board[2])) { 
      win = true;
      return;
    } else if ((board[3] == board[4]) && (board[4] == board[5])) { 
      win = true;
      return; 
    } else if ((board[6] == board[7]) && (board[7] == board[8])) { 
      win = true;
      return; 
    } else if ((board[0] == board[3]) && (board[3] == board[6])) { 
      win = true;
      return;
    } else if ((board[1] == board[4]) && (board[4] == board[7])) {
      win = true;
      return; 
    } else if ((board[2] == board[5]) && (board[5] == board[8])) {
      win = true;
      return; 
    } else if ((board[0] == board[4]) && (board[4] == board[8])) { 
      win = true;
      return; 
    } else if ((board[2] == board[4]) && (board[4] == board[6])) {
      win = true;
      return; 
    } else { 
      checkTie(); 
      //running method checkTie here instead of in runGame. 
   }}
  
  public void checkTie() {
    for (int i = 0; i < 9; i++) {
      if (board[i] == ' ') {
        return;
      }
    }
    tie = true;
  }
  /*
   * what the for loop is replacing - Dr. Frewen board[0] = ' '; board[1] = ' ';
   * board[2] = ' '; board[3] = ' ';
   */

  // this needs to go in its own method
  public void putMarker() {
    boolean pTurn = true;
    Scanner scan = new Scanner(System.in);
    while (pTurn) {
      System.out.println(currentPlayer.symbol + "'s' turn");
      // declare the scanner outside of the while loop to save memory
      System.out.println("Enter a number 0-8: ");
      while (!scan.hasNextInt()) {
        System.out.print("That is not a valid integer. Please type a valid integer: ");
        scan.nextLine();
      }
      // confirm that it is an int first. This will crash if a non-number
      // is given
      int mark = scan.nextInt();
      if (mark < 0 || mark > 8) {
        System.out.println("Please enter a valid number(0-8): ");
      } else if (board[mark] != ' ') {
        System.out.println("That spot is taken");
      } else {
        pTurn = false;
        board[mark] = currentPlayer.symbol;
      }
    }
  }

  public void runGame() {
    while ((win = false) && (tie = false)) {
      putMarker();
      checkWinner();
      if (currentPlayer.equals(player1)) {
        currentPlayer = player2;
      } else {
        currentPlayer = player1;
      }
    }
  }
}