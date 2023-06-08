package xo;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;


public class Main {
    public static void main(String[] args) {
        GameInterface board = new GameBoard();
        Player player1 = new HumanPlayer("X");
        Player player2 = new BotPlayer("O");

        String winner = "Draw";
        board.displayBoard();
        for (int i = 1; i <= 9; i++) {
            Player currentPlayer = i % 2 == 1 ? player1 : player2;
            System.out.println("Player " + currentPlayer.getMarker() + " turn");

            int move;
            do {
                move = currentPlayer.getPlayerMove();
            } while (!board.makeMove(move, currentPlayer.getMarker()));

            board.displayBoard();
            if (board.checkWin(currentPlayer.getMarker())) {
                winner = currentPlayer.getMarker() + " is the Winner!";
                System.out.println(winner);
                break;
            }
        }
        if (winner.equals("Draw")) {
            System.out.println("Draw");
        }

        // Store game stats
        storeGameStats(winner);
    }

    private static void storeGameStats(String winner) {
        try {
            File file = new File("gameStats.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(file, true); // Appending to existing file
            writer.write("Winner of the game: " + winner + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while storing game stats.");
            e.printStackTrace();
        }
    }
}
