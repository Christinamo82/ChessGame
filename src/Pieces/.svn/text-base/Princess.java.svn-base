package Pieces;
import Game.*;
public class Princess extends Piece {
    /**
     * Princess class constructor
     * @param x the x_position of the Princess on the board
     * @param y the y_position of the Princess on the board
     * @param player_color the color of Princess
     * @param piece_type the type of chess piece (Princess)
     */

    public Princess(int x, int y, Color player_color, Type piece_type) {
        super(x, y, player_color, piece_type);

    }

    /**
     * To check if the move is valid for Princess
     * @param x the current x_position of the Princess
     * @param y the current y_position of the Princess
     * @param move_x the new x_position of the Princess is moving to
     * @param move_y the new y_position of the Princess is moving to
     * @param board the 2d array board
     * @return boolean to check if the move for the Princess valid or not
     */

    @Override
    public boolean isValid(int x, int y, int move_x, int move_y, Board board) {
        Color color = this.getColor();
        Piece bishop = new Bishop(x, y, color, Type.BISHOP);
        Piece knight = new Knight(x, y, color, Type.KNIGHT);
        if(bishop.isValid(x, y, move_x, move_y, board) == true || knight.isValid(x, y, move_x, move_y, board) == true){
            return true;
        }
        return false;
    }
}
