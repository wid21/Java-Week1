import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner data = new Scanner(System.in);
        char[][] gameboard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
        print(gameboard);

        while (true) {
            System.out.println("Enter number between 1 to 9 ");
            int input = data.nextInt();
            while(!isValidPlace(gameboard, input)){
                System.out.println("Position is taken or invalid. Enter another position: ");
                input = data.nextInt();
            }
            postion(gameboard, input, "player");
            if (isWinner(gameboard, "player")) {
                System.out.println("Congratulations! You won!");
                break;
            }
            if (isComplete(gameboard)) {
                System.out.println("Board is full. It's a tie!");
                break;
            }
            Random random = new Random();
            System.out.print("Computer chose: ");
            int co = random.nextInt(9) + 1;
            while(!isValidPlace(gameboard, co)){
                co = random.nextInt(9) + 1;
            }
            System.out.println(co);
            postion(gameboard, co, "computer");
            if (isWinner(gameboard, "computer")) {
                System.out.println("Computer wins!");
                break;
            }
            if (isComplete(gameboard)) {
                System.out.println("Board is full. It's a tie!");
                break;
            }
        }
    }

    //methode to print the board
    public static void print(char[][] gameboard) {
        for (char[] r : gameboard) {
            for (char c : r) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    //methode to make move
    public static void postion(char[][] gameboard, int input, String user) {
        char m1 = 'X';
        if (user.equals("player")) {
            m1 = 'X';
        } else if (user.equals("computer")) {
            m1 = 'O';
        }
        switch (input) {
            case 1:
                gameboard[0][0] = m1;
                break;
            case 2:
                gameboard[0][2] = m1;
                break;
            case 3:
                gameboard[0][4] = m1;
                break;
            case 4:
                gameboard[2][0] = m1;
                break;
            case 5:
                gameboard[2][2] = m1;
                break;
            case 6:
                gameboard[2][4] = m1;
                break;
            case 7:
                gameboard[4][0] = m1;
                break;
            case 8:
                gameboard[4][2] = m1;
                break;
            case 9:
                gameboard[4][4] = m1;
                break;
            default:
                break;
        }
        print(gameboard);
    }

    //methode to check if the board full
    public static boolean isComplete(char[][] gameboard) {
        for (int i = 0; i < gameboard.length; i++) {
            for (int j = 0; j < gameboard[i].length; j++) {
                if (gameboard[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    //methode check the winner in 3 ways
    public static boolean isWinner(char[][] gameboard, String player) {
        char m1 = 'X';
        if (player.equals("computer")) {
            m1 = 'O';
        }
        // check rows
        for (int i = 0; i < gameboard.length; i += 2) {
            if (gameboard[i][0] == m1 && gameboard[i][2] == m1 && gameboard[i][4] == m1) {
                return true;
            }
        }
        // check columns
        for (int i = 0; i < gameboard.length; i += 2) {
            if (gameboard[0][i] == m1 && gameboard[2][i] == m1 && gameboard[4][i] == m1) {
                return true;
            }
        }
        // check diagonals
        if (gameboard[0][0] == m1 && gameboard[2][2] == m1 && gameboard[4][4] == m1) {
            return true;
        }
        if (gameboard[0][4] == m1 && gameboard[2][2] == m1 && gameboard[4][0] == m1) {
            return true;
        }
        return false;
    }

    //methode to check the place
    public static boolean isValidPlace(char[][] gameboard, int position) {
        switch (position) {
            case 1:
                return gameboard[0][0] == ' ';
            case 2:
                return gameboard[0][2] == ' ';
            case 3:
                return gameboard[0][4] == ' ';
            case 4:
                return gameboard[2][0] == ' ';
            case 5:
                return gameboard[2][2] == ' ';
            case 6:
                return gameboard[2][4] == ' ';
            case 7:
                return gameboard[4][0] == ' ';
            case 8:
                return gameboard[4][2] == ' ';
            case 9:
                return gameboard[4][4] == ' ';
            default:
                return false;
        }
    }
}