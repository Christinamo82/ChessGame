package Tests;
import Game.*;
import Pieces.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class Queen_Test {

    @Test
    public void QueenMoveValid(){
        Board test = new Board();
        test.board[4][5] = new Queen(4, 5, Color.WHITE, Type.QUEEN);
        test.board[6][3] = new Knight(4, 1, Color.WHITE, Type.KNIGHT);
        test.board[6][7] = new Queen(6, 7, Color.BLACK, Type.QUEEN);
        assertEquals(test.board[4][5].isValid(4, 5, 2, 7, test), true);
        assertEquals(test.board[4][5].isValid(4, 5, 2, 3, test), true);
        assertEquals(test.board[4][5].isValid(4, 5, 4, 2, test), false); //illegal move
        assertEquals(test.board[4][5].isValid(4, 5, 9, 10,  test), false); //out of bound
        assertEquals(test.board[4][5].isValid(4, 5, 6, 3, test), false); //same color block
        assertEquals(test.board[4][5].isValid(4, 5, 6, 7, test), true); //different color block
    }
}
