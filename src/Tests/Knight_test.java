package Tests;
import Game.*;
import Pieces.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class Knight_test {
    @Test
    public void KnightMoveValid() {
        Board test = new Board();
        test.board[4][5] = new Knight(4, 5, Color.WHITE, Type.KNIGHT);
        test.board[6][4] = new Queen(6, 4, Color.WHITE, Type.QUEEN);
        test.board[3][3] = new Queen(3, 3, Color.BLACK, Type.QUEEN);
        assertEquals(test.board[4][5].isValid(4, 5, 2, 6, test), true);
        assertEquals(test.board[4][5].isValid(4, 5, 5, 7, test), true);
        assertEquals(test.board[4][5].isValid(4, 5, 4, 1, test), false); //illegal move
        assertEquals(test.board[4][5].isValid(4, 5, 8, 1,  test), false); //out of bound
        assertEquals(test.board[4][5].isValid(4, 5, 6, 4, test), false); //same color block
        assertEquals(test.board[4][5].isValid(4, 5, 3, 3, test), true); //different color block
    }
}
