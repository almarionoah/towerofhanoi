/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Author A.S. Noah
 */
package towerofhanoi;

import java.util.Hashtable;
import java.util.TreeMap;
import java.util.Vector;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author AlmarioNoah
 */
public class TowerOfHanoi extends Application {
    
    private SequentialTransition animation;
    private final Hashtable<String,Boolean> hasRings; //maps whether a pole has a ring or not
    private int ringCounterPole1, //keeps track of the number of rings per pole
                ringCounterPole2,
                ringCounterPole3,
                numberOfDiscs;



    public int getNumberOfDiscs() {
        return numberOfDiscs;
    }

    public void setNumberOfDiscs(int numberOfDiscs) {
        this.numberOfDiscs = numberOfDiscs;
    }

    
    public int getRingCounterPole1() {
        return ringCounterPole1;
    }

    public void setRingCounterPole1(int ringCounterPole1) {
        this.ringCounterPole1 = ringCounterPole1;
    }

    public int getRingCounterPole2() {
        return ringCounterPole2;
    }

    public void setRingCounterPole2(int ringCounterPole2) {
        this.ringCounterPole2 = ringCounterPole2;
    }

    public int getRingCounterPole3() {
        return ringCounterPole3;
    }

    public void setRingCounterPole3(int ringCounterPole3) {
        this.ringCounterPole3 = ringCounterPole3;
    }
    
    public TowerOfHanoi(){
     hasRings = new Hashtable<String,Boolean>();
    }

    
    public TowerOfHanoi(int numberOfDiscs) {
        animation = new SequentialTransition();
        hasRings = new Hashtable<String,Boolean>();
        hasRings.put("pole1", true);
        hasRings.put("pole2", false);
        hasRings.put("pole3", false);
        ringCounterPole1 = numberOfDiscs;
        ringCounterPole2 = 0;
        ringCounterPole3 = 0;
        setNumberOfDiscs(numberOfDiscs);
    }
    
    
    
    
    @Override
    public void start(Stage stage)throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMenu.fxml"));;
                
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    void move(Rectangle ring, Line CurrentPole,Line DestinationPole)throws InterruptedException {
        //moves a disc to a new pole
        int xDiff = 0, //differentials
            yDiff = 0,
            zDiff = 0;
        
        switch(DestinationPole.getId())
        { 
            case "pole1":
                xDiff = 100;
                switch(ring.getId())//Decides how each ring is layed out on pole1
                {
                    case "ring3":
                        yDiff = 120;
                        break;
                    case "ring4": 
                        yDiff = 100;
                        break;
                }
                zDiff = 80;
                if(!(hasRings.get(CurrentPole.getId())))
                {
                  hasRings.replace(CurrentPole.getId(), false);
                }
                ringCounterPole1++;
                if(CurrentPole.getId().equals("pole2"))
                {
                    ringCounterPole2--;
                }
                if(CurrentPole.getId().equals("pole3"))
                {
                    ringCounterPole3--;
                }
                break;
            case "pole2": 
                xDiff = 100;
                switch(ring.getId())//Decides how each ring is layed out on pole2
                {
                    case "ring1":
                     yDiff = 250;
                     zDiff = 185;
                    
                    hasRings.replace("pole2", true);
                    break;
                    case "ring2":
                    yDiff = 180;
                    if(hasRings.get("pole2"))
                    {
                      zDiff = 180;
                    }
                    hasRings.replace("pole2", true);
                        break;
                    case "ring3": 
                     yDiff = 150;
                     if(!hasRings.get("pole2"))
                     {
                      zDiff = 60;
                     }
                     if(hasRings.get("pole2") && CurrentPole.getId().equals("pole1"))
                     {
                         zDiff = 180;
                     }

                     hasRings.replace("pole2", true);
                     break;
                    case "ring4": 
                     yDiff = 100;
                     if(CurrentPole.getId().equals("pole3") && ringCounterPole2 < 3)
                     {
                      zDiff = 80;
                     }
                     else
                     {                     
                         zDiff = 180;
                     }
                hasRings.replace("pole2", true);
                     break;
                }
                if(!(hasRings.get(CurrentPole.getId())))
                {
                  hasRings.replace(CurrentPole.getId(), false);
                }
                ringCounterPole2++;
                if(CurrentPole.getId().equals("pole1"))
                {
                    ringCounterPole1--;
                }
                if(CurrentPole.getId().equals("pole3"))
                {
                    ringCounterPole3--;
                }
                break;
            case "pole3":
                xDiff = 100;
                switch(ring.getId()){ //Decides how each ring is layed out on pole3
                    case "ring2":
                    yDiff = 170;
                    if(!hasRings.get("pole3") || (ringCounterPole3 == 0))
                     {
                      zDiff = 100;
                     }
                     hasRings.replace("pole3", true);
                     break;
                    case "ring3": 
                    yDiff = 160;
                    if(hasRings.get("pole3"))
                     {
                      zDiff = 100;
                     }
                     hasRings.replace("pole3", true);
                     break;
                    case "ring4":
                    yDiff = 80;
                    if(hasRings.get("pole3"))
                    {
                        zDiff = 100;
                    }
                    if(ringCounterPole3 == 0) //test whether pole has rings
                    {
                        zDiff = 0;
                    }
                    hasRings.replace("pole3", true);
                    break;
                }
                if(!(hasRings.get(CurrentPole.getId())))
                {
                  hasRings.replace(CurrentPole.getId(), false);
                }
                ringCounterPole3++;
                if(CurrentPole.getId().equals("pole1"))
                {
                    ringCounterPole1--;
                }
                if(CurrentPole.getId().equals("pole2"))
                {
                    ringCounterPole2--;
                }
                break;
        }

        setAnimation(xDiff,yDiff,zDiff,DestinationPole,ring);
                
    }

    void setAnimation(int x,int y,int z,Line Destination,Rectangle SelectedRing)
    {
        TranslateTransition moveToY = new TranslateTransition(Duration.seconds(1),SelectedRing);
        moveToY.setToY(Destination.getEndY()- y);
        //horizontal transition
        TranslateTransition moveToX = new TranslateTransition(Duration.seconds(1),SelectedRing);
        moveToX.setToX(Destination.getLayoutX()-x);
        //resting place i.e. stopping the movement
        TranslateTransition moveToZ = new TranslateTransition(Duration.seconds(1),SelectedRing);
        moveToZ.setToY(Destination.getLayoutY()-z);
        
        
        animation.getChildren().addAll(
         moveToY,
         moveToX,
         moveToZ
        );
    }
    
    void showSolution() {
        animation.play();
    }
        
}
