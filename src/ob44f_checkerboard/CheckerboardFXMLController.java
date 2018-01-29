/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ob44f_checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author ob44f
 */
public class CheckerboardFXMLController implements Initializable, Startable {
    
    @FXML
    private AnchorPane anchorPane;
    
//    @FXML 
//    private MenuBar gridMenu;
//    @FXML
//    private MenuItem size1;
//    @FXML
//    private MenuItem size2;
//    @FXML
//    private MenuItem size3;
//    @FXML
//    private MenuItem size4;
       
       
    private Stage stage;
    
    private int numRows = 8;
    private int numCols = 8;
    
    private double boardWidth;
    private double boardHeight;
    private double rectWidth;
    private double rectHeight;
    private boolean color = false;
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void start(Stage stage){
        this.stage = stage;

        ChangeListener<Number> stageSizeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            buildBoard();      
        };
        this.stage.widthProperty().addListener(stageSizeListener);
        this.stage.heightProperty().addListener(stageSizeListener);
        buildBoard();
    }
    private void buildBoard(){
        clearBoard();
        System.out.println("cleared");
        boardWidth = anchorPane.getWidth();
        boardHeight = anchorPane.getHeight();
        Checkerboard board;
        if(color == false){board = new Checkerboard(numRows, numCols, boardWidth, boardHeight);}
        else{board = new Checkerboard(numRows, numCols, boardWidth, boardHeight, lightColor, darkColor);}
        board.build();
        anchorPane.getChildren().add(board.getBoard());
    }
    private void clearBoard(){
        anchorPane.getChildren().clear();
        anchorPane.getChildren().clear();
    }
    @FXML
    private void handleDefaultColor(ActionEvent event) {
        color = false;
        buildBoard();
    }
    @FXML
    private void handlePurpleColor(ActionEvent event) {
        color = true;
        buildBoard();
    }
    @FXML
    private void handleGridSize(ActionEvent event) {
          clearBoard();
//        Checkerboard board = new Checkerboard(numRows, numCols, boardWidth, boardHeight);
//        board.build();
//        this.anchorPane.getChildren().add(board.getBoard());
    }
}
