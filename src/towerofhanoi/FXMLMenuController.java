/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofhanoi;

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
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLMenuController implements Initializable {

    @FXML
    private ChoiceBox<String> cbxNumberOfDiscs;
    @FXML
    private Button Generate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void GenerateClick(ActionEvent event)throws Exception {
        int n = Integer.parseInt(cbxNumberOfDiscs.getValue());
        Parent window = FXMLLoader.load(getClass().getResource("FXMLHanoi1.fxml"));
        switch(n)
        {
            case 2:
                window = FXMLLoader.load(getClass().getResource("FXMLHanoi2.fxml"));
                break;
            case 3:
                window = FXMLLoader.load(getClass().getResource("FXMLHanoi3.fxml"));
                break;
            case 4:
                window = FXMLLoader.load(getClass().getResource("FXMLHanoi4.fxml"));
                break;
        }
      Scene scene = new Scene(window);
      Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
      stage.hide();
      stage.setScene(scene);
      stage.setResizable(false);
      stage.show();
    }
    
    
}
