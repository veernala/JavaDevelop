import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        
        int currentPlayer = 1;
        int totalMoves = 0;

        System.out.println("Welcome Arjuns game ");

        while (true) {
            printBoard(board);

            int row, col;
            do {
                System.out.print("Player " + currentPlayer + ", enter row (0-2): ");
                row = scanner.nextInt();
                System.out.print("Player " + currentPlayer + ", enter column (0-2): ");
                col = scanner.nextInt();
            } while (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ');

            board[row][col] = (currentPlayer == 1) ? 'X' : 'O';
            totalMoves++;

            if (checkWin(board)) {
                printBoard(board);
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (totalMoves == 9) {
                printBoard(board);
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }

        scanner.close();
    }

    public static void printBoard(char[][] board) {
        System.out.println("  0 1 2");
        for (int row = 0; row < 3; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < 3; col++) {
                System.out.print(board[row][col]);
                if (col < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (row < 2) {
                System.out.println("  -----");
            }
        }
    }

    public static boolean checkWin(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }
}
