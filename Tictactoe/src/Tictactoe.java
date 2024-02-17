import java.util.*;
public class Tictactoe {
    private char[][] board;
    private char currentPlayer;

    public Tictactoe() {
        board = new char[3][3];
        currentPlayer = 'X';

        // Initialize the board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '-') {
            System.out.println("Invalid move. Try again.");
            return false;
        }

        board[row][col] = currentPlayer;
        return true;
    }

    public boolean checkWin() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true; // Row win
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true; // Column win
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true; // Main diagonal win
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true; // Other diagonal win
        }

        return false;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }


    public static void main(String[] args) {
        Tictactoe game = new Tictactoe();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Print the current state of the board
            game.printBoard();

            // Get the player's move
            System.out.println("Player " + game.currentPlayer + ", enter your move (row and column):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Make the move and check for a win
            if (game.makeMove(row, col)) {
                if (game.checkWin()) {
                    System.out.println("Player " + game.currentPlayer + " wins!");
                    break;
                } else if (game.isBoardFull()) {
                    System.out.println("The game is a tie!");
                    break;
                } else {
                    game.switchPlayer();
                }
            }
        }

        // Close the scanner
        scanner.close();
    }
}

