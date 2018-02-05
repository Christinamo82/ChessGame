package Pieces;
import Game.*;
abstract public class Piece {
    /**
     * Constructor of piece class
     * x-coord is the x position on the board of the chess piece
     * y_coord is the y position on the board of the chess piece
     * color is the player's chess piece color
     * type is the chess piece's type
     */

    private int x_coord;
    private int y_coord;
    private Color color;
    private Type type;

    public Piece(int x, int y, Color player_color, Type piece_type){
        this.x_coord = x;
        this.y_coord = y;
        this.color = player_color;
        this.type = piece_type;
    }

    /**
     * Set the chess piece on the given x-position on the board
     */
    public void setX_coord(int x){

        this.x_coord = x;
    }

    /**
     *  Get the chess piece's x-position
     */
    public int getX_coord(){
        return x_coord;
    }
    /**
     * Set the chess piece on the given y-position on the board
     */
    public void setY_coord(int y){
        this.y_coord = y;
    }
    /**
     *  Get the chess piece's y-position
     */
    public int getY_coord(){
        return y_coord;
    }
    /**
     * Set the chess piece's color
     */
    public void setColor(Color player_color){
        this.color = player_color;
    }
    /**
     *  Get the chess piece's color
     */
    public Color getColor(){
        return color;
    }
    /**
     * Set the chess piece's type
     */
    public void setType(Type piece_type){
        this.type = piece_type;
    }
    /**
     *  Get the chess piece's type
     */
    public Type getType(){
        return type;
    }


    public void setPosition(int x, int y){
        this.x_coord = x;
        this.y_coord = y;
    }
    abstract public boolean isValid(int x, int y, int move_x, int move_y, Board board);
    /*abstract public boolean isValid(int x, int y, Board board);*/
}
