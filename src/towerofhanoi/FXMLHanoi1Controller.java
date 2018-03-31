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
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLHanoi1Controller implements Initializable {

    @FXML
    private Line pole1;
    @FXML
    private Line pole2;
    @FXML
    private Line pole3;
    @FXML
    private Rectangle ring1;
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
        int numberOfDiscs = 1;
        TowerOfHanoi obj = new TowerOfHanoi(numberOfDiscs);
        obj.move(ring1, pole1, pole2);
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
