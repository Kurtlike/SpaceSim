package org.kurtlike.physics;

import org.kurtlike.bodies.Body;

import java.util.ArrayList;

public class SystemGravity {
    private ArrayList<Body> bodies;
    public static final double G = 6.67 * Math.pow(10, -11);
    public SystemGravity(){
        bodies = new ArrayList<>();
    }
    public void addBody(Body body){
        bodies.add(body);
    }
    public ArrayList<Body> getBodies() {
        return bodies;
    }
    public void updateCoordinates(double time){
        for(Body b: bodies){

           for (Body nB: bodies){
               if(!b.equals(nB)) {
                   b.setXAcceleration(getNewXAcceleration(b, nB));
                   b.setYAcceleration(getNewYAcceleration(b, nB));
               }
           }
           b.setXSpeed(getNewXSpeed(b.getXSpeed(),b.getXAcceleration(), time));
           b.setYSpeed(getNewYSpeed(b.getYSpeed(),b.getYAcceleration(), time));
           b.setX(getNewXCoordinate(b.getX(),b.getXSpeed(),b.getXAcceleration(), time));
           b.setY(getNewYCoordinate(b.getY(),b.getYSpeed(),b.getYAcceleration(), time));
        }

    }

    private double getNewXAcceleration(Body body1, Body body2){
        double a =  body1.getX() - body2.getX();
        double b = body1.getY() - body2.getY();
        double c = Math.sqrt(Math.pow(b, 2) + Math.pow(a, 2));
        return G  * body2.getMass() * a / Math.pow(c, 3);
    }
    private double getNewYAcceleration(Body body1, Body body2){
        double a =  body1.getX() - body2.getX();
        double b = body1.getY() - body2.getY();
        double c = Math.sqrt(Math.pow(b, 2) + Math.pow(a, 2));
        return G  * body2.getMass() * b / Math.pow(c, 3);
    }
    private double getNewXSpeed(double XStartSpeed, double XAcceleration, double time){
        return XStartSpeed + XAcceleration * time;
    }
    private double getNewYSpeed(double YStartSpeed, double YAcceleration, double time){
        return YStartSpeed + YAcceleration * time;
    }
    private double getNewXCoordinate(double xCoordinate, double xSpeed, double xAcceleration, double time){
        return  xCoordinate + xSpeed * time + xAcceleration * Math.pow(time, 2) / 2;
    }
    private double getNewYCoordinate(double yCoordinate, double ySpeed, double yAcceleration, double time){
        return  yCoordinate + ySpeed * time + yAcceleration * Math.pow(time, 2) / 2;
    }
}
