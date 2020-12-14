import java.util.Scanner;

public class Game {
  public char[] board = new char[9];
  User player1 = new User();
  User player2 = new User();
  int mark;
  // you don't need to initialize it here, since you assign it to 
  // player1 in the constructor
  User currentPlayer;

  public Game() {
    player1.symbol = 'X';
    player2.symbol = 'O';
    for (int i = 0; i < 9; i++) {
      board[i] = ' ';
      currentPlayer = player1;
    }
  }

  
   public void playerTurn() { 
     System.out.println (currentPlayer.symbol + "'s' turn");
   }
   
   public void printBoard() {
    System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
    System.out.println("----------");
    System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
    System.out.println("----------");
    System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
  }
  /*
   public double Winner() {
    boolean line;
   if (line = board[0] + board[1] + board[2]) {
    break; 
   }
   else if (line = board[3] + board[4] + board[5]) {
     break;
   }
   else if (line = board[6] + board[7] + board[8]) {
     break;
   }
   else if (line = board[0] + board[3] + board[6]) {
     break;
   }
   else if (line = board[1] + board[4] + board[7]) {
     break;
   }
   else if (line = board[2] + board[5] + board[8]) {
     break;
   }
   else if (line = board[0] + board[4] + board[8]) {
     break;
   }
   else if (line = board[2] + board[4] + board[6]) {
     break;
   }
   else {
     System.out.println("Tie");
     break;
   }
   }
   
   
  /*
   * what the for loop is replacing - Dr. Frewen board[0] = ' '; board[1] = ' ';
   * board[2] = ' '; board[3] = ' ';
   */

  // this needs to go in its own method
  public void putMarker() {
    Scanner scan = new Scanner(System.in);
    while (true) {
      // declare the scanner outside of the while loop to save memory
      System.out.println("Enter a number 0-8: ");
      // confirm that it is an int first. This will crash if a non-number 
      // is given
      mark = scan.nextInt();
      if (mark < 0 || mark > 8) {
        System.out.println("Please enter a valid number(0-8): ");
      } else if (board[mark] != ' ') {
        System.out.println("That spot is taken");
      } else {
        break;
      }
    }
}
}