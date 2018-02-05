package Pieces;
import Game.*;
public class Empress extends Piece {

    /**
     * Empress class constructor
     * @param x the x_position of the Empress on the board
     * @param y the y_position of the Empress on the board
     * @param player_color the color of Empress
     * @param piece_type the type of chess piece (Empress)
     */

    public Empress(int x, int y, Color player_color, Type piece_type) {
        super(x, y, player_color, piece_type);

    }

    /**
     * To check if the move is valid for Empress
     * @param x the current x_position of the Empress
     * @param y the current y_position of the Empress
     * @param move_x the new x_position of the Empress is moving to
     * @param move_y the new y_position of the Empress is moving to
     * @param board the 2d array board
     * @return boolean to check if the move for the Empress valid or not
     */

    @Override
    public boolean isValid(int x, int y, int move_x, int move_y, Board board) {
        Color color = this.getColor();
        Piece rook = new Bishop(x, y, color, Type.ROOK);
        Piece knight = new Knight(x, y, color, Type.KNIGHT);
        if(rook.isValid(x, y, move_x, move_y, board) == true || knight.isValid(x, y, move_x, move_y, board) == true){
            return true;
        }
        return false;
    }
}
