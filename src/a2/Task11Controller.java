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
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author WaiMan
 */
public class Task11Controller implements Initializable {

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
    private TextArea result;
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

    private ImageView[] flagarr = new ImageView[5];
    private ImageView[] imgarrred = new ImageView[8];
    private ImageView[] imgarrblue = new ImageView[8];

    public static TextArea tmp;
    public City[] City;
    private Service<Void> backgroundThread;

    public void runGame() {
        tmp = result;
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
                                    if (((Headquarters) City[0]).tryToProduceWarrior()) {
                                        result.appendText(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                                        System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                                        result.appendText(WorldProperty.PartyNames[0] + " " + WarriorType.WarriorNames[((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).Type] + " " + ((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).ProductionID + " born" + "\n");
                                        System.out.println(WorldProperty.PartyNames[0] + " " + WarriorType.WarriorNames[((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).Type] + " " + ((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).ProductionID + " born");
                                        img1.setImage(new Image("figure/" + WarriorType.WarriorNames[((Headquarters) City[0]).RedWarriorStation.get((((Headquarters) City[0]).RedWarriorStation).size() - 1).Type] + "_red.png"));
                                    }

                                    if (((Headquarters) City[WorldProperty.NumberOfCity + 1]).tryToProduceWarrior()) {
                                        result.appendText(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                                        System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                                        result.appendText(WorldProperty.PartyNames[1] + " " + WarriorType.WarriorNames[((Headquarters) City[WorldProperty.NumberOfCity + 1]).BlueWarriorStation.get((((Headquarters) City[WorldProperty.NumberOfCity + 1]).BlueWarriorStation).size() - 1).Type] + " " + ((Headquarters) City[WorldProperty.NumberOfCity + 1]).BlueWarriorStation.get((((Headquarters) City[WorldProperty.NumberOfCity + 1]).BlueWarriorStation).size() - 1).ProductionID + " born" + "\n");
                                        System.out.println(WorldProperty.PartyNames[1] + " " + WarriorType.WarriorNames[((Headquarters) City[WorldProperty.NumberOfCity + 1]).BlueWarriorStation.get((((Headquarters) City[WorldProperty.NumberOfCity + 1]).BlueWarriorStation).size() - 1).Type] + " " + ((Headquarters) City[WorldProperty.NumberOfCity + 1]).BlueWarriorStation.get((((Headquarters) City[WorldProperty.NumberOfCity + 1]).BlueWarriorStation).size() - 1).ProductionID + " born");
                                        img9.setImage(new Image("figure/" + WarriorType.WarriorNames[((Headquarters) City[WorldProperty.NumberOfCity + 1]).BlueWarriorStation.get((((Headquarters) City[WorldProperty.NumberOfCity + 1]).BlueWarriorStation).size() - 1).Type] + "_blue.png"));
                                    }
                                    break;

                                case 10:
                                    marchWarriors();
                                    if (((Headquarters) City[0]).checkOccupied()) {
                                        result.appendText(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                                        result.appendText("red headquarter was taken" + "\n");
                                        System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                                        System.out.println("red headquarter was taken");
                                        flag0.setImage(new Image("figure/flag_blue.png"));
                                    }

                                    if (((Headquarters) City[WorldProperty.NumberOfCity + 1]).checkOccupied()) {
                                        result.appendText(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                                        result.appendText("blue headquarter was taken" + "\n");
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

    private void headquartersReportLifeElements() {//50
        result.appendText(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
        result.appendText(City[0].LifeElement + " elements in red headquarter" + "\n");
        result.appendText(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
        result.appendText(City[WorldProperty.NumberOfCity + 1].LifeElement + " elements in blue headquarter" + "\n");

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
                result.appendText(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                City[hihi].organizeBattle();

                if (City[hihi].BlueWarriorStation.get(0).Dead) {
                    if (City[hihi].LifeElement > 0) {
                        result.appendText(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                        result.appendText(WorldProperty.PartyNames[City[hihi].RedWarriorStation.get(0).Party] + " " + WarriorType.WarriorNames[City[hihi].RedWarriorStation.get(0).Type] + " ");
                        result.appendText(City[hihi].RedWarriorStation.get(0).ProductionID + " earned " + City[hihi].LifeElement + " elements for his headquarter" + "\n");

                        System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                        System.out.print(WorldProperty.PartyNames[City[hihi].RedWarriorStation.get(0).Party] + " " + WarriorType.WarriorNames[City[hihi].RedWarriorStation.get(0).Type] + " ");
                        System.out.println(City[hihi].RedWarriorStation.get(0).ProductionID + " earned " + City[hihi].LifeElement + " elements for his headquarter");

                    }
                    if (City[hihi].PartyOfLastRoundWinner == 0) {
                        if (!(City[hihi].Flag == 0)) {
                            result.appendText(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                            System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                            City[hihi].payTribute();
                        }
                    } else {
                        City[hihi].PartyOfLastRoundWinner = 0;
                    }
                } else if (City[hihi].RedWarriorStation.get(0).Dead) {
                    if (City[hihi].LifeElement > 0) {
                        result.appendText(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                        result.appendText(WorldProperty.PartyNames[City[hihi].BlueWarriorStation.get(0).Party] + " " + WarriorType.WarriorNames[City[hihi].BlueWarriorStation.get(0).Type] + " ");
                        result.appendText(City[hihi].BlueWarriorStation.get(0).ProductionID + " earned " + City[hihi].LifeElement + " elements for his headquarter" + "\n");

                        System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                        System.out.print(WorldProperty.PartyNames[City[hihi].BlueWarriorStation.get(0).Party] + " " + WarriorType.WarriorNames[City[hihi].BlueWarriorStation.get(0).Type] + " ");
                        System.out.println(City[hihi].BlueWarriorStation.get(0).ProductionID + " earned " + City[hihi].LifeElement + " elements for his headquarter");

                    }
                    if (City[hihi].PartyOfLastRoundWinner == 1) {
                        if (City[hihi].Flag != 1) {
                            result.appendText(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
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
                    result.appendText(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                    result.appendText("red " + WarriorType.WarriorNames[City[i].RedWarriorStation.get(0).Type] + " " + City[i].RedWarriorStation.get(0).ProductionID + " earned " + tmp + " elements for his headquarter" + "\n");

                    System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                    System.out.println("red " + WarriorType.WarriorNames[City[i].RedWarriorStation.get(0).Type] + " " + City[i].RedWarriorStation.get(0).ProductionID + " earned " + tmp + " elements for his headquarter");

                } else {
                    int tmp = City[i].popLifeElements();
                    City[WorldProperty.NumberOfCity + 1].LifeElement += tmp;
                    result.appendText(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
                    result.appendText("blue " + WarriorType.WarriorNames[City[i].BlueWarriorStation.get(0).Type] + " " + City[i].BlueWarriorStation.get(0).ProductionID + " earned " + tmp + " elements for his headquarter" + "\n");

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
        result.appendText(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));
        System.out.print(Clock.customFormat(WorldClock.getTime(), WorldClock.getMinute()));

        if (x.CityID == 0) {
            result.appendText("blue " + WarriorType.WarriorNames[y.Type] + " " + y.ProductionID + " reached red headquarter with " + y.HP + " elements and force " + y.AttackValue + "\n");
            System.out.println("blue " + WarriorType.WarriorNames[y.Type] + " " + y.ProductionID + " reached red headquarter with " + y.HP + " elements and force " + y.AttackValue);

        } else if (x.CityID == WorldProperty.NumberOfCity + 1) {
            result.appendText("red " + WarriorType.WarriorNames[y.Type] + " " + y.ProductionID + " reached blue headquarter with " + y.HP + " elements and force " + y.AttackValue + "\n");
            System.out.println("red " + WarriorType.WarriorNames[y.Type] + " " + y.ProductionID + " reached blue headquarter with " + y.HP + " elements and force " + y.AttackValue);

        } else {
            result.appendText(WorldProperty.PartyNames[y.Party] + " " + WarriorType.WarriorNames[y.Type] + " " + y.ProductionID + " marched to city " + x.CityID + " with " + y.HP + " elements and force " + y.AttackValue + "\n");
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
