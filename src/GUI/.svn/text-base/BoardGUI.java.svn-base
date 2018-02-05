package GUI;
import Pieces.*;
import Game.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.io.File;

/*get the idea from 242 class website and source
http://forgetcode.com/Java/848-Chess-game-Swing
https://github.com/pwy0424/cs242/blob/master/Assignment1.1/src/gameInterface/GameView.java
 */

public class BoardGUI{
    private Board chess_board;
    private JPanel board_view;


    public static void main(String[] args){
        Board game_board = new Board();
        game_board.iniBoard();
        new BoardGUI(game_board);
    }

    public BoardGUI(Board board){
        board_view = initializePanel();
        board_view.setLayout(new GridLayout(8,8)); //gridlayout has same size of in row and cols
        JFrame window = new JFrame("Chess");
        addPiece(board, board_view);
        window.setSize(500, 500);
        window.setContentPane(board_view);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel initializePanel() {
        JPanel myPanel = new JPanel();
        myPanel.setPreferredSize(new Dimension(500,500));
        //myPanel.setLayout(new BorderLayout());
        return myPanel;
    }

    /**
     * Function to figure out the current position's chess type and chess color
     * @param board a 8x8 chess board
     * @param panel a 8x8 grid layout
     */
    private void addPiece(Board board, JPanel panel){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                Piece current_piece = board.board[i][j];
                if(current_piece == null) {
                    String filename = "";
                    if ((i + j) % 2 == 0) {
                        filename += "Images/white.png";
                    } else {
                        filename += "Images/black2.png";
                    }
                    addPiece_helper(filename);
                }
                else {
                    if (current_piece.getColor().equals(Game.Color.WHITE)) {
                        addWhitePiece(current_piece, panel, i, j);
                    } else if (current_piece.getColor().equals(Game.Color.BLACK)) {
                        addBlackPiece(current_piece, panel, i, j);
                    }
                }
            }
        }
    }

    /**
     * To find the piece picture's path for each white chess pieces
     * @param piece Current piece type in the board position, if null just create a empty button
     * @param panel a 8x8 grid layout panel
     * @param i current x position
     * @param j current y position
     */

    private void addWhitePiece(Piece piece, JPanel panel, int i, int j){
        String filename = "";
        if(piece.getType().equals(Type.PAWN)){
            filename = "Images/w_pawn.png";
            addPiece_helper(filename);
        }
        else if(piece.getType().equals(Type.ROOK)){
            filename = "Images/w_rook.png";
            addPiece_helper(filename);
        }
        else if(piece.getType().equals(Type.KNIGHT)){
            filename = "Images/w_knight.png";
            addPiece_helper(filename);
        }
        else if(piece.getType().equals(Type.BISHOP)){
            filename = "Images/w_bishop.png";
            addPiece_helper(filename);
        }
        else if(piece.getType().equals(Type.QUEEN)){
            filename = "Images/w_queen.png";
            addPiece_helper(filename);
        }
        else if(piece.getType().equals(Type.KING)){
            filename = "Images/w_king.png";
            addPiece_helper(filename);
        }
    }

    /**
     * To find the piece picture's path for each black chess pieces
     * @param piece Current piece type in the board position, if null just create a empty button
     * @param panel a 8x8 grid layout panel
     * @param i current x position
     * @param j current y position
     */
    private void addBlackPiece(Piece piece, JPanel panel, int i, int j){
        String filename = "";
        if(piece.getType().equals(Type.PAWN)){
            filename = "Images/b_pawn.png";
            addPiece_helper(filename);
        }
        else if(piece.getType().equals(Type.ROOK)){
            filename = "Images/b_rook.png";
            addPiece_helper(filename);
        }
        else if(piece.getType().equals(Type.KNIGHT)){
            filename = "Images/b_knight.png";
            addPiece_helper(filename);
        }
        else if(piece.getType().equals(Type.BISHOP)){
            filename = "Images/b_bishop.png";
            addPiece_helper(filename);
        }
        else if(piece.getType().equals(Type.QUEEN)){
            filename = "Images/b_queen.png";
            addPiece_helper(filename);
        }
        else if(piece.getType().equals(Type.KING)){
            filename = "Images/b_king.png";
            addPiece_helper(filename);
        }
    }
/*
    private void addPiece(Piece piece, JPanel panel, int i, int j){
        if(piece != null) {
            System.out.println(piece.getColor().equals(Game.Color.WHITE));
        }
        String filename = "Images/";
            if(i == 1 && (j == 0 || j == 1 || j == 2 || j == 3 || j == 4 || j == 5 || j == 6 || j == 7)) {
                filename += "w_pawn.png";
                addPiece_helper(filename,i , j);
            }

            else if(i == 6 && (j == 0 || j == 1 || j == 2 || j == 3 || j == 4 || j == 5 || j == 6 || j == 7)){
                filename += "b_pawn.png";
                addPiece_helper(filename, i, j);
            }
            else if(i == 0 && (j == 0 || j == 7)){
                filename += "w_rook.png";
                addPiece_helper(filename, i, j);
            }
            else if(i == 0 && (j == 1 || j == 6)){
                filename += "w_knight.png";
                addPiece_helper(filename, i, j);
            }
            else if(i == 0 && (j == 2 || j == 5)){
                filename += "w_bishop.png";
                addPiece_helper(filename, i, j);
            }
            else if(i == 0 && j == 3){
                filename += "w_queen.png";
                addPiece_helper(filename, i, j);
            }
            else if(i == 0 && j == 4){
                filename += "w_king.png";
                addPiece_helper(filename, i, j);
            }
            else if(i == 7 && (j == 0 || j == 7)){
                filename += "b_rook.png";
                addPiece_helper(filename, i, j);
            }
            else if(i == 7 && (j == 1 || j == 6)){
                filename += "b_knight.png";
                addPiece_helper(filename, i, j);
            }
            else if(i == 7 && (j == 2 || j == 5)){
                filename += "b_bishop.png";
                addPiece_helper(filename, i, j);
            }
            else if(i == 7 && j == 3){
                filename += "b_queen.png";
                addPiece_helper(filename, i, j);
            }
            else if(i == 7 && j == 4){
                filename += "/b_king.png";
                addPiece_helper(filename, i, j);
            }
            else{
                if((i + j) % 2 == 0){
                    filename += "white.png";
                }
                else{
                    filename += "black2.png";
                }
                addPiece_helper(filename, i, j);
            }
    }*/


    private void addPiece_helper(String img_file){
        ImageIcon img;
        JButton img_button;
        img = new ImageIcon(getClass().getResource(img_file));
        img_button = new JButton(img);
        board_view.add(img_button);
    }


}
