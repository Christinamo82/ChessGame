package Tests;
import GUI.*;
import Game.Board;
import Game.Color;
import Game.Type;
import Pieces.*;
public class GUI_Test {
    public static void main(String[] args) {
        Board test = new Board();
        test.iniBoard();
        test.isPlaced(2, 1, test.board[1][1]);
        new BoardGUI(test);
        test.isPlaced(4, 6, test.board[6][6]);
        new BoardGUI(test);
        test.board[3][0] = test.board[1][0];
        test.board[1][0] = null;
        new BoardGUI(test);
        test.isPlaced(2, 0, test.board[0][0]);
        new BoardGUI(test);

    }
}
