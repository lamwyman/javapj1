/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a2;

import static a2.A2.dialogue;
import static a2.A2.inputvar;
import static a2.A2.t3host;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author WaiMan
 */
public class T3hostController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label hip;
    @FXML
    private Button next;

    String ip;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() == next) {
            //A2.controller3.getIP();
            dialogue.setScene(inputvar);
            dialogue.setTitle("Input Parameters");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                // filters out 127.0.0.1 and inactive interfaces
                if (iface.isLoopback() || !iface.isUp()) {
                    continue;
                }

                Enumeration<InetAddress> addresses = iface.getInetAddresses();

                InetAddress addr = addresses.nextElement();
                ip = addr.getHostAddress();
                hip.setText("" + ip);

            }
        } catch (Exception k) {
            throw new RuntimeException(k);
        }

    }

}
