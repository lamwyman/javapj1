/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a2;

import Warriors.WarriorType;
import World.WorldProperty;
import static a2.A2.dialogue;
import static a2.A2.task11;
import static a2.A2.task222;
import static a2.A2.task333;
import static a2.A2.waiting;
import static a2.FXMLDocumentController.gametype;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author WaiMan
 */
public class InputvarController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField initlife;
    @FXML
    private TextField time;
    @FXML
    private TextField dragonhp;
    @FXML
    private TextField ninjahp;
    @FXML
    private TextField icemanhp;
    @FXML
    private TextField lionhp;
    @FXML
    private TextField wolfhp;
    @FXML
    private TextField dragonatt;
    @FXML
    private TextField ninjaatt;
    @FXML
    private TextField icemanatt;
    @FXML
    private TextField lionatt;
    @FXML
    private TextField wolfatt;
    @FXML
    private Button start;

    int cities = 5;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == start) {
            WorldProperty.InitLifeElements = Integer.parseInt(initlife.getText());
            WorldProperty.NumberOfCity = cities;
            WorldProperty.MaxMinutes = Integer.parseInt(time.getText());
            WarriorType.HP_LIST[0] = Integer.parseInt(dragonhp.getText());
            WarriorType.HP_LIST[1] = Integer.parseInt(ninjahp.getText());
            WarriorType.HP_LIST[2] = Integer.parseInt(icemanhp.getText());
            WarriorType.HP_LIST[3] = Integer.parseInt(lionhp.getText());
            WarriorType.HP_LIST[4] = Integer.parseInt(wolfhp.getText());
            WarriorType.ATTACK_LIST[0] = Integer.parseInt(dragonatt.getText());
            WarriorType.ATTACK_LIST[1] = Integer.parseInt(ninjaatt.getText());
            WarriorType.ATTACK_LIST[2] = Integer.parseInt(icemanatt.getText());
            WarriorType.ATTACK_LIST[3] = Integer.parseInt(lionatt.getText());
            WarriorType.ATTACK_LIST[4] = Integer.parseInt(wolfatt.getText());

            if (gametype == 1) {
                A2.controller1.runGame();
                dialogue.setScene(task11);
                dialogue.setTitle("Display A1");
            }
            if (gametype == 2) {
                A2.controller2.runGame();
                dialogue.setScene(task222);
                dialogue.setTitle("Single Play");
            }
            if (gametype == 3) {
                dialogue.setScene(waiting);
                dialogue.setTitle("Waiting for host/opponent");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
