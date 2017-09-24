/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a2;

import Warriors.Warrior;
import Warriors.WarriorType;
import World.City;
import World.Clock;
import World.Headquarters;
import World.WorldProperty;
import static a2.A2.WorldClock;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author WaiMan
 */
public class Task222Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label timer;
    @FXML
    private Label redlife;
    @FXML
    private Label bluelife;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;
    @FXML
    private ImageView img5;
    @FXML
    private ImageView img6;
    @FXML
    private ImageView img7;
    @FXML
    private ImageView img8;
    @FXML
    private ImageView img9;
    @FXML
    private ImageView img10;
    @FXML
    private ImageView img11;
    @FXML
    private ImageView img12;
    @FXML
    private ImageView img13;
    @FXML
    private ImageView img14;
    @FXML
    private ImageView img15;
    @FXML
    private ImageView img16;
    @FXML
    private ImageView flag0;
    @FXML
    private ImageView flag1;
    @FXML
    private ImageView flag2;
    @FXML
    private ImageView flag3;
    @FXML
    private ImageView flag4;
    @FXML
    private ImageView flag5;
    @FXML
    private ImageView flag6;

    @FXML
    private ImageView producedragon;
    @FXML
    private ImageView produceiceman;
    @FXML
    private ImageView producelion;
    @FXML
    private ImageView produceninja;
    @FXML
    private ImageView producewolf;
    @FXML
    private ImageView imgbig;

    @FXML
    private Label labeltype;
    @FXML
    private Label labelparty;
    @FXML
    private Label labelid;
    @FXML
    private Label labellocation;
    @FXML
    private Label labelhp;
    @FXML
    private Label labelattack;
    @FXML
    private Label labelkill;
    @FXML
    private Label labelsteps;

    @FXML
    private GridPane warriorgrid;
    @FXML
    private GridPane citygrid;

    @FXML
    private ImageView city0;
    @FXML
    private ImageView city1;
    @FXML
    private ImageView city2;
    @FXML
    private ImageView city3;
    @FXML
    private ImageView city4;
    @FXML
    private ImageView city5;
    @FXML
    private ImageView city6;
    @FXML
    private Label cityid;
    @FXML
    private Label flag;
    @FXML
    private Label le;

    private ImageView[] flagarr = new ImageView[5];
    private ImageView[] imgarrred = new ImageView[8];
    private ImageView[] imgarrblue = new ImageView[8];

    public City[] City;
    private Service<Void> backgroundThread;

    public void runGame() {
        redlife.setText(Integer.toString(WorldProperty.InitLifeElements));
        bluelife.setText(Integer.toString(WorldProperty.InitLifeElements));
        timer.setText(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
        City = new City[WorldProperty.NumberOfCity + 2];
        City[0] = new Headquarters(WorldProperty.RedProductionOrder, 0, WorldProperty.RED, WorldProperty.RED);
        City[WorldProperty.NumberOfCity + 1] = new Headquarters(WorldProperty.BlueProductionOrder, WorldProperty.NumberOfCity + 1, WorldProperty.BLUE, WorldProperty.BLUE);

        int i = 1;
        while (i <= WorldProperty.NumberOfCity) {
            City[i] = new City(i);
            i++;
        }
        backgroundThread = new Service<Void>() {
            @Override
            protected Task<Void> createTask() {
                return new Task<Void>() {
                    @Override
                    protected Void call() throws Exception {
                        do {
                            switch (WorldClock.getMinute()) {
                                case 0:
                                    /*
                                    if (((Headquarters) City[0]).tryToProduceWarrior()) {
                                        System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                                        System.out.println(WorldProperty.PartyNames[0] + " " + WarriorType.WarriorNames[((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).Type] + " " + ((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).ProductionID + " born");
                                        img1.setImage(new Image("figure/" + WarriorType.WarriorNames[((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).Type] + "_red.png"));
                                    }
                                     */

                                    if (((Headquarters) City[WorldProperty.NumberOfCity + 1]).tryToProduceWarrior()) {
                                        System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                                        System.out.println(WorldProperty.PartyNames[1] + " " + WarriorType.WarriorNames[((Headquarters) City[WorldProperty.NumberOfCity + 1]).BlueWarriorStation.get((((Headquarters) City[WorldProperty.NumberOfCity + 1]).BlueWarriorStation).size() - 1).Type] + " " + ((Headquarters) City[WorldProperty.NumberOfCity + 1]).BlueWarriorStation.get((((Headquarters) City[WorldProperty.NumberOfCity + 1]).BlueWarriorStation).size() - 1).ProductionID + " born");
                                        img9.setImage(new Image("figure/" + WarriorType.WarriorNames[((Headquarters) City[WorldProperty.NumberOfCity + 1]).BlueWarriorStation.get((((Headquarters) City[WorldProperty.NumberOfCity + 1]).BlueWarriorStation).size() - 1).Type] + "_blue.png"));
                                    }
                                    break;

                                case 10:
                                    marchWarriors();
                                    if (((Headquarters) City[0]).checkOccupied()) {
                                        System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                                        System.out.println("red headquarter was taken");
                                        flag0.setImage(new Image("figure/flag_blue.png"));
                                    }

                                    if (((Headquarters) City[WorldProperty.NumberOfCity + 1]).checkOccupied()) {
                                        System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                                        System.out.println("blue headquarter was taken");
                                        flag6.setImage(new Image("figure/flag_red.png"));
                                    }

                                    for (int i = 0; i < 6; i++) {
                                        if (!City[i].RedWarriorStation.isEmpty()) {
                                            imgarrred[i].setImage(new Image("figure/" + WarriorType.WarriorNames[City[i].RedWarriorStation.get(0).Type] + "_red.png"));
                                        } else {
                                            imgarrred[i].setImage(null);
                                        }
                                    }
                                    for (int i = 1; i < 7; i++) {
                                        if (!City[7 - i].BlueWarriorStation.isEmpty()) {
                                            imgarrblue[i - 1].setImage(new Image("figure/" + WarriorType.WarriorNames[City[7 - i].BlueWarriorStation.get(0).Type] + "_blue.png"));
                                        } else {
                                            imgarrblue[i - 1].setImage(null);
                                        }
                                    }

                                    if (!City[0].BlueWarriorStation.isEmpty()) {
                                        if (City[0].BlueWarriorStation.size() == 2) {
                                            imgarrblue[6].setImage(new Image("figure/" + WarriorType.WarriorNames[City[0].BlueWarriorStation.get(0).Type] + "_blue.png"));
                                            imgarrblue[7].setImage(new Image("figure/" + WarriorType.WarriorNames[City[0].BlueWarriorStation.get(1).Type] + "_blue.png"));
                                        } else if (City[0].BlueWarriorStation.size() == 1) {
                                            imgarrblue[6].setImage(new Image("figure/" + WarriorType.WarriorNames[City[0].BlueWarriorStation.get(0).Type] + "_blue.png"));
                                        }
                                    }
                                    if (!City[6].RedWarriorStation.isEmpty()) {
                                        if (City[6].RedWarriorStation.size() == 2) {
                                            imgarrred[6].setImage(new Image("figure/" + WarriorType.WarriorNames[City[6].RedWarriorStation.get(0).Type] + "_red.png"));
                                            imgarrred[7].setImage(new Image("figure/" + WarriorType.WarriorNames[City[6].RedWarriorStation.get(1).Type] + "_red.png"));
                                        } else if (City[6].RedWarriorStation.size() == 1) {
                                            imgarrred[6].setImage(new Image("figure/" + WarriorType.WarriorNames[City[6].RedWarriorStation.get(0).Type] + "_red.png"));
                                        }
                                    }
                                    break;

                                case 20:
                                    ProduceLifeElements();
                                    break;

                                case 30:
                                    warriorsFetchLifeElementsFromCity();
                                    break;

                                case 40:
                                    holdBattlesAndWorkAfterBattles();
                                    for (int i = 1; i < 6; i++) {
                                        if (City[i].Flag == 0) {
                                            flagarr[i - 1].setImage(new Image("figure/flag_red.png"));
                                        } else if (City[i].Flag == 1) {
                                            flagarr[i - 1].setImage(new Image("figure/flag_blue.png"));
                                        }
                                    }
                                    break;

                                case 50:
                                    headquartersReportLifeElements();
                                    break;
                            }
                            Thread.sleep(1000);
                            WorldClock.increase();
                            Platform.runLater(
                                    //TODO: ADD GUI CODE HERE.
                                    () -> {
                                        redlife.setText(Integer.toString(City[0].LifeElement));
                                        bluelife.setText(Integer.toString(City[6].LifeElement));
                                        timer.setText(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                                    });
                        } while (Integer.parseInt(WorldClock.getTime()) * 60 + WorldClock.getMinute() <= WorldProperty.MaxMinutes && !((Headquarters) City[0]).checkOccupied() && !((Headquarters) City[WorldProperty.NumberOfCity + 1]).checkOccupied());
                        return null;
                    }
                };
            }
        };
        backgroundThread.start();
    }

    @FXML
    public void handleProduce(MouseEvent me3) {
        if (me3.getSource() == producedragon) {
            ((Headquarters) City[0]).produceWarrior(0);
            System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
            System.out.println(WorldProperty.PartyNames[0] + " " + WarriorType.WarriorNames[((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).Type] + " " + ((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).ProductionID + " born");
            img1.setImage(new Image("figure/" + WarriorType.WarriorNames[((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).Type] + "_red.png"));
        }
        if (me3.getSource() == produceiceman) {
            ((Headquarters) City[0]).produceWarrior(2);
            System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
            System.out.println(WorldProperty.PartyNames[0] + " " + WarriorType.WarriorNames[((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).Type] + " " + ((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).ProductionID + " born");
            img1.setImage(new Image("figure/" + WarriorType.WarriorNames[((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).Type] + "_red.png"));
        }
        if (me3.getSource() == producelion) {
            ((Headquarters) City[0]).produceWarrior(3);
            System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
            System.out.println(WorldProperty.PartyNames[0] + " " + WarriorType.WarriorNames[((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).Type] + " " + ((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).ProductionID + " born");
            img1.setImage(new Image("figure/" + WarriorType.WarriorNames[((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).Type] + "_red.png"));
        }
        if (me3.getSource() == produceninja) {
            ((Headquarters) City[0]).produceWarrior(1);
            System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
            System.out.println(WorldProperty.PartyNames[0] + " " + WarriorType.WarriorNames[((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).Type] + " " + ((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).ProductionID + " born");
            img1.setImage(new Image("figure/" + WarriorType.WarriorNames[((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).Type] + "_red.png"));
        }
        if (me3.getSource() == producewolf) {
            ((Headquarters) City[0]).produceWarrior(4);
            System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
            System.out.println(WorldProperty.PartyNames[0] + " " + WarriorType.WarriorNames[((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).Type] + " " + ((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).ProductionID + " born");
            img1.setImage(new Image("figure/" + WarriorType.WarriorNames[((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).Type] + "_red.png"));
        }
    }

    @FXML
    public void handleCityAction(MouseEvent me2) {
        warriorgrid.setVisible(false);
        citygrid.setVisible(true);

        if (me2.getSource() == city0) {
            imgbig.setImage(new Image("figure/castle_0.png"));
            cityid.setText(Integer.toString(City[0].CityID));
            flag.setText(Integer.toString(City[0].Flag));
            le.setText(Integer.toString(City[0].LifeElement));
        }
        if (me2.getSource() == city1) {
            imgbig.setImage(new Image("figure/castle_1.png"));
            cityid.setText(Integer.toString(City[1].CityID));
            flag.setText(Integer.toString(City[1].Flag));
            le.setText(Integer.toString(City[1].LifeElement));
        }
        if (me2.getSource() == city2) {
            imgbig.setImage(new Image("figure/castle_1.png"));
            cityid.setText(Integer.toString(City[2].CityID));
            flag.setText(Integer.toString(City[2].Flag));
            le.setText(Integer.toString(City[2].LifeElement));
        }
        if (me2.getSource() == city3) {
            imgbig.setImage(new Image("figure/castle_1.png"));
            cityid.setText(Integer.toString(City[3].CityID));
            flag.setText(Integer.toString(City[3].Flag));
            le.setText(Integer.toString(City[3].LifeElement));
        }
        if (me2.getSource() == city4) {
            imgbig.setImage(new Image("figure/castle_1.png"));
            cityid.setText(Integer.toString(City[4].CityID));
            flag.setText(Integer.toString(City[4].Flag));
            le.setText(Integer.toString(City[4].LifeElement));
        }
        if (me2.getSource() == city5) {
            imgbig.setImage(new Image("figure/castle_1.png"));
            cityid.setText(Integer.toString(City[5].CityID));
            flag.setText(Integer.toString(City[5].Flag));
            le.setText(Integer.toString(City[5].LifeElement));
        }
        if (me2.getSource() == city6) {
            imgbig.setImage(new Image("figure/castle_0.png"));
            cityid.setText(Integer.toString(City[6].CityID));
            flag.setText(Integer.toString(City[6].Flag));
            le.setText(Integer.toString(City[6].LifeElement));
        }

    }

    @FXML
    public void handleImageViewAction(MouseEvent me) {
        citygrid.setVisible(false);
        warriorgrid.setVisible(true);

        if (me.getSource() == img1 && !City[0].RedWarriorStation.isEmpty()) {
            imgbig.setImage(new Image("figure/" + WarriorType.WarriorNames[((Headquarters) City[0]).RedWarriorStation.get(0).Type] + "_red.png"));
            labeltype.setText(WarriorType.WarriorNames[((Headquarters) City[0]).RedWarriorStation.get(0).Type]);
            labelparty.setText("red");
            labelid.setText(Integer.toString(City[0].RedWarriorStation.get(0).ProductionID));
            labellocation.setText("City0");
            labelhp.setText(Integer.toString(City[0].RedWarriorStation.get(0).HP));
            labelattack.setText(Integer.toString(City[0].RedWarriorStation.get(0).AttackValue));
            labelkill.setText(Integer.toString(City[0].RedWarriorStation.get(0).NumberOfKilledWarrior));
            labelsteps.setText(Integer.toString(City[0].RedWarriorStation.get(0).MovedDistance));
        }
        if (me.getSource() == img2 && !City[1].RedWarriorStation.isEmpty()) {
            imgbig.setImage(new Image("figure/" + WarriorType.WarriorNames[(City[1]).RedWarriorStation.get(0).Type] + "_red.png"));
            labeltype.setText(WarriorType.WarriorNames[(City[1]).RedWarriorStation.get(0).Type]);
            labelparty.setText("red");
            labelid.setText(Integer.toString(City[1].RedWarriorStation.get(0).ProductionID));
            labellocation.setText("City1");
            labelhp.setText(Integer.toString(City[1].RedWarriorStation.get(0).HP));
            labelattack.setText(Integer.toString(City[1].RedWarriorStation.get(0).AttackValue));
            labelkill.setText(Integer.toString(City[1].RedWarriorStation.get(0).NumberOfKilledWarrior));
            labelsteps.setText(Integer.toString(City[1].RedWarriorStation.get(0).MovedDistance));
        }
        if (me.getSource() == img3 && !City[2].RedWarriorStation.isEmpty()) {
            imgbig.setImage(new Image("figure/" + WarriorType.WarriorNames[(City[2]).RedWarriorStation.get(0).Type] + "_red.png"));
            labeltype.setText(WarriorType.WarriorNames[(City[2]).RedWarriorStation.get(0).Type]);
            labelparty.setText("red");
            labelid.setText(Integer.toString(City[2].RedWarriorStation.get(0).ProductionID));
            labellocation.setText("City2");
            labelhp.setText(Integer.toString(City[2].RedWarriorStation.get(0).HP));
            labelattack.setText(Integer.toString(City[2].RedWarriorStation.get(0).AttackValue));
            labelkill.setText(Integer.toString(City[2].RedWarriorStation.get(0).NumberOfKilledWarrior));
            labelsteps.setText(Integer.toString(City[2].RedWarriorStation.get(0).MovedDistance));
        }
        if (me.getSource() == img4 && !City[3].RedWarriorStation.isEmpty()) {
            imgbig.setImage(new Image("figure/" + WarriorType.WarriorNames[(City[3]).RedWarriorStation.get(0).Type] + "_red.png"));
            labeltype.setText(WarriorType.WarriorNames[(City[3]).RedWarriorStation.get(0).Type]);
            labelparty.setText("red");
            labelid.setText(Integer.toString(City[3].RedWarriorStation.get(0).ProductionID));
            labellocation.setText("City3");
            labelhp.setText(Integer.toString(City[3].RedWarriorStation.get(0).HP));
            labelattack.setText(Integer.toString(City[3].RedWarriorStation.get(0).AttackValue));
            labelkill.setText(Integer.toString(City[3].RedWarriorStation.get(0).NumberOfKilledWarrior));
            labelsteps.setText(Integer.toString(City[3].RedWarriorStation.get(0).MovedDistance));
        }
        if (me.getSource() == img5 && !City[4].RedWarriorStation.isEmpty()) {
            imgbig.setImage(new Image("figure/" + WarriorType.WarriorNames[(City[4]).RedWarriorStation.get(0).Type] + "_red.png"));
            labeltype.setText(WarriorType.WarriorNames[(City[4]).RedWarriorStation.get(0).Type]);
            labelparty.setText("red");
            labelid.setText(Integer.toString(City[4].RedWarriorStation.get(0).ProductionID));
            labellocation.setText("City4");
            labelhp.setText(Integer.toString(City[4].RedWarriorStation.get(0).HP));
            labelattack.setText(Integer.toString(City[4].RedWarriorStation.get(0).AttackValue));
            labelkill.setText(Integer.toString(City[4].RedWarriorStation.get(0).NumberOfKilledWarrior));
            labelsteps.setText(Integer.toString(City[4].RedWarriorStation.get(0).MovedDistance));
        }
        if (me.getSource() == img6 && !City[5].RedWarriorStation.isEmpty()) {
            imgbig.setImage(new Image("figure/" + WarriorType.WarriorNames[(City[5]).RedWarriorStation.get(0).Type] + "_red.png"));
            labeltype.setText(WarriorType.WarriorNames[(City[5]).RedWarriorStation.get(0).Type]);
            labelparty.setText("red");
            labelid.setText(Integer.toString(City[5].RedWarriorStation.get(0).ProductionID));
            labellocation.setText("City5");
            labelhp.setText(Integer.toString(City[5].RedWarriorStation.get(0).HP));
            labelattack.setText(Integer.toString(City[5].RedWarriorStation.get(0).AttackValue));
            labelkill.setText(Integer.toString(City[5].RedWarriorStation.get(0).NumberOfKilledWarrior));
            labelsteps.setText(Integer.toString(City[5].RedWarriorStation.get(0).MovedDistance));
        }
        if (me.getSource() == img7 && !City[6].RedWarriorStation.isEmpty()) {
            imgbig.setImage(new Image("figure/" + WarriorType.WarriorNames[((Headquarters) City[6]).RedWarriorStation.get(0).Type] + "_red.png"));
            labeltype.setText(WarriorType.WarriorNames[((Headquarters) City[6]).RedWarriorStation.get(0).Type]);
            labelparty.setText("red");
            labelid.setText(Integer.toString(City[6].RedWarriorStation.get(0).ProductionID));
            labellocation.setText("City6");
            labelhp.setText(Integer.toString(City[6].RedWarriorStation.get(0).HP));
            labelattack.setText(Integer.toString(City[6].RedWarriorStation.get(0).AttackValue));
            labelkill.setText(Integer.toString(City[6].RedWarriorStation.get(0).NumberOfKilledWarrior));
            labelsteps.setText(Integer.toString(City[6].RedWarriorStation.get(0).MovedDistance));
        }
        if (me.getSource() == img8 && !City[6].RedWarriorStation.isEmpty()) {
            imgbig.setImage(new Image("figure/" + WarriorType.WarriorNames[((Headquarters) City[6]).RedWarriorStation.get(1).Type] + "_red.png"));
            labeltype.setText(WarriorType.WarriorNames[((Headquarters) City[6]).RedWarriorStation.get(1).Type]);
            labelparty.setText("red");
            labelid.setText(Integer.toString(City[6].RedWarriorStation.get(1).ProductionID));
            labellocation.setText("City6");
            labelhp.setText(Integer.toString(City[6].RedWarriorStation.get(1).HP));
            labelattack.setText(Integer.toString(City[6].RedWarriorStation.get(1).AttackValue));
            labelkill.setText(Integer.toString(City[6].RedWarriorStation.get(1).NumberOfKilledWarrior));
            labelsteps.setText(Integer.toString(City[6].RedWarriorStation.get(1).MovedDistance));
        }
        if (me.getSource() == img9 && !City[6].BlueWarriorStation.isEmpty()) {
            imgbig.setImage(new Image("figure/" + WarriorType.WarriorNames[((Headquarters) City[6]).BlueWarriorStation.get(0).Type] + "_blue.png"));
            labeltype.setText(WarriorType.WarriorNames[((Headquarters) City[6]).BlueWarriorStation.get(0).Type]);
            labelparty.setText("blue");
            labelid.setText(Integer.toString(City[6].BlueWarriorStation.get(0).ProductionID));
            labellocation.setText("City6");
            labelhp.setText(Integer.toString(City[6].BlueWarriorStation.get(0).HP));
            labelattack.setText(Integer.toString(City[6].BlueWarriorStation.get(0).AttackValue));
            labelkill.setText(Integer.toString(City[6].BlueWarriorStation.get(0).NumberOfKilledWarrior));
            labelsteps.setText(Integer.toString(City[6].BlueWarriorStation.get(0).MovedDistance));
        }
        if (me.getSource() == img10 && !City[5].BlueWarriorStation.isEmpty()) {
            imgbig.setImage(new Image("figure/" + WarriorType.WarriorNames[(City[5]).BlueWarriorStation.get(0).Type] + "_blue.png"));
            labeltype.setText(WarriorType.WarriorNames[(City[5]).BlueWarriorStation.get(0).Type]);
            labelparty.setText("blue");
            labelid.setText(Integer.toString(City[5].BlueWarriorStation.get(0).ProductionID));
            labellocation.setText("City5");
            labelhp.setText(Integer.toString(City[5].BlueWarriorStation.get(0).HP));
            labelattack.setText(Integer.toString(City[5].BlueWarriorStation.get(0).AttackValue));
            labelkill.setText(Integer.toString(City[5].BlueWarriorStation.get(0).NumberOfKilledWarrior));
            labelsteps.setText(Integer.toString(City[5].BlueWarriorStation.get(0).MovedDistance));
        }
        if (me.getSource() == img11 && !City[4].BlueWarriorStation.isEmpty()) {
            imgbig.setImage(new Image("figure/" + WarriorType.WarriorNames[(City[4]).BlueWarriorStation.get(0).Type] + "_blue.png"));
            labeltype.setText(WarriorType.WarriorNames[(City[4]).BlueWarriorStation.get(0).Type]);
            labelparty.setText("blue");
            labelid.setText(Integer.toString(City[4].BlueWarriorStation.get(0).ProductionID));
            labellocation.setText("City4");
            labelhp.setText(Integer.toString(City[4].BlueWarriorStation.get(0).HP));
            labelattack.setText(Integer.toString(City[4].BlueWarriorStation.get(0).AttackValue));
            labelkill.setText(Integer.toString(City[4].BlueWarriorStation.get(0).NumberOfKilledWarrior));
            labelsteps.setText(Integer.toString(City[4].BlueWarriorStation.get(0).MovedDistance));
        }
        if (me.getSource() == img12 && !City[3].BlueWarriorStation.isEmpty()) {
            imgbig.setImage(new Image("figure/" + WarriorType.WarriorNames[(City[3]).BlueWarriorStation.get(0).Type] + "_blue.png"));
            labeltype.setText(WarriorType.WarriorNames[(City[3]).BlueWarriorStation.get(0).Type]);
            labelparty.setText("blue");
            labelid.setText(Integer.toString(City[3].BlueWarriorStation.get(0).ProductionID));
            labellocation.setText("City3");
            labelhp.setText(Integer.toString(City[3].BlueWarriorStation.get(0).HP));
            labelattack.setText(Integer.toString(City[3].BlueWarriorStation.get(0).AttackValue));
            labelkill.setText(Integer.toString(City[3].BlueWarriorStation.get(0).NumberOfKilledWarrior));
            labelsteps.setText(Integer.toString(City[3].BlueWarriorStation.get(0).MovedDistance));
        }
        if (me.getSource() == img13 && !City[2].BlueWarriorStation.isEmpty()) {
            imgbig.setImage(new Image("figure/" + WarriorType.WarriorNames[(City[2]).BlueWarriorStation.get(0).Type] + "_blue.png"));
            labeltype.setText(WarriorType.WarriorNames[(City[2]).BlueWarriorStation.get(0).Type]);
            labelparty.setText("blue");
            labelid.setText(Integer.toString(City[2].BlueWarriorStation.get(0).ProductionID));
            labellocation.setText("City2");
            labelhp.setText(Integer.toString(City[2].BlueWarriorStation.get(0).HP));
            labelattack.setText(Integer.toString(City[2].BlueWarriorStation.get(0).AttackValue));
            labelkill.setText(Integer.toString(City[2].BlueWarriorStation.get(0).NumberOfKilledWarrior));
            labelsteps.setText(Integer.toString(City[2].BlueWarriorStation.get(0).MovedDistance));
        }
        if (me.getSource() == img14 && !City[1].BlueWarriorStation.isEmpty()) {
            imgbig.setImage(new Image("figure/" + WarriorType.WarriorNames[(City[1]).BlueWarriorStation.get(0).Type] + "_blue.png"));
            labeltype.setText(WarriorType.WarriorNames[(City[1]).BlueWarriorStation.get(0).Type]);
            labelparty.setText("blue");
            labelid.setText(Integer.toString(City[1].BlueWarriorStation.get(0).ProductionID));
            labellocation.setText("City1");
            labelhp.setText(Integer.toString(City[1].BlueWarriorStation.get(0).HP));
            labelattack.setText(Integer.toString(City[1].BlueWarriorStation.get(0).AttackValue));
            labelkill.setText(Integer.toString(City[1].BlueWarriorStation.get(0).NumberOfKilledWarrior));
            labelsteps.setText(Integer.toString(City[1].BlueWarriorStation.get(0).MovedDistance));
        }
        if (me.getSource() == img15 && !City[0].BlueWarriorStation.isEmpty()) {
            imgbig.setImage(new Image("figure/" + WarriorType.WarriorNames[((Headquarters) City[0]).BlueWarriorStation.get(0).Type] + "_blue.png"));
            labeltype.setText(WarriorType.WarriorNames[((Headquarters) City[0]).BlueWarriorStation.get(0).Type]);
            labelparty.setText("blue");
            labelid.setText(Integer.toString(City[0].BlueWarriorStation.get(0).ProductionID));
            labellocation.setText("City0");
            labelhp.setText(Integer.toString(City[0].BlueWarriorStation.get(0).HP));
            labelattack.setText(Integer.toString(City[0].BlueWarriorStation.get(0).AttackValue));
            labelkill.setText(Integer.toString(City[0].BlueWarriorStation.get(0).NumberOfKilledWarrior));
            labelsteps.setText(Integer.toString(City[0].BlueWarriorStation.get(0).MovedDistance));
        }
        if (me.getSource() == img16 && !City[0].BlueWarriorStation.isEmpty()) {
            imgbig.setImage(new Image("figure/" + WarriorType.WarriorNames[((Headquarters) City[0]).BlueWarriorStation.get(1).Type] + "_blue.png"));
            labeltype.setText(WarriorType.WarriorNames[((Headquarters) City[0]).BlueWarriorStation.get(1).Type]);
            labelparty.setText("blue");
            labelid.setText(Integer.toString(City[0].BlueWarriorStation.get(1).ProductionID));
            labellocation.setText("City0");
            labelhp.setText(Integer.toString(City[0].BlueWarriorStation.get(1).HP));
            labelattack.setText(Integer.toString(City[0].BlueWarriorStation.get(1).AttackValue));
            labelkill.setText(Integer.toString(City[0].BlueWarriorStation.get(1).NumberOfKilledWarrior));
            labelsteps.setText(Integer.toString(City[0].BlueWarriorStation.get(1).MovedDistance));
        }

    }

    private void headquartersReportLifeElements() {//50
        System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
        System.out.println(City[0].LifeElement + " elements in red headquarter");
        System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
        System.out.println(City[WorldProperty.NumberOfCity + 1].LifeElement + " elements in blue headquarter");
    }

    //private void holdBattlesAndWorkAfterBattles(){//40
    //}
    private void holdBattlesAndWorkAfterBattles() {
        int hihi = 1;
        while (hihi <= WorldProperty.NumberOfCity) {
            if (City[hihi].BlueWarriorStation.size() > 0 && City[hihi].RedWarriorStation.size() > 0) {
                System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                City[hihi].organizeBattle();

                if (City[hihi].BlueWarriorStation.get(0).Dead) {
                    if (City[hihi].LifeElement > 0) {
                        System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                        System.out.print(WorldProperty.PartyNames[City[hihi].RedWarriorStation.get(0).Party] + " " + WarriorType.WarriorNames[City[hihi].RedWarriorStation.get(0).Type] + " ");
                        System.out.println(City[hihi].RedWarriorStation.get(0).ProductionID + " earned " + City[hihi].LifeElement + " elements for his headquarter");

                    }
                    if (City[hihi].PartyOfLastRoundWinner == 0) {
                        if (!(City[hihi].Flag == 0)) {
                            System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                            City[hihi].payTribute();
                        }
                    } else {
                        City[hihi].PartyOfLastRoundWinner = 0;
                    }
                } else if (City[hihi].RedWarriorStation.get(0).Dead) {
                    if (City[hihi].LifeElement > 0) {
                        System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                        System.out.print(WorldProperty.PartyNames[City[hihi].BlueWarriorStation.get(0).Party] + " " + WarriorType.WarriorNames[City[hihi].BlueWarriorStation.get(0).Type] + " ");
                        System.out.println(City[hihi].BlueWarriorStation.get(0).ProductionID + " earned " + City[hihi].LifeElement + " elements for his headquarter");

                    }
                    if (City[hihi].PartyOfLastRoundWinner == 1) {
                        if (City[hihi].Flag != 1) {
                            System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));

                            City[hihi].payTribute();
                        }
                    } else {
                        City[hihi].PartyOfLastRoundWinner = 1;
                    }
                } else {
                    City[hihi].PartyOfLastRoundWinner = 3;
                }
            }
            hihi++;
        }

        int it9 = 1;
        int gg = WorldProperty.NumberOfCity;
        while (it9 <= WorldProperty.NumberOfCity) {
            if (City[it9].BlueWarriorStation.size() >= 1 && City[it9].RedWarriorStation.size() >= 1) {
                if (City[it9].RedWarriorStation.get(0).Dead) {
                    ((Headquarters) City[WorldProperty.NumberOfCity + 1]).rewardWarrior(City[it9].BlueWarriorStation.get(0), WorldProperty.rewardNumber);
                }
            }

            if (City[gg].BlueWarriorStation.size() >= 1 && City[gg].RedWarriorStation.size() >= 1) {
                if (City[gg].BlueWarriorStation.get(0).Dead) {
                    ((Headquarters) City[0]).rewardWarrior(City[gg].RedWarriorStation.get(0), WorldProperty.rewardNumber);
                }
            }
            it9++;
            gg--;
        }

        int sosad = 1;
        while (sosad <= WorldProperty.NumberOfCity) {
            if (City[sosad].BlueWarriorStation.size() >= 1 && City[sosad].RedWarriorStation.size() >= 1) {
                if (City[sosad].BlueWarriorStation.get(0).Dead) {
                    if (City[sosad].LifeElement > 0) {
                        ((Headquarters) City[WorldProperty.RED]).increaseLifeElement(City[sosad].popLifeElements());
                    }
                    City[sosad].removeWarrior(City[sosad].BlueWarriorStation.get(0));
                } else {
                    if (City[sosad].RedWarriorStation.get(0).Dead) {
                        if (City[sosad].LifeElement > 0) {
                            ((Headquarters) City[WorldProperty.NumberOfCity + 1]).increaseLifeElement(City[sosad].popLifeElements());
                        }
                        City[sosad].removeWarrior(City[sosad].RedWarriorStation.get(0));
                    }
                }
            }
            sosad++;
        }
    }

    private void warriorsFetchLifeElementsFromCity() {//30
        int i = 1;
        while (i <= WorldProperty.NumberOfCity) {
            if (City[i].RedWarriorStation.size() + City[i].BlueWarriorStation.size() == 1) {
                if (City[i].RedWarriorStation.size() == 1) {
                    int tmp = City[i].popLifeElements();
                    City[0].LifeElement += tmp;

                    System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                    System.out.println("red " + WarriorType.WarriorNames[City[i].RedWarriorStation.get(0).Type] + " " + City[i].RedWarriorStation.get(0).ProductionID + " earned " + tmp + " elements for his headquarter");

                } else {
                    int tmp = City[i].popLifeElements();
                    City[WorldProperty.NumberOfCity + 1].LifeElement += tmp;

                    System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                    System.out.println("blue " + WarriorType.WarriorNames[City[i].BlueWarriorStation.get(0).Type] + " " + City[i].BlueWarriorStation.get(0).ProductionID + " earned " + tmp + " elements for his headquarter");
                }
            }
            i++;
        }
    }

    public void ProduceLifeElements() {//20
        for (int i = 1; i <= WorldProperty.NumberOfCity; i++) {
            (City[i]).LifeElement += 10;
        }
    }

    public void marchWarriors() {//10
        int i = 1;
        while (i <= WorldProperty.NumberOfCity + 1) {
            if (City[i].BlueWarriorStation.size() > 0) {
                City[i - 1].addWarrior(City[i].BlueWarriorStation.get(0));
                City[i].removeWarrior(City[i].BlueWarriorStation.get(0));
            }
            i++;
        }

        int j = WorldProperty.NumberOfCity;
        while (j >= 0) {
            if (City[j].RedWarriorStation.size() > 0 && j != WorldProperty.NumberOfCity + 1) {
                City[j + 1].addWarrior(City[j].RedWarriorStation.get(0));
                City[j].removeWarrior(City[j].RedWarriorStation.get(0));
            }
            j--;
        }

        for (int hihi = 0; hihi <= WorldProperty.NumberOfCity + 1; hihi++) {
            if (City[hihi].RedWarriorStation.size() > 0 && City[hihi].RedWarriorStation.get(City[hihi].RedWarriorStation.size() - 1).Location < hihi) {
                City[hihi].RedWarriorStation.get(City[hihi].RedWarriorStation.size() - 1).move();
                warriorReportMarch(City[hihi], City[hihi].RedWarriorStation.get(City[hihi].RedWarriorStation.size() - 1));
            }
            if (City[hihi].BlueWarriorStation.size() > 0 && City[hihi].BlueWarriorStation.get(City[hihi].BlueWarriorStation.size() - 1).Location > hihi) {
                City[hihi].BlueWarriorStation.get(City[hihi].BlueWarriorStation.size() - 1).move();
                warriorReportMarch(City[hihi], City[hihi].BlueWarriorStation.get(City[hihi].BlueWarriorStation.size() - 1));
            }
        }
    }

    private void warriorReportMarch(City x, Warrior y) {
        System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));

        if (x.CityID == 0) {
            System.out.println("blue " + WarriorType.WarriorNames[y.Type] + " " + y.ProductionID + " reached red headquarter with " + y.HP + " elements and force " + y.AttackValue);

        } else if (x.CityID == WorldProperty.NumberOfCity + 1) {
            System.out.println("red " + WarriorType.WarriorNames[y.Type] + " " + y.ProductionID + " reached blue headquarter with " + y.HP + " elements and force " + y.AttackValue);

        } else {
            System.out.println(WorldProperty.PartyNames[y.Party] + " " + WarriorType.WarriorNames[y.Type] + " " + y.ProductionID + " marched to city " + x.CityID + " with " + y.HP + " elements and force " + y.AttackValue);

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        flagarr[0] = flag1;
        flagarr[1] = flag2;
        flagarr[2] = flag3;
        flagarr[3] = flag4;
        flagarr[4] = flag5;

        imgarrred[0] = img1;
        imgarrred[1] = img2;
        imgarrred[2] = img3;
        imgarrred[3] = img4;
        imgarrred[4] = img5;
        imgarrred[5] = img6;
        imgarrred[6] = img7;
        imgarrred[7] = img8;

        imgarrblue[0] = img9;
        imgarrblue[1] = img10;
        imgarrblue[2] = img11;
        imgarrblue[3] = img12;
        imgarrblue[4] = img13;
        imgarrblue[5] = img14;
        imgarrblue[6] = img15;
        imgarrblue[7] = img16;
    }

}
