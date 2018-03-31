/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofhanoi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private GridPane game_world;
    @FXML
    private Line pole1;
    @FXML
    private Line pole2;
    @FXML
    private Line pole3;
    @FXML
    private Rectangle ring1;
    @FXML
    private Rectangle ring2;
    @FXML
    private Rectangle ring3;
    @FXML
    private Rectangle ring4;
    @FXML
    private Button Solution;
    @FXML
    private Button Back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

       @FXML
    private void SolutionClick(ActionEvent event)throws InterruptedException {
        Solution.setDisable(true);
        int numberOfDiscs = 4;
        TowerOfHanoi obj = new TowerOfHanoi(numberOfDiscs);
        obj.move(ring4,pole1,pole3);
        obj.move(ring3,pole1,pole2);
        obj.move(ring4,pole3,pole2);
        obj.move(ring2,pole1,pole3);
        obj.move(ring4,pole2,pole1);
        obj.move(ring3,pole2,pole3);
        obj.move(ring4,pole1,pole3);
        obj.move(ring1,pole1,pole2);
        obj.move(ring4,pole3,pole2);
        obj.move(ring3,pole3,pole1);
        obj.move(ring4,pole2,pole1);
        obj.move(ring2,pole3,pole2);
        obj.move(ring4,pole1, pole3);
        obj.move(ring3,pole1,pole2);
        obj.move(ring4,pole3,pole2);
        
        obj.showSolution();
      
    }

    @FXML
    private void BackClick(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMenu.fxml"));;
        
        Scene scene = new Scene(root);
        
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
    }
    
}
