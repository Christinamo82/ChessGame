package Game;

/**
 * @author cmo2
 */

public class Tile {
    public int x_coord;
    public int y_coord;
    public Color color;
    public Type type;


    /**
     * Constructor of the chess pieces on the board
     * Set chess piece's x_coordinate
     * Set chess piece's y_coordinate
     * Set chess piece's color
     * set chess piece's type
     */
    public Tile(int x, int y, Color player_color){
        this.x_coord = x;
        this.y_coord = y;
        this.color = player_color;
        this.type = null;
    }

    /**
     * get the chess piece's current x_position
     */
    private int getX_coord(){

        return this.x_coord;
    }

    /**
     * get the chess piece;s current y_position
     */
    private int getY_coord(){

        return this.y_coord;
    }

    /**
     * get the chess piece's color
     */
    private Color getColor(){

        return this.color;
    }

    /**
     * to get the chess piece's type
     */
    private Type getType(){

        return this.type;
    }
}

