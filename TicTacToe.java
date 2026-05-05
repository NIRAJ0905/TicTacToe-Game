import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    static char humanSymbol = 'X';
    static char computerSymbol = 'O';

    static boolean isHumanTurn = true;
    static boolean gameOver = false;

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        System.out.println("=== Tic Tac Toe Game ===");

        printBoard();

        while (!gameOver) {

            if (isHumanTurn) {
                humanMove();
                if (hasWon(humanSymbol)) {
                    printBoard();
                    System.out.println("Human Wins!");
                    gameOver = true;
                    break;
                }
            } else {
                computerMove();
                if (hasWon(computerSymbol)) {
                    printBoard();
                    System.out.println("Computer Wins!");
                    gameOver = true;
                    break;
                }
            }

            if (isDraw()) {
                printBoard();
                System.out.println("Game Draw!");
                gameOver = true;
                break;
            }

            isHumanTurn = !isHumanTurn; // switch turn
            printBoard();
        }
    }

    // HUMAN MOVE (UC3 + UC4 + UC5 + UC6)
    static void humanMove() {

        while (true) {

            System.out.print("Enter slot (1-9): ");
            int slot = scanner.nextInt();

            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;

            if (isValidMove(row, col)) {
                placeMove(row, col, humanSymbol);
                break;
            } else {
                System.out.println("Invalid move! Try again.");
            }
        }
    }

    // COMPUTER MOVE (UC7)
    static void computerMove() {

        while (true) {

            int slot = random.nextInt(9) + 1;

            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;

            if (isValidMove(row, col)) {
                placeMove(row, col, computerSymbol);
                break;
            }
        }
    }

    // VALIDATION (UC5)
    static boolean isValidMove(int row, int col) {
        return (row >= 0 && row < 3 &&
                col >= 0 && col < 3 &&
                board[row][col] == '-');
    }

    //  PLACE MOVE (UC6)
    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    //  WIN CHECK (UC9)
    static boolean hasWon(char symbol) {

        // rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol)
                return true;
        }

        // columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == symbol &&
                board[1][j] == symbol &&
                board[2][j] == symbol)
                return true;
        }

        // diagonals
        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol)
            return true;

        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol)
            return true;

        return false;
    }

    // DRAW CHECK (UC10)
    static boolean isDraw() {

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == '-')
                    return false;
            }
        }
        return true;
    }

    // PRINT BOARD (UC1)
    static void printBoard() {

        System.out.println("-------------");

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                System.out.print("| " + board[i][j] + " ");
            }

            System.out.println("|");
            System.out.println("-------------");
        }
    }
}