package Tests;
import Game.Board;
import Game.Player;
import Game.Color;
import Game.Type;
import Pieces.*;
import static org.junit.Assert.*;
import org.junit.Test;
public class Board_Test {

    @Test
    public void testIsPlaced()
    {
        Board test_board = new Board();
        test_board.iniBoard();
        Piece piece = test_board.board[1][0];
        assertEquals(test_board.isPlaced(3, 0, piece), true);
    }

    @Test
    public void testCheck1()
    {
        Board test_board = new Board();
        for(int i = 0; i < 16; i++){
                test_board.player_white.player_pieces[i].setPosition(-1, -1);
                test_board.player_black.player_pieces[i].setPosition(-1, -1);
        }
        test_board.board[4][5] = new Rook(4, 5, Color.WHITE, Type.ROOK);
        test_board.board[7][7] = new King(5, 5, Color.WHITE, Type.KING);
        test_board.board[4][7] = new King(4, 7, Color.BLACK, Type.KING);

        test_board.player_white.player_pieces[12].setPosition(4, 5);
        test_board.player_white.player_pieces[8].setPosition(7, 7);
        test_board.player_black.player_pieces[12].setPosition(4, 7);
        assertEquals(test_board.checkMate(test_board.player_black), true);
    }

    @Test
    public void testCheck2()
    {
        Board test_board = new Board();
        for(int i = 0; i < 16; i++){
            test_board.player_white.player_pieces[i].setPosition(-1, -1);
            test_board.player_black.player_pieces[i].setPosition(-1, -1);
        }
        test_board.board[0][2] = new King(0, 2, Color.WHITE, Type.KING);
        test_board.board[1][6] = new Pawn(1, 6, Color.WHITE, Type.PAWN);
        test_board.board[3][7] = new Pawn(3, 7, Color.WHITE, Type.PAWN);
        test_board.board[4][4] = new Knight(4, 4, Color.WHITE, Type.KNIGHT);
        test_board.board[7][2] = new Queen(7, 2, Color.WHITE, Type.QUEEN);

        test_board.board[1][2] = new Rook(1, 2, Color.BLACK, Type.KING);
        test_board.board[2][2] = new Knight(2, 2, Color.BLACK, Type.KNIGHT);
        test_board.board[2][1] = new Bishop(2, 1, Color.BLACK, Type.BISHOP);
        test_board.board[6][6] = new King(6, 6, Color.BLACK, Type.KING);

        test_board.player_white.player_pieces[12].setPosition(0, 2);
        test_board.player_white.player_pieces[0].setPosition(1, 6);
        test_board.player_white.player_pieces[1].setPosition(3, 7);
        test_board.player_white.player_pieces[9].setPosition(4, 4);
        test_board.player_white.player_pieces[11].setPosition(7, 2);

        test_board.player_black.player_pieces[8].setPosition(1, 2);
        test_board.player_black.player_pieces[9].setPosition(2, 2);
        test_board.player_black.player_pieces[10].setPosition(2, 1);
        test_board.player_black.player_pieces[12].setPosition(6, 6);
        //System.out.println(test_board.checkMate(test_board.player_white));
        assertEquals(test_board.checkMate(test_board.player_white), true);
    }

    @Test
    public void testCheck3()
    {
        Board test_board = new Board();
        for(int i = 0; i < 16; i++){
            test_board.player_white.player_pieces[i].setPosition(-1, -1);
            test_board.player_black.player_pieces[i].setPosition(-1, -1);
        }
        test_board.board[4][5] = new Pawn(4, 5, Color.WHITE, Type.PAWN);
        test_board.board[7][7] = new King(5, 5, Color.BLACK, Type.KING);

        test_board.player_white.player_pieces[1].setPosition(4, 5);
        test_board.player_black.player_pieces[12].setPosition(7, 7);
        assertEquals(test_board.checkMate(test_board.player_black), false);
    }


}