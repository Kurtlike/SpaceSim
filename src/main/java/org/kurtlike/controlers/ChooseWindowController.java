package org.kurtlike.controlers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import org.kurtlike.bodies.Body;

import java.net.URL;
import java.util.ResourceBundle;

public class ChooseWindowController {
    @FXML
    private Pane choosePane;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField name;

    @FXML
    private Button add;

    @FXML
    private Button cancel;

    @FXML
    private TextField mass;

    @FXML
    private TextField xCoordinate;

    @FXML
    private TextField xSpeed;

    @FXML
    private TextField xAcceleration;

    @FXML
    private TextField yCoordinate;

    @FXML
    private TextField ySpeed;

    @FXML
    private TextField yAcceleration;

    @FXML
    void initialize() {
       

    }
    public Pane getChoosePane() {
        return choosePane;
    }

    public void setChoosePane(Pane choosePane) {
        this.choosePane = choosePane;
    }

    public ResourceBundle getResources() {
        return resources;
    }

    public void setResources(ResourceBundle resources) {
        this.resources = resources;
    }

    public URL getLocation() {
        return location;
    }

    public void setLocation(URL location) {
        this.location = location;
    }

    public String getName() {
        return name.getText();
    }

    public Button getAdd() {
        return add;
    }


    public Button getCancel() {
        return cancel;
    }


    public double getMass() {
        return Double.parseDouble(mass.getText());
    }

    public double getXCoordinate() {
        return  Double.parseDouble(xCoordinate.getText());
    }

    public double getXSpeed() {
        return Double.parseDouble(xSpeed.getText());
    }


    public double getXAcceleration() {
        return  Double.parseDouble(xAcceleration.getText());
    }



    public double getYCoordinate() {
        return  Double.parseDouble(yCoordinate.getText());
    }


    public double getYSpeed() {
        return  Double.parseDouble(ySpeed.getText());
    }



    public double getYAcceleration() {
        return  Double.parseDouble(yAcceleration.getText());
    }


}
