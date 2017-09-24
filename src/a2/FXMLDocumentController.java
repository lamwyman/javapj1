/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a2;

import static a2.A2.dialogue;
import static a2.A2.inputvar;
import static a2.A2.task11;
import static a2.A2.task222;
import static a2.A2.task333;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author WaiMan
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button buttonA;
    @FXML
    private Button buttonB;
    @FXML
    private Button buttonC;

    public static int gametype;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == buttonA) {
            gametype = 1;
            dialogue.setScene(inputvar);
            dialogue.setTitle("A1 initialize");
        }

        if (event.getSource() == buttonB) {
            gametype = 2;
            dialogue.setScene(inputvar);
            dialogue.setTitle("Single play initialize");
        }

        if (event.getSource() == buttonC) {
            gametype = 3;
            dialogue.setScene(task333);
            dialogue.setTitle("Multi Play Lobby");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
