package Tests;
import Game.*;
import Pieces.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class King_Test {
    @Test
    public void KingMoveValid(){
        Board King_test = new Board();
        King_test.board[2][3] = new King(6, 6, Color.WHITE, Type.KING);
        King_test.board[4][4] = new Queen(4, 4, Color.WHITE, Type.QUEEN);
        King_test.board[2][4] = new Queen(2, 4, Color.BLACK, Type.QUEEN);
        assertEquals(King_test.board[2][3].isValid(2, 3, 3, 3,  King_test), true);
        assertEquals(King_test.board[2][3].isValid(2, 3, 1, 2,  King_test), true);
        assertEquals(King_test.board[2][3].isValid(2, 3, 4, 3,  King_test), false); //illegal move
        assertEquals(King_test.board[2][3].isValid(2, 3, 8, 3,  King_test), false); //out of bound
        assertEquals(King_test.board[2][3].isValid(2, 3, 4, 4,  King_test), false); //same color block
        assertEquals(King_test.board[2][3].isValid(2, 3, 2, 4,  King_test), true); //different color block


    }
}
