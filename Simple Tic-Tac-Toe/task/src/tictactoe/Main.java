package tictactoe;

import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static char[][] ticTacToe = new char[4][4];
    static int[] userInput = new int[2];
    static String winner = "";
    public static void main(String[] args) {
        clearTicTac();
        makeTicTac();
        int i = 0;
        while (true){
            playTicTac(i);
            makeTicTac();
            getWinner();
            if (!winner.isEmpty()) break;
            i++;
        }
        System.out.println(winner);
    }

    static void playTicTac(int index){
        System.out.print("Enter the coordinates: ");
        try {
            userInput[0] = sc.nextInt();
            userInput[1] = sc.nextInt();
        }catch (Exception e){
            System.out.print("You should enter numbers! ");
            playTicTac(index);
        }

        if (userInput[0] <= 0 || userInput[1] <= 0 || userInput[0] > 3 || userInput[1] > 3){
            System.out.print("Coordinates should be from 1 to 3! ");
            playTicTac(index);
        }else if (ticTacToe[userInput[0]][userInput[1]] == 'X' || ticTacToe[userInput[0]][userInput[1]] == 'O'){
            System.out.print("This cell is occupied! Choose another one! ");
            playTicTac(index);
        }else{
            if (index % 2 == 0) ticTacToe[userInput[0]][userInput[1]] = 'X';
            else ticTacToe[userInput[0]][userInput[1]] = 'O';
        }

    }

//X = 88
// O = 79
    static void getWinner() {
        if (ticTacToe[1][1] + ticTacToe[1][2] + ticTacToe[1][3] == 264 || ticTacToe[1][1] + ticTacToe[1][2] + ticTacToe[1][3] == 237) winner = ticTacToe[1][1] == ' ' ? ticTacToe[1][2] == ' ' ? ticTacToe[1][3] + " wins" : ticTacToe[1][2] + " wins" : ticTacToe[1][1] + " wins";
        if (ticTacToe[2][1] + ticTacToe[2][2] + ticTacToe[2][3] == 264 || ticTacToe[2][1] + ticTacToe[2][2] + ticTacToe[2][3] == 237)
            winner = ticTacToe[2][1] == ' ' ? ticTacToe[2][2] == ' ' ? ticTacToe[2][3] + " wins" : ticTacToe[2][2] + " wins" : ticTacToe[2][1] + " wins";
        if (ticTacToe[3][1] + ticTacToe[3][2] + ticTacToe[3][3] == 264 || ticTacToe[3][1] + ticTacToe[3][2] + ticTacToe[3][3] == 237)
            winner = ticTacToe[3][1] == ' ' ? ticTacToe[3][2] == ' ' ? ticTacToe[3][3] + " wins" : ticTacToe[3][2] + " wins" : ticTacToe[3][1] + " wins";

        if (ticTacToe[1][1] + ticTacToe[2][1] + ticTacToe[3][1] == 264 || ticTacToe[1][1] + ticTacToe[2][1] + ticTacToe[3][1] == 237)
            winner = ticTacToe[1][1] == ' ' ? ticTacToe[2][1] == ' ' ? ticTacToe[3][1] + " wins" : ticTacToe[2][1] + " wins" : ticTacToe[1][1] + " wins";
        if (ticTacToe[1][2] + ticTacToe[2][2] + ticTacToe[3][2] == 264 || ticTacToe[1][2] + ticTacToe[2][2] + ticTacToe[3][2] == 237)
            winner = ticTacToe[1][2] == ' ' ? ticTacToe[2][2] == ' ' ? ticTacToe[3][2] + " wins" : ticTacToe[2][2] + " wins" : ticTacToe[1][2] + " wins";
        if (ticTacToe[1][3] + ticTacToe[2][3] + ticTacToe[3][3] == 264 || ticTacToe[1][3] + ticTacToe[2][3] + ticTacToe[3][3] == 237)
            winner = ticTacToe[1][3] == ' ' ? ticTacToe[2][3] == ' ' ? ticTacToe[3][3] + " wins" : ticTacToe[2][3] + " wins" : ticTacToe[1][3] + " wins";

        if (ticTacToe[1][1] + ticTacToe[2][2] + ticTacToe[3][3] == 264 || ticTacToe[1][1] + ticTacToe[2][2] + ticTacToe[3][3] == 237)
            winner = ticTacToe[1][1] == ' ' ? ticTacToe[2][2] == ' ' ? ticTacToe[3][3] + " wins" : ticTacToe[2][2] + " wins" : ticTacToe[1][1] + " wins";
        if (ticTacToe[1][3] + ticTacToe[2][2] + ticTacToe[3][1] == 264 || ticTacToe[1][3] + ticTacToe[2][2] + ticTacToe[3][1] == 237)
            winner = ticTacToe[1][3] == ' ' ? ticTacToe[2][2] == ' ' ? ticTacToe[3][1] + " wins" : ticTacToe[2][2] + " wins" : ticTacToe[1][3] + " wins";

        int draw = 0;
        for (var x : ticTacToe) {
            for (var y : x) {
                if (y == ' ')draw++;
            }
        }
        if (winner != "")return;
        else winner = draw == 0 ? "draw" : winner;
    }

    static void makeTicTac(){
        System.out.println("---------");
        for (int i = 1; i <= 3; i++) {
            System.out.print("| ");
            for (int j = 1; j <= 3; j++) {
                System.out.print(ticTacToe[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    static void clearTicTac(){
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                ticTacToe[i][j] = ' ';
            }
        }
    }
}
