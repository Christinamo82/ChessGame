package Tests;
import Game.*;
import Pieces.*;
import static org.junit.Assert.*;
import org.junit.Test;
public class Rook_Test {
    @Test
    public void RookMoveValid(){
        Board Rook_test = new Board();
        Rook_test.board[6][6] = new Rook(6, 6, Color.WHITE, Type.ROOK);
        Rook_test.board[1][6] = new Queen(1, 6, Color.WHITE, Type.QUEEN);
        Rook_test.board[3][6] = new Queen(3, 6, Color.BLACK, Type.QUEEN);
        assertEquals(Rook_test.board[6][6].isValid(6, 6, 6, 1,  Rook_test), true);
        assertEquals(Rook_test.board[6][6].isValid(6, 6, 2, 6,  Rook_test), true);
        assertEquals(Rook_test.board[6][6].isValid(6, 6, 3, 1,  Rook_test), false); //illegal move
        assertEquals(Rook_test.board[6][6].isValid(6, 6, 8, 6,  Rook_test), false); //out of bound
        assertEquals(Rook_test.board[6][6].isValid(6, 6, 1, 6,  Rook_test), false); //same color block
        assertEquals(Rook_test.board[6][6].isValid(6, 6, 3, 6,  Rook_test), true); //different color block


    }

}


