package org.example;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                █░█░█ █▀▀ █░░ █▀▀ █▀█ █▀▄▀█ █▀▀   ▀█▀ █▀█   ▀█▀ █ █▀▀   ▀█▀ ▄▀█ █▀▀   ▀█▀ █▀█ █▀▀
                ▀▄▀▄▀ ██▄ █▄▄ █▄▄ █▄█ █░▀░█ ██▄   ░█░ █▄█   ░█░ █ █▄▄   ░█░ █▀█ █▄▄   ░█░ █▄█ ██▄
                """);
        System.out.println();
        boolean playAgain = true;

        while (playAgain) {

            game.showBoard();

            while (!game.isGameOver()) {

                System.out.println();
                System.out.println("Player " + game.getCurrentPlayerMarker() + "'s turn.");

                System.out.print("Choose x position between 0 and 2: ");
                int x = scanner.nextInt();

                System.out.print("Choose y position between 0 and 2: ");
                int y = scanner.nextInt();

                boolean moveSuccessful = game.makeMove(x, y);

                if (moveSuccessful && !game.isGameOver()) {
                    System.out.println();
                    game.showBoard();
                }
            }

            System.out.println();
            System.out.print("Start a new game? (y/n): ");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("y")) {
                game.startNewGame();
            } else {
                playAgain = false;
            }
        }

        scanner.close();
    }
}