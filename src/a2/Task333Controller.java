/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a2;

import static a2.A2.dialogue;
import static a2.A2.t3host;
import static a2.A2.t3join;
import static a2.A2.task222;
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
public class Task333Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button host;
    @FXML
    private Button join;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == host) {
            dialogue.setScene(t3host);
            dialogue.setTitle("Host Game");
        }
        if (event.getSource() == join) {
            dialogue.setScene(t3join);
            dialogue.setTitle("Join Game");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
