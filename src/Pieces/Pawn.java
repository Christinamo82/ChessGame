package Pieces;
import Game.*;
public class Pawn extends Piece{
    /**
     * Pawn class constructor
     * @param x the x_position of the pawn on the board
     * @param y the y_position of the pawn on the board
     * @param player_color the color of pawn
     * @param piece_type the type of chess piece (pawn)
     */
    public Pawn(int x, int y, Color player_color, Type piece_type){
        super(x, y, player_color, piece_type);
    }

    @Override
    public boolean isValid(int x, int y, int move_x, int move_y, Board board) {
        int diff_x = move_x - x;
        int diff_y = move_y - y;
        Color player_color = board.board[x][y].getColor();
        if(player_color == Color.WHITE){
            if(x == 1){
                if(diff_x == 1 || diff_x == 2){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                if(diff_x == 1 && diff_y == 0 && board_check(x, y, diff_x, diff_y)){
                    return isValid_helper(x, y, 1, player_color, board);
                }
                else if(diff_y == 1 && diff_x == 1 && board_check(x, y, diff_x, diff_y)){
                    return isCapture_helper(x, y, 1, 1,  player_color, board);
                }
                else if(diff_y == -1 && diff_x == 1 && board_check(x, y, diff_x, diff_y)){
                    return isCapture_helper(x, y, -1, 1, player_color, board);
                }
                else{
                    return false;
                }
            }
        }
        else{
            if(x == 6){
                if(diff_x == -1 || diff_x == -2){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                if(diff_x == -1 && diff_y == 0 && board_check(x, y, diff_x, diff_y)){
                    return isValid_helper(x, y, -1, player_color, board);
                }
                else if(diff_y == -1 && diff_x == -1 && board_check(x, y, diff_x, diff_y)){
                    return isCapture_helper(x, y, -1, -1, player_color, board);
                }
                else if(diff_y == 1 && diff_x == -1 && board_check(x, y, diff_x, diff_y)){
                    return isCapture_helper(x, y, 1, -1, player_color, board);
                }
                else{
                    return false;
                }
            }

        }
        //return false;
    }

    private boolean board_check(int x, int y, int x_diff, int y_diff){
        if(x + x_diff >= 8){
            return false;
        }
        else if(y + y_diff >= 8){
            return false;
        }
        else if(x + x_diff < 0){
            return false;
        }
        else if(y + y_diff < 0){
            return false;
        }
        return true;
    }

    private boolean isValid_helper(int x, int y, int dir, Color color, Board board){
        if(board.board[x + (1 * dir)][y] != null){
            if(board.board[x + (1 * dir)][y].getColor() == color){
                return false;
            }
        }
        return true;
    }

    private boolean isCapture_helper(int x, int y, int x_dir, int y_dir, Color color, Board board){
        if(board.board[x + (1 * x_dir)][y + (1 * y_dir)]== null){
            return false;
        }
        if(board.board[x + (1 * x_dir)][y + (1 * y_dir)]!= null){
            if(board.board[x + (1 * x_dir)][y + (1 * y_dir)].getColor() == color){
                return false;
            }
        }
        return true;
    }
}


