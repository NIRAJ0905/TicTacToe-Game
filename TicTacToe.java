import java.util.Random;

public class TicTacToe {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    static boolean isHumanTurn = true;
    static boolean gameOver = false;

    static char humanSymbol = 'X';
    static char computerSymbol = 'O';

    public static void main(String[] args) {

        while (!gameOver) {

            if (isHumanTurn) {

                System.out.println("Human Turn");

                // sample move (will be replaced in next UC)
                placeMove(0, 0, humanSymbol);

            } else {

                System.out.println("Computer Turn");

                computerMove();
            }

            printBoard();

            // TEMP: stop after one loop (until UC9 win/draw comes)
            gameOver = true;

            isHumanTurn = !isHumanTurn; // switch turn
        }
    }

    static void computerMove() {

        Random random = new Random();

        while (true) {

            int slot = random.nextInt(9) + 1;

            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;

            if (board[row][col] == '-') {

                placeMove(row, col, computerSymbol);
                break;
            }
        }
    }

    static void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

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