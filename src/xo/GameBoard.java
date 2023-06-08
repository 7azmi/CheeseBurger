package xo;

public class GameBoard implements GameInterface {
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
