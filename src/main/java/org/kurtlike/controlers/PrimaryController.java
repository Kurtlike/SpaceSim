package org.kurtlike.controlers;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import org.kurtlike.bodies.Body;
import org.kurtlike.physics.SystemGravity;

import java.io.IOException;


public class PrimaryController  {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Canvas canvas = new Canvas();

    @FXML
    private Slider scale;

    @FXML
    private Slider speed;

    @FXML
    private Label scaleLabel;

    @FXML
    private Label speedLabel;

    @FXML
    private Pane legend;

    @FXML
    private Label scaleValue;

    public AnchorPane getMainPane() {
        return mainPane;
    }

    public void setMainPane(AnchorPane mainPane) {
        this.mainPane = mainPane;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public Slider getScale() {
        return scale;
    }

    public void setScale(Slider scale) {
        this.scale = scale;
    }

    public double getSpeed() {
        return speed.getValue();
    }

    public void setSpeed(Slider speed) {
        this.speed = speed;
    }

    public Label getScaleLabel() {
        return scaleLabel;
    }

    public void setScaleLabel(Label scaleLabel) {
        this.scaleLabel = scaleLabel;
    }

    public Label getSpeedLabel() {
        return speedLabel;
    }

    public void setSpeedLabel(Label speedLabel) {
        this.speedLabel = speedLabel;
    }

    public Pane getLegend() {
        return legend;
    }

    public void setLegend(Pane legend) {
        this.legend = legend;
    }

    public Label getScaleValue() {
        return scaleValue;
    }

    public void setScaleValue(Label scaleValue) {
        this.scaleValue = scaleValue;
    }

    public Line getScaleLine() {
        return scaleLine;
    }

    public void setScaleLine(Line scaleLine) {
        this.scaleLine = scaleLine;
    }

    @FXML
    private Line scaleLine;

    @FXML
    void initialize() {

    }


}
