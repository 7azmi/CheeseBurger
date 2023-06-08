package xo;

public interface GameInterface {
    void displayBoard();

    boolean makeMove(int pos, String marker);

    boolean checkWin(String marker);
}
