package treasurehunt;

import java.util.Random;
import java.util.Scanner;

public class TreasureHunt {

    public static void main(String[] args) {

        int game = 0;
        int guesses = 30;
        int totalPoints = 0;
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        String[][] board = new String[6][6];

        System.out.println("You will be given a 10x10 grid filled with a random amount of treasure.\nTry to find it all!\n");

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                board[i][j] = " o";
            }
        }

        for (int r = 0; r < rand.nextInt(100); r++) {
            int x = rand.nextInt(6);
            int y = rand.nextInt(6);
            int points = rand.nextInt(6);
            String pointsString = Integer.toString(points);
            board[y][x] = (pointsString);
        }

        while (guesses > 0) {
            try {
                System.out.println("Guess a coordinate from 1-6. x then y.");
                System.out.println("You have " + guesses + " guesses remaining.");
                int userX = scan.nextInt();
                int userY = scan.nextInt();
                if (board[userY - 1][userX - 1].equals(" x")) {
                    System.out.println("YOU HAVE ALREADY GUESSED HERE. NO LIVES TAKEN.");
                } else {

                    if (board[userY - 1][userX - 1].equals(" o")) {
                        System.out.println("MISS");
                        board[userY - 1][userX - 1] = (" x");
                        guesses--;

                    } else {
                        System.out.println("HIT!");
                        totalPoints = totalPoints + board[userY - 1][userX - 1].charAt(0);
                        System.out.println("You have found " + board[userY - 1][userX - 1].charAt(0) + " points.\n");
                        guesses--;

                    }
                }
            } catch (Exception e) {
                System.out.println("You have not entered a valid coordinate!");
            }

        }
        System.out.println("GAME OVER\nYOU SCORED: " + totalPoints + " POINTS!");
    }
}
