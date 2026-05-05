public class TicTacToe {

    static char[][] board = new char[3][3];

    public static void main(String[] args) {

        board[0][0] = 'X';
        board[0][1] = 'X';
        board[0][2] = 'X';

        System.out.println(hasWon('X'));
    }

    static boolean hasWon(char symbol) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol &&
                board[i][1] == symbol &&
                board[i][2] == symbol) {
                return true;
            }
        }
     
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == symbol &&
                board[1][j] == symbol &&
                board[2][j] == symbol) {
                return true;
            }
        }
    
        if (board[0][0] == symbol &&
            board[1][1] == symbol &&
            board[2][2] == symbol) {
            return true;
        }
       
        if (board[0][2] == symbol &&
            board[1][1] == symbol &&
            board[2][0] == symbol) {
            return true;
        }
     
        return false;
    }
}