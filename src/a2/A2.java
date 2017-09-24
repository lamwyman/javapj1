/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a2;

import World.Clock;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author WaiMan
 */
public class A2 extends Application {
    public static Stage dialogue;
    public static Scene main, task11, task222, task333, inputvar, t3host, t3join, waiting;
    public static Task11Controller controller1;
    public static Task222Controller controller2;
    public static Task333Controller controller3;
    public static Clock WorldClock = new Clock();
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        main = new Scene(root);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("task11.fxml"));
        Parent root1 = (Parent) loader.load();
        task11 = new Scene(root1);
        controller1 = loader.getController();
        
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("task222.fxml"));
        Parent root2 = (Parent) loader2.load();
        task222 = new Scene(root2);
        controller2 = loader2.getController();
        
        FXMLLoader loader3 = new FXMLLoader(getClass().getResource("task333.fxml"));
        Parent root3 = (Parent) loader3.load();
        task333 = new Scene(root3);
        controller3 = loader3.getController();
        
        Parent root4 = FXMLLoader.load(getClass().getResource("inputvar.fxml"));
        inputvar = new Scene(root4);
        
        Parent root5 = FXMLLoader.load(getClass().getResource("t3host.fxml"));
        t3host = new Scene(root5);
        
        Parent root6 = FXMLLoader.load(getClass().getResource("t3join.fxml"));
        t3join = new Scene(root6);
        
        Parent root7 = FXMLLoader.load(getClass().getResource("waiting.fxml"));
        waiting = new Scene(root7);
        
        dialogue = stage;
        dialogue.setScene(main);
        dialogue.setTitle("World Of Warcraft");
        dialogue.show();
    }
}
