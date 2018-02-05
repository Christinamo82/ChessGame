package Game;
import Pieces.*;
import java.util.*;

public class Player {
    public Color color;
    public int player;
    public Board board;
    //public List<Piece> player_pieces = new ArrayList<>();
    public Piece [] player_pieces;

    /**
     * Constructor of Player class
     * @param player_color the color for player's pieces
     * @param player_turn 0 = player 1(white), 1 = player 2 (black)
     */
    public Player(Color player_color, int player_turn){
        this.color = player_color;
        this.player = player_turn;
        this.player_pieces = SetPieces(player_color, player_turn);
        //this.player_pieces = SetPieces(player_color, player_turn);
    }

    /**
     * Set player pieces into the list
     * @param color Piece color (player = 0(white), player = 1(black))
     * @param current_player which player going first
     * @return The list of current_player's pieces
     */

    public Piece[] SetPieces(Color color, int current_player){
        player_pieces = new Piece[16];
        if(current_player == 0){
            for(int i = 0; i < 8; i++){
                player_pieces[i] = new Pawn(i, 1, color, Type.PAWN);
            }
            player_pieces[8] = new Rook(0, 0, color, Type.ROOK);
            player_pieces[9] = new Knight(1, 0, color, Type.KNIGHT);
            player_pieces[10] = new Bishop(2, 0, color, Type.BISHOP);
            player_pieces[11] = new Queen(3, 0, color, Type.QUEEN);
            player_pieces[12] = new King(4, 0, color, Type.KING);
            player_pieces[13] = new Bishop(5, 0, color, Type.BISHOP);
            player_pieces[14] = new Knight(6, 0, color, Type.KNIGHT);
            player_pieces[15] = new Rook(7, 0, color, Type.ROOK);
        }
        else if(current_player == 1){
            for(int i = 0; i < 8; i++){
                player_pieces[i] = new Pawn(i, 6, color, Type.PAWN);
            }
            player_pieces[8] = new Rook(0, 7, color, Type.ROOK);
            player_pieces[9] = new Knight(1, 7, color, Type.KNIGHT);
            player_pieces[10] = new Bishop(2, 7, color, Type.BISHOP);
            player_pieces[11] = new Queen(3, 7, color, Type.QUEEN);
            player_pieces[12] = new King(4, 7, color, Type.KING);
            player_pieces[13] = new Bishop(5, 7, color, Type.BISHOP);
            player_pieces[14] = new Knight(6, 7, color, Type.KNIGHT);
            player_pieces[15] = new Rook(7, 7, color, Type.ROOK);
        }
        return player_pieces;
    }


    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player){
        this.player = player;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Piece[] getPlayer_pieces(){
        return player_pieces;
    }



}
