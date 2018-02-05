package Game;
import Pieces.*;
public class Chess {
    public Board chess_board;
    public Player first_player;
    public Player second_player;




    public Chess(){
        this.chess_board = new Board();
        this.first_player = new Player(Color.WHITE, 0);
        this.second_player = new Player(Color.BLACK, 1);
        //initial();

    }
/*
    public void initial(){
        initial_helper(first_player);
        initial_helper(second_player);
    }
 */
/*
    public void initial_helper(Player player){
        int turn = player.getPlayer();
        if(turn == 0){
            for(int i = 0; i < 8; i++){
                chess_board.board[i][0] = new Pawn(i, 1, Color.WHITE, Type.PAWN);
            }
            chess_board.board[0][0] = new Rook(0, 0, Color.WHITE, Type.ROOK);
            chess_board.board[1][0] = new Knight(1, 0, Color.WHITE, Type.KNIGHT);
            chess_board.board[2][0] = new Bishop(2, 0, Color.WHITE, Type.BISHOP);
            chess_board.board[3][0] = new Queen(3, 0, Color.WHITE, Type.QUEEN);
            chess_board.board[4][0] = new King(4, 0, Color.WHITE, Type.KING);
            chess_board.board[5][0] = new Bishop(5, 0, Color.WHITE, Type.BISHOP);
            chess_board.board[6][0] = new Knight(6, 0, Color.WHITE, Type.KNIGHT);
            chess_board.board[7][0] = new Rook(7, 0, Color.WHITE, Type.ROOK);
        }
        else if(turn == 1){
            for(int i = 0; i < 8; i++){
                chess_board.board[i][6] = new Pawn(i, 6, Color.BLACK, Type.PAWN);
            }
            chess_board.board[0][7] = new Rook(0, 7, Color.BLACK, Type.ROOK);
            chess_board.board[1][7] = new Knight(1, 7, Color.BLACK, Type.KNIGHT);
            chess_board.board[2][7] = new Bishop(2, 7, Color.BLACK, Type.BISHOP);
            chess_board.board[3][7] = new Queen(3, 7, Color.BLACK, Type.QUEEN);
            chess_board.board[4][7] = new King(4, 7, Color.BLACK, Type.KING);
            chess_board.board[5][7] = new Bishop(5, 7, Color.BLACK, Type.BISHOP);
            chess_board.board[6][7] = new Knight(6, 7, Color.BLACK, Type.KNIGHT);
            chess_board.board[7][7] = new Rook(7, 7, Color.BLACK, Type.ROOK);
        }

    }
*/
}
