package org.kurtlike;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import org.kurtlike.bodies.Body;
import org.kurtlike.controlers.ChooseWindowController;
import org.kurtlike.controlers.PrimaryController;
import org.kurtlike.physics.SystemGravity;

import java.io.IOException;


public class ControllerManager {


    private Parent primaryRoot;
    private Parent chooseRoot;
    private FXMLLoader primaryFxml;
    private FXMLLoader chooseFxml;
    private PrimaryController primaryController;
    private ChooseWindowController chooseWindowController;
    private SystemGravity systemGravity;

    private boolean dialogEvent = false;
    public ControllerManager() throws IOException {
        primaryFxml = new FXMLLoader(App.class.getResource("/org/kurtlike/primary.fxml"));
        chooseFxml = new FXMLLoader(App.class.getResource("/org/kurtlike/chooseWindow.fxml"));
        primaryRoot = (Parent)primaryFxml.load();
        chooseRoot = (Parent)chooseFxml.load();
        primaryController = primaryFxml.getController();
        chooseWindowController = chooseFxml.getController();
        systemGravity = new SystemGravity();
    }

    public void animationStart(){
        GraphicsContext graphicsContext = primaryController.getCanvas().getGraphicsContext2D();
        Image sun = new Image("sun.png",100,100,true,false);
        Image background = new Image("space.png",1280,720,true,false);
        addBody();
        SpaceAnimation spaceAnimation = new SpaceAnimation(30) {

            @Override
            public void  handle() {
                if(!dialogEvent) {
                    systemGravity.updateCoordinates((this.getFrameTime()/10000000000d)*primaryController.getSpeed()); //to seconds from nano seconds
                    graphicsContext.drawImage(background,0,0);
                    for(Body body:systemGravity.getBodies()) {
                        graphicsContext.drawImage(sun, body.getX(), body.getY());
                    }

                }
            }
        };
        spaceAnimation.start();
    }


    private void addBody(){
        Runnable runnable = () -> primaryController.getCanvas().setOnMouseClicked(event -> {
            dialogEvent = true;

            primaryController.getMainPane().getChildren().add(chooseRoot);
            chooseWindowController.getAdd().setOnAction(event1 -> {
                Body addedBody = new Body(
                        chooseWindowController.getName(),
                        chooseWindowController.getXCoordinate(),
                        chooseWindowController.getYCoordinate(),
                        chooseWindowController.getMass() * Math.pow(10,10),
                        chooseWindowController.getXSpeed(),
                        chooseWindowController.getYSpeed(),
                        chooseWindowController.getXAcceleration(),
                        chooseWindowController.getYAcceleration());
                systemGravity.addBody(addedBody);
                dialogEvent = false;
                primaryController.getMainPane().getChildren().remove(chooseRoot);

            });
        });
        Thread thread = new Thread(runnable,"mouseListener");
        thread.start();
    }

    public FXMLLoader getPrimaryFxml() {
        return primaryFxml;
    }
    public Parent getRoot() {
        return primaryRoot;
    }
}
