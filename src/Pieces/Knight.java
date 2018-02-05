package Pieces;
import Game.*;
public class Knight extends Piece {

    /**
     * Knight class constructor
     * @param x the x_position of the knight on the board
     * @param y the y_position of the knight on the board
     * @param player_color the color of knight
     * @param piece_type the type of chess piece (knight)
     */
    public Knight(int x, int y, Color player_color, Type piece_type){
        super(x, y, player_color, piece_type);
    }

    /**
     * To check if the move is valid for knight
     * @param x the current x_position of the knight
     * @param y the current y_position of the knight
     * @param move_x the new x_position of the knight is moving to
     * @param move_y the new y_position of the knight is moving to
     * @param board the 2d array board
     * @return boolean to check if the move for the knight valid or not
     */
    @Override
    public boolean isValid(int x, int y, int move_x, int move_y, Board board){
        int diff_x = move_x - x;
        int diff_y = move_y - y;
        Color current_color = board.board_position(x, y).getColor();

        if(move_x >= 8 || move_x < 0 || move_y >=8 || move_y < 0){
            return false;
        }
        else if(diff_x == 0 && diff_y == 0){
            return false;
        }
        else if((diff_x == 2 && diff_y == 1) || (diff_x == 1 && diff_y == 2)){
            return isValid_helper(x, y, diff_x, diff_y, 1, 1, current_color, board);
        }
        else if((diff_x == 2 && diff_y == -1) || (diff_x == 1 && diff_y == -2)){
            return isValid_helper(x, y, diff_x, diff_y, 1, -1, current_color, board);

        }
        else if((diff_x == -1 && diff_y == 2) || (diff_x == -2 && diff_y == 1)){
            return isValid_helper(x, y, diff_x, diff_y, -1, 1, current_color, board);

        }
        else if((diff_x == -1 && diff_y == -2) || (diff_x == -2 && diff_y == -1)){
            return isValid_helper(x, y, diff_x, diff_y, -1, -1, current_color, board);

        }

        return false;
    }

    /**
     * Helper function to check if the new position for knight is moveable
     * @param x current x_position of the piece
     * @param y current y_position of the piece
     * @param x_dir the direction of x_position the piece is moving to
     * @param y_dir the direction of y_position the piece is moviong to
     * @param color the color of the piece
     * @param board 2d array board
     * @return boolean if the new position piece is moving to has same color or different color piece blocking
     */

    private boolean isValid_helper(int x, int y, int x_steps, int y_steps, int x_dir, int y_dir, Color color, Board board){
        x_steps = Math.abs(x_steps);
        y_steps = Math.abs(y_steps);

        for(int i = 1; i <= x_steps; i++){
            if (board.board[x + (x_dir * i)][y] != null) {
                if(board.board[x + (x_dir * i)][y].getColor() == color){
                    return false;
                }
            }
            else{
                for(int j = 1; j <= y_steps; j++){
                    if(board.board[x + x_steps][y + (y_dir * j)] != null){
                        if(board.board[(x + x_steps) * x_dir][y + (y_dir * j)].getColor() == color){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
