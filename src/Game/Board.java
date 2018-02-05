package Game;
import Pieces.*;
/**
 * To create 8x8 chess board
 * @author cmo2
 */

public class Board {
    public final int row = 8;
    public final int col = 8;
    public Piece[][] board;

    public Player player_white;
    public Player player_black;
    int turn = -1;
    int check = -1;

    /**
     * Constructor of the Board class
     * Make an empty board
     */
    public Board(){
        board = new Piece[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                board[i][j] = null;
            }
        }
        player_white = new Player(Color.WHITE, 0);
        player_black = new Player(Color.BLACK, 1);

    }

    /**
     * get current board position's piece
     */
    public Piece board_position(int x, int y){

        return this.board[x][y];
    }
    public void iniBoard(){

        for(int i = 0; i < row; i++){
            board[1][i] = new Pawn(1, i, Color.WHITE, Type.PAWN);
            board[6][i] = new Pawn(6, i, Color.BLACK, Type.PAWN);
        }
        board[0][0] = new Rook(0, 0, Color.WHITE, Type.ROOK);
        board[0][1] = new Knight(0, 1, Color.WHITE, Type.KNIGHT);
        board[0][2] = new Bishop(0, 2, Color.WHITE, Type.BISHOP);
        board[0][3] = new Queen(0, 3, Color.WHITE, Type.QUEEN);
        board[0][4] = new King(0, 4, Color.WHITE, Type.KING);
        board[0][5] = new Bishop(0, 5, Color.WHITE, Type.BISHOP);
        board[0][6] = new Knight(0, 6, Color.WHITE, Type.KNIGHT);
        board[0][7] = new Rook(0, 7, Color.WHITE, Type.ROOK);

        board[7][0] = new Rook(7, 0, Color.BLACK, Type.ROOK);
        board[7][1] = new Knight(7, 1, Color.BLACK, Type.KNIGHT);
        board[7][2] = new Bishop(7, 2, Color.BLACK, Type.BISHOP);
        board[7][3] = new Queen(7, 3, Color.BLACK, Type.QUEEN);
        board[7][4] = new King(7, 4, Color.BLACK, Type.KING);
        board[7][5] = new Bishop(7, 5, Color.BLACK, Type.BISHOP);
        board[7][6] = new Knight(7, 6, Color.BLACK, Type.KNIGHT);
        board[7][7] = new Rook(7, 7, Color.BLACK, Type.ROOK);

/*       for(int i = 0; i < 8; i++){
            board[i][1] = new Pawn(i, 1, Color.WHITE, Type.PAWN);
            board[i][6] = new Pawn(i, 6, Color.BLACK, Type.PAWN);
        }
        board[0][0] = new Rook(0, 0, Color.WHITE, Type.ROOK);
        board[1][0] = new Knight(1, 0, Color.WHITE, Type.KNIGHT);
        board[2][0] = new Bishop(2, 0, Color.WHITE, Type.BISHOP);
        board[3][0] = new Queen(3, 0, Color.WHITE, Type.QUEEN);
        board[4][0] = new King(4, 0, Color.WHITE, Type.KING);
        board[5][0] = new Bishop(5, 0, Color.WHITE, Type.BISHOP);
        board[6][0] = new Knight(6, 0, Color.WHITE, Type.KNIGHT);
        board[7][0] = new Rook(7, 0, Color.WHITE, Type.ROOK);

        board[0][7] = new Rook(0, 7, Color.BLACK, Type.ROOK);
        board[1][7] = new Knight(1, 7, Color.BLACK, Type.KNIGHT);
        board[2][7] = new Bishop(2, 7, Color.BLACK, Type.BISHOP);
        board[3][7] = new Queen(3, 7, Color.BLACK, Type.QUEEN);
        board[4][7] = new King(4, 7, Color.BLACK, Type.KING);
        board[5][7] = new Bishop(5, 7, Color.BLACK, Type.BISHOP);
        board[6][7] = new Knight(6, 7, Color.BLACK, Type.KNIGHT);
        board[7][7] = new Rook(7, 7, Color.BLACK, Type.ROOK);*/
    }

    /**
     * Function to check if the new position is valid to move, if valid to move to the new position set the piece's
     * new x and y position on the board. If the new position has enemy, set the enemy piece out of board(-1) and
     * place the current piece to the new position.
     * @param new_x the new x_postion where the piece is moving to
     * @param new_y the new y_position where the piece is moving to
     * @param piece the piece type which is moving to the place
     * @return boolean if the piece can move to the new position on the board
     */
    public boolean isPlaced(int new_x, int new_y, Piece piece){
        int current_x = piece.getX_coord();
        int current_y = piece.getX_coord();
        Color piece_color = piece.getColor();
        Boolean validMove_check = false;

        if(new_x < 0 || new_y < 0 || new_x >= 8 || new_y >= 8){
            return false;
        }
        if(board[new_x][new_y] == null){
            validMove_check = piece.isValid(current_x, current_y, new_x, new_y, this);
            System.out.println(piece.isValid(current_x, current_y, new_x, new_y, this));
            if(validMove_check == true){
                board[new_x][new_y] = piece;
                piece.setPosition(new_x, new_y);
                board[current_x][current_y] = null;
                return true;
            }
            else{
                return false;
            }
        }
        else{
            if(board[new_x][new_y].getColor() != piece_color){
                validMove_check = piece.isValid(current_x, current_y, new_x, new_y, this);
                if(validMove_check == true){
                    board[new_x][new_y].setPosition(-1, -1);
                    board[new_x][new_y] = piece;
                    piece.setPosition(new_x, new_y);
                    board[current_x][current_y] = null;
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        //return true;
    }

    /**
     * Function to check if current player is in stale mate which current player is not in check and
     * do not have any valid move
     * @param player current player
     * @return Boolean if the current player is in stale mate
     */

    public Boolean staleMate(Player player){
        if(checkMate(player) == true){
            return false;
        }

        for(int i = 0; i < player.getPlayer_pieces().length; i++){
            Piece current_piece = player.getPlayer_pieces()[i];
            if(current_piece.getX_coord() != -1 && current_piece.getY_coord() != -1){
                int current_x = current_piece.getX_coord();
                int current_y = current_piece.getY_coord();
                for(int j = 0; j < row; j++){
                    for(int k = 0; k < col; k++){
                        int x = -1;
                        int y = -1;
                        if(board[j][k] == null || board[x][y].getColor() != player.getColor()){
                            x = j;
                            y = k;
                            if(current_piece.isValid(current_x, current_y, x, y, this) == true){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Function to check if the current player is in check
     * @param player current player
     * @return Boolean if the current player in in check
     */

    public Boolean checkMate(Player player){
        int king_x = -1;
        int king_y = -1;
        if(player.getPlayer() == 0){
            king_x = player_white.getPlayer_pieces()[12].getX_coord();
            king_y = player_white.getPlayer_pieces()[12].getY_coord();
            player = getOtherPlayer(0);
        }
        else if(player.getPlayer() == 1){
            king_x = player_black.getPlayer_pieces()[12].getX_coord();
            king_y = player_black.getPlayer_pieces()[12].getY_coord();
            player = getOtherPlayer(1);
        }
        for(int i = 0; i < player.getPlayer_pieces().length; i++) {
            Piece current_piece = player.getPlayer_pieces()[i];
            if (current_piece.getX_coord() != -1 || current_piece.getY_coord() != -1) {
                int current_x = player.getPlayer_pieces()[i].getX_coord();
                int current_y = player.getPlayer_pieces()[i].getY_coord();
                if (current_piece.isValid(current_x, current_y, king_x, king_y, this)) {
                    return true;
                }
            }
            //return false;
        }
        return false;
    }

    public int Lose_Check(Player player){
        int king_x = player.getPlayer_pieces()[12].getX_coord();
        int king_y = player.getPlayer_pieces()[12].getY_coord();
        if(king_x == -1 && king_y == -1){
            return player.getPlayer();
        }
        return -1;
    }

    public int getCurrentPlayer(int turn){
        if(turn == 0){
            return 0;
        }
        else{
            return 1;
        }
    }

    public Player getOtherPlayer(int turn){
        if(turn == 0){
            return player_black;
        }
        else{
            return player_white;
        }
    }
}

