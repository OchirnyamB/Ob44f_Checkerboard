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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author ob44f
 */
public class CheckerboardFXMLController implements Initializable, Startable {

    @FXML
    private VBox vBox;

    @FXML
    private AnchorPane anchorPane;
 
    @FXML
    private MenuBar menuBar;
    @FXML 
    private Menu gridMenu;
    @FXML
    private MenuItem menu1;
    @FXML
    private MenuItem menu2;
    @FXML
    private MenuItem menu3;
    @FXML
    private MenuItem menu4;

    private Stage stage;

    private int numRows = 8;
    private int numCols = 8;

    private double boardWidth;
    private double boardHeight;
    private double rectWidth;
    private double rectHeight;

    private boolean defaultColor = true;
    
    private Color lightColor = Color.SKYBLUE;
    private Color darkColor = Color.DARKBLUE;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void start(Stage stage) {
        this.stage = stage;
        ChangeListener<Number> stageSizeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
            displayBoard();
        };
        this.stage.widthProperty().addListener(stageSizeListener);
        this.stage.heightProperty().addListener(stageSizeListener);
        displayBoard();
    }

    private void displayBoard() {
        boardWidth = vBox.getWidth();
        boardHeight = vBox.getHeight() - menuBar.getHeight();  // height of anchorPane
        Checkerboard board;
        // flag is set to indicate different colored board initializaiton
        if (defaultColor == true) {
            board = new Checkerboard(numRows, numCols, boardWidth, boardHeight);
        } // no color specified instance
        else {
            board = new Checkerboard(numRows, numCols, boardWidth, boardHeight, lightColor, darkColor);
        }  // color specified instance
        clearBoard();              // clear board or remove current anchorpane when redrawing the different sized board
        board.build();             // call the public build board function in Checkerboard class 
        anchorPane = board.getBoard();
        vBox.getChildren().add(anchorPane);
    }

    @FXML
    private void handleDefaultColor(ActionEvent event) {
        defaultColor = true;
        displayBoard();
    }

    @FXML
    private void handlePurpleColor(ActionEvent event) {
        defaultColor = false;
        displayBoard();
    }

    @FXML
    private void handleGridSize(ActionEvent event) {
        gridMenu.getItems().forEach((size) -> {
            size.setOnAction((ActionEvent event1) -> {
                String boardDimension = size.getText();                     // Parse the submenus texts 16x16, 8x8
                int index = boardDimension.indexOf("x");                    // to get the board square dimension
                boardDimension = boardDimension.substring(0,index);
                int dimension = Integer.parseInt(boardDimension);
                numRows = dimension;
                numCols = dimension;
                displayBoard();
            } // if one of the submenu is clicked set action
            );
        });
    }

    private void clearBoard() {
        vBox.getChildren().remove(anchorPane);
    }
}
