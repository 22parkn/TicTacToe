import java.util.Scanner;

public class Game {
  public char[] board = new char[9];
  User player1 = new User();
  User player2 = new User();
  User currentPlayer = new User();

  public Game() {
    player1.symbol = 'X';
    player2.symbol = 'O';
    for (int i = 0; i < 9; i++) {
      board[i] = ' ';
      currentPlayer = player1;
    }
  }

  /*
   * public void playerTurn() { if (current.player = player1) {
   * System.out.println(player1 + "'s turn(x): "); } else {
   * System.out.println(player2 + "'s turn(o): "); } }
   */
  /*
   * public void Winner() { put something here }
   */
  /*
   * what the for loop is replacing - Dr. Frewen board[0] = ' '; board[1] = ' ';
   * board[2] = ' '; board[3] = ' ';
   */

  public void printBoard() {
    System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
    System.out.println("----------");
    System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
    System.out.println("----------");
    System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
  }
    while (true) {
      Scanner scan = new Scanner();
      System.out.println("Enter a number 0-8: ");
      int mark = scan.nextInt();
      if (mark < 0 || mark > 8) {
        System.out.println("Please enter a valid number(0-8): ");
      } else if (board[mark] != ' ') {
        System.out.println("That spot is taken");
      } else {
        break;
      }
    }
}