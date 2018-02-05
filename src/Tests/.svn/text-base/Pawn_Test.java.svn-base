package Tests;
import Game.*;
import Pieces.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Pawn_Test {

    @Test
    public void White_PawnMoveValid(){
        Board test = new Board();
        test.board[6][5] = new Pawn(6, 5, Color.BLACK, Type.PAWN);
        test.board[4][6] = new Pawn(4,6, Color.BLACK, Type.PAWN);
        test.board[7][3] = new Queen(7, 3, Color.BLACK, Type.QUEEN);
        test.board[3][5] = new Queen(3, 5, Color.WHITE, Type.QUEEN);
        assertEquals(test.board[6][5].isValid(6, 5, 5, 5, test), true);
        assertEquals(test.board[6][5].isValid(6, 5, 4, 5, test), true);
        assertEquals(test.board[6][5].isValid(6, 5, 2, 3, test), false); //illegal move
        assertEquals(test.board[6][5].isValid(6, 5, 10, -1,  test), false); //out of bound
        assertEquals(test.board[4][6].isValid(4, 6, 3, 7, test), false); //same color block
        assertEquals(test.board[4][6].isValid(4, 6, 3, 5, test), true); //different color block

    }

    @Test
    public void Black_PawnMoveValid(){
        Board test = new Board();
        test.board[1][2] = new Pawn(1, 2, Color.WHITE, Type.PAWN);
        test.board[4][2] = new Pawn(4,2, Color.WHITE, Type.PAWN);
        test.board[5][1] = new Queen(5, 1, Color.WHITE, Type.QUEEN);
        test.board[5][3] = new Queen(5, 3, Color.BLACK, Type.QUEEN);
        assertEquals(test.board[1][2].isValid(1, 2, 2, 2, test), true);
        assertEquals(test.board[1][2].isValid(1, 2, 3, 2, test), true);
        assertEquals(test.board[1][2].isValid(1, 2, 5, 5, test), false); //illegal move
        assertEquals(test.board[1][2].isValid(1, 2, -1, 10,  test), false); //out of bound
        assertEquals(test.board[4][2].isValid(4, 2, 5, 1, test), false); //same color block
        assertEquals(test.board[4][2].isValid(4, 2, 5, 3, test), true); //different color block

    }
}
