import java.util.Random;

public class TicTacToe {

    static char[][] board = new char[3][3];

    static char playerSymbol;
    static char computerSymbol;
    static String currentTurn;

    public static void main(String[] args) {

        initializeBoard();

        toss();

        printBoard();
    }

    static void initializeBoard() {

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                board[row][col] = '-';
            }
        }
    }

    static void toss() {

        Random random = new Random();

        int result = random.nextInt(2);   // 0 or 1

        if (result == 0) {

            System.out.println("Player won toss!");
            playerSymbol = 'X';
            computerSymbol = 'O';
            currentTurn = "Player";

        } else {

            System.out.println("Computer won toss!");
            playerSymbol = 'O';
            computerSymbol = 'X';
            currentTurn = "Computer";
        }

        System.out.println("Player Symbol: " + playerSymbol);
        System.out.println("Computer Symbol: " + computerSymbol);
        System.out.println("First Turn: " + currentTurn);
    }

    static void printBoard() {

        System.out.println("-------------");

        for (int row = 0; row < 3; row++) {

            for (int col = 0; col < 3; col++) {

                System.out.print("| " + board[row][col] + " ");
            }

            System.out.println("|");
            System.out.println("-------------");
        }
    }
}