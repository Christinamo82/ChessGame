package Pieces;
import Game.*;
public class King extends Piece {
    /**
     * King class constructor
     * @param x the x_position of the king on the board
     * @param y the y_position of the king on the board
     * @param player_color the color of king
     * @param piece_type the type of chess piece (king)
     */
    public King(int x, int y, Color player_color, Type piece_type){
        super(x, y, player_color, piece_type);
    }

    /**
     * To check if the move is valid for King
     * @param x the current x_position of the king
     * @param y the current y_position of the king
     * @param move_x the new x_position of the king is moving to
     * @param move_y the new y_position of the king is moving to
     * @param board the 2d array board
     * @return boolean to check if the move for the king valid or not
     */
    public boolean isValid(int x, int y, int move_x, int move_y, Board board){
        int diff_x = move_x - x;
        int diff_y = move_y - y;
        Color current_color = board.board_position(x, y).getColor();
        boolean valid_check = false;

        if(diff_x == 0 && diff_y == 0){
            return false;
        }
        else if(diff_x == 1 && diff_y == 1){
            if(x + diff_x >= 8 || y + diff_y >= 8){
                return false;
            }
            return valid_check = isValid_helper((x + diff_x), (y + diff_y), current_color, board);
        }
        else if(diff_x == 1 && diff_y == -1){
            if(x + diff_x >= 8 || y + diff_y < 0){
                return false;
            }
            return valid_check = isValid_helper((x + diff_x), (y + diff_y), current_color, board);
        }
        else if(diff_x == 1 && diff_y == 0){
            if(x + diff_x >= 8){
                return false;
            }
            return valid_check = isValid_helper((x + diff_x), (y + diff_y), current_color, board);
        }
        else if(diff_x == 0 && diff_y == -1){
            if(y + diff_y < 0){
                return false;
            }
            return valid_check = isValid_helper((x + diff_x), (y + diff_y), current_color, board);
        }
        else if(diff_x == 0 && diff_y == 1){
            if(y + diff_y >= 8){
                return false;
            }
            return valid_check = isValid_helper((x + diff_x), (y + diff_y), current_color, board);
        }
        else if(diff_x == -1 && diff_y == 1){
            if(x + diff_x < 0 || y + diff_y >= 8){
                return false;
            }
            return valid_check = isValid_helper((x + diff_x), (y + diff_y), current_color, board);
        }
        else if (diff_x == -1 && diff_y == -1) {
            if(x + diff_x < 0 || y + diff_y < 0){
                return false;
            }
            return valid_check = isValid_helper((x + diff_x), (y + diff_y), current_color, board);
        }
        else if(diff_x == -1 && diff_y == 0){
            if(x + diff_x < 0 || y + diff_y < 0){
                return false;
            }
            return valid_check = isValid_helper((x + diff_x), (y + diff_y), current_color, board);
        }
        return valid_check;
    }

    /**
     * Helper function to check if the new position for king is moveable
     * @param x current x_position of the piece
     * @param y current y_position of the piece
     * @param color the color of the piece
     * @param board 2d array board
     * @return boolean if the new position piece is moving to has same color or different color piece blocking
     */

    private boolean isValid_helper(int x, int y, Color color, Board board){
        if(board.board[x][y] != null){
            if(board.board[x][y].getColor() == color){
                return false;
            }
        }
        return true;
    }
}
