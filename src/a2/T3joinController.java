/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a2;

import static a2.A2.dialogue;
import static a2.A2.inputvar;
import static a2.A2.waiting;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author WaiMan
 */
public class T3joinController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button join;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == join) {
            //A2.controller3.getIP();
            dialogue.setScene(waiting);
            dialogue.setTitle("Waiting for host");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
