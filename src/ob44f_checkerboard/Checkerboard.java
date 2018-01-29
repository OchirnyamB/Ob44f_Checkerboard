/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ob44f_checkerboard;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author ob44f
 */
public class Checkerboard {
    
    private int numRows = 8;
    private int numCols = 8;
   
    private AnchorPane pane = null;
    private double boardWidth;
    private double boardHeight;
    private double rectWidth;
    private double rectHeight;
    
    private Color lightColor = null;
    private Color darkColor = null;
    
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight){
           this.numRows = numRows;
           this.numCols = numCols;
           this.boardWidth = boardWidth;
           this.boardHeight = boardHeight;
           this.lightColor = Color.RED;
           this.darkColor = Color.BLACK;
    }
    public Checkerboard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor){
           this(numRows, numCols, boardWidth, boardHeight);
           this.lightColor = Color.PLUM;
           this.darkColor = Color.PURPLE;
    }
    public void build(){
        
        AnchorPane buildPane = new AnchorPane();
        rectWidth = Math.ceil(boardWidth / numCols);
        rectHeight = Math.ceil(boardHeight / numRows);
        
        Rectangle rectangle = null;
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                rectangle = new Rectangle(rectWidth*col, rectHeight*row, rectWidth, rectHeight);
                if((row+col) % 2 == 0){
                    rectangle.setFill(lightColor);
                }else{
                    rectangle.setFill(darkColor);
                }
                buildPane.getChildren().add(rectangle);
            }
        }
        this.pane = buildPane;
    }
    public AnchorPane getBoard(){
        return this.pane;
    }
    public int getNumRows(){
        return this.numRows;
    }
    public int getNumCols(){
        return this.numCols;
    }
    public double getWidth(){
        return this.boardWidth;
    }
    public double getHeight(){
        return this.boardHeight;
    }
    public Color getLightColor(){
        return this.lightColor;
    }
    public Color getDarkColor(){
        return this.darkColor;
    }
    public double getRectangleWidth(){
        return this.rectWidth;
    }
    public double getRectangleHeight(){
        return this.rectHeight;
    }
}
