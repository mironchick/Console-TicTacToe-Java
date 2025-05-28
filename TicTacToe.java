import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char [3][3];
    private static char currentPlayer;
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        initializeGame();
        printBoard();
        while (true) {
            System.out.println("Игрок " + currentPlayer + ", ваш ход. Введите строку и столбец (1-3):");
            int row = getInput("Строка: ") - 1;
            int col = getInput("Столбец: ") - 1;
            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                if (checkWin()) {
                    printBoard();
                    System.out.println("Игрок " + currentPlayer + " победил !");
                    break;
                }
                if (isBoardFull()) {
                    printBoard();
                    System.out.println("Ничья!");
                    break;
                }
                switchPlayer();
                printBoard();
            } else {
                System.out.println("Неверный ход!");
            }
        }
        scanner.close();
    }
    private static void initializeGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                board[i][j] = ' ';
            }
        }
        currentPlayer = 'X';
    }
    private static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
        System.out.print("| ");
        for (int j = 0; j < 3; j++) {
            System.out.print(board[i][j] + " | ");
        }
        System.out.println();
        System.out.println("-------------");
        }
    }
    private static int getInput(String prompt) {
        System.out.println(prompt);
        while (true) {
            try {
                int input = scanner.nextInt();
                if (input >= 1 && input <= 3) {
                    return input;
                } else {
                    System.out.println("Введите число от 1 до 3: ");
                }
            } catch (Exception e) {
                System.out.print("Некорректный ввод. Введите число от 1 до 3: ");
                scanner.next();
            }
        }
    }
    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }
    private static boolean checkWin() {
    for (int i = 0; i < 3; i++) {
        if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
            return true;
        }
        if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
            return true;
        }
    }
    if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
        return true;
    }
    if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
        return true;
    }
    return false;
    }
    private static boolean isBoardFull() {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (board[i][j] == ' ') {
                return false;
            }
        }
    }
    return true;
    }
    private static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}