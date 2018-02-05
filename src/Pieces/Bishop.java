package Pieces;
import Game.*;
public class Bishop extends Piece {

    /**
     * Rook class constructor
     * @param x the x_position of the bishop on the board
     * @param y the y_position of the bishop on the board
     * @param player_color the color of bishop
     * @param piece_type the type of chess piece (bishop)
     */

    public Bishop(int x, int y, Color player_color, Type piece_type) {
        super(x, y, player_color, piece_type);

    }

    /**
     * To check if the move is valid for Bishop
     * @param x the current x_position of the bishop
     * @param y the current y_position of the bishop
     * @param move_x the new x_position of the bishop is moving to
     * @param move_y the new y_position of the bishop is moving to
     * @param board the 2d array board
     * @return boolean to check if the move for the bishop valid or not
     */

    @Override
    public boolean isValid(int x, int y, int move_x, int move_y, Board board) {
        int diff_x = move_x - x;
        int diff_y = move_y - y;
        Color current_color = board.board_position(x, y).getColor();

        if(move_x >= 8 || move_x < 0 || move_y >=8 || move_y < 0){
            return false;
        }
        else if ((diff_x == 0 && diff_y == 0) || diff_x == 0 || diff_y == 0 || Math.abs(diff_x) != Math.abs(diff_y)) {
            return false;
        }
        else if (diff_x > 0 && diff_y > 0) {
            return isValid_helper(x, y, diff_x, 1, 1, current_color, board);
        }
        else if(diff_x > 0 && diff_y < 0){
            return isValid_helper(x, y, diff_x, 1, -1, current_color, board);
        }
        else if(diff_x < 0 && diff_y > 0){
            return isValid_helper(x, y, diff_x, -1, 1, current_color, board);
        }
        else if(diff_x < 0 && diff_y < 0){
            return isValid_helper(x, y, diff_x, -1, -1, current_color, board);
        }
        return false;
    }


    /**
     * Helper function to check if the new position for bishop is moveable
     * @param x current x_position of the piece
     * @param y current y_position of the piece
     * @param steps how many steps for the pice moving to the new position
     * @param x_dir the direction of x_position the piece is moving to
     * @param y_dir the direction of y_position the piece is moviong to
     * @param color the color of the piece
     * @param board 2d array board
     * @return boolean if the new position piece is moving to has same color or different color piece blocking
     */

    private boolean isValid_helper(int x, int y, int steps, int x_dir, int y_dir, Color color, Board board) {
        steps = Math.abs(steps);
        for(int i = 1; i <= steps; i++){
            if(board.board[x + (x_dir * i)][y + (y_dir * i)] != null){
                if(board.board[x + (x_dir * i)][y + (y_dir * i)].getColor() == color)
                    return false;
            }
        }
        return true;
    }
}
