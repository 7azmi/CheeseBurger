package xo;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;


interface GameInterface {
    void displayBoard();
    boolean makeMove(int pos, String marker);
    boolean checkWin(String marker);
}

abstract class Player {
    protected String marker;

    Player(String marker) {
        this.marker = marker;
    }

    public String getMarker() {
        return this.marker;
    }

    abstract public int getPlayerMove();
}

class HumanPlayer extends Player {
    HumanPlayer(String marker) {
        super(marker);
    }

    @Override
    public int getPlayerMove() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
}

class BotPlayer extends Player {
    BotPlayer(String marker) {
        super(marker);
    }

    @Override
    public int getPlayerMove() {
        return (int) (Math.random() * 9 + 1);
    }
}

class GameBoard implements GameInterface {
    private String[] board;

    GameBoard() {
        this.board = new String[10];
        for (int i = 0; i < 10; i++) {
            board[i] = " ";
        }
    }

    @Override
    public void displayBoard() {
        for (int i = 1; i <= 9; i += 3) {
            System.out.println(board[i] + "|" + board[i + 1] + "|" + board[i + 2]);
        }
    }

    @Override
    public boolean makeMove(int pos, String marker) {
        if (board[pos].equals(" ")) {
            board[pos] = marker;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean checkWin(String marker) {
        // Horizontal checks
        for (int i = 1; i <= 7; i += 3) {
            if (board[i].equals(marker) && board[i + 1].equals(marker) && board[i + 2].equals(marker)) {
                return true;
            }
        }

        // Vertical checks
        for (int i = 1; i <= 3; i++) {
            if (board[i].equals(marker) && board[i + 3].equals(marker) && board[i + 6].equals(marker)) {
                return true;
            }
        }

        // Diagonal checks
        if (board[1].equals(marker) && board[5].equals(marker) && board[9].equals(marker)) {
            return true;
        }
        if (board[3].equals(marker) && board[5].equals(marker) && board[7].equals(marker)) {
            return true;
        }

        return false;
    }

}

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
