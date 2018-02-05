package Pieces;
import Game.*;
public class Rook extends Piece {
    /**
     * Rook class constructor
     * @param x the x_position of the rook on the board
     * @param y the y_position of the rook on the board
     * @param player_color the color of rook
     * @param piece_type the type of chess piece (rook)
     */
    public Rook(int x, int y, Color player_color, Type piece_type){
        super(x, y, player_color, piece_type);
    }
    /**
     * To check if the move is valid for Rook
     * @param x the current x_position of the rook
     * @param y the current y_position of the rook
     * @param move_x the new x_position of the rook is moving to
     * @param move_y the new y_position of the rook is moving to
     * @param board the 2d array board
     * @return boolean to check if the move for the rook valid or not
     */
    @Override
    public boolean isValid(int x, int y, int move_x, int move_y, Board board) {
        int diff_x = move_x - x;
        int diff_y = move_y - y;
        Color current_color = board.board_position(x, y).getColor();

        if(move_x >= 8 || move_x < 0 || move_y >=8 || move_y < 0){
            return false;
        }
        else if (diff_x == 0 && diff_y == 0) {
            return false;
        }
        else if(diff_x == 0 && diff_y > 0){
            return isValid_helper(x, y, diff_y, 0, 1, current_color, board);
        }
        else if(diff_x == 0 && diff_y < 0){
            return isValid_helper(x, y, diff_y, 0, -1, current_color, board);
        }
        else if(diff_x > 0 && diff_y == 0){
            return isValid_helper(x, y, diff_x, 1, 0, current_color, board);
        }
        else if(diff_x < 0 && diff_y == 0){
            return isValid_helper(x, y, diff_x, -1, 0, current_color, board);
        }
        return false;
    }

    /**
     * helper function to check if the new position is out of bound
     * @param x the current x_position of the piece
     * @param y the current y_position of the piece
     * @param x_diff difference between current x_postion and new x_position
     * @param y_diff difference between current y_position and new y_position
     * @return boolean to check if the piece is out of bound
     */


    /**
     * Helper function to check if the new position for rook is moveable
     * @param x current x_position of the piece
     * @param y current y_position of the piece
     * @param steps how many steps for the pice moving to the new position
     * @param x_dir the direction of x_position the piece is moving to
     * @param y_dir the direction of y_position the piece is moviong to
     * @param color the color of the piece
     * @param board 2d array board
     * @return boolean if the new position piece is moving to has same color or different color piece blocking
     */

    private boolean isValid_helper(int x, int y, int steps, int x_dir, int y_dir, Color color, Board board){
        steps = Math.abs(steps);
        for(int i = 1; i <= steps; i ++){
            if(board.board[x + (x_dir * i)][y + (y_dir * i)] != null){
                if(board.board[x + (x_dir * i)][y + (y_dir * i)].getColor() == color){
                    return false;
                }
            }
        }
        return true;
    }


}
