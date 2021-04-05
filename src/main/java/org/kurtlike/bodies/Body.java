package org.kurtlike.bodies;

import java.util.Objects;

public class Body {
    public Body(){
        x = 0;
        y = 0;
        mass = 0;
        xSpeed = 0;
        ySpeed = 0;
        xAcceleration = 0;
        yAcceleration = 0;
        name = "null";
    }

    public Body(String name, double x, double y, double mass, double xSpeed, double ySpeed, double xAcceleration, double yAcceleration) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.mass = mass;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.xAcceleration = xAcceleration;
        this.yAcceleration = yAcceleration;
    }

    private String name;
    private double x;
    private double y;
    private double mass;
    private double xSpeed;
    private double ySpeed;
    private double xAcceleration;
    private double yAcceleration;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getMass() {
        return mass;
    }
    public void setMass(double mass) {
        this.mass = mass;
    }
    public double getXSpeed() {
        return xSpeed;
    }
    public void setXSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }
    public double getYSpeed() {
        return ySpeed;
    }
    public void setYSpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }
    public double getXAcceleration() {
        return xAcceleration;
    }
    public void setXAcceleration(double xAcceleration) {
        this.xAcceleration = xAcceleration;
    }
    public double getYAcceleration() {
        return yAcceleration;
    }
    public void setYAcceleration(double yAcceleration) {
        this.yAcceleration = yAcceleration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Body body = (Body) o;
        return Double.compare(body.getX(), getX()) == 0 &&
                Double.compare(body.getY(), getY()) == 0 &&
                Double.compare(body.getMass(), getMass()) == 0 &&
                Double.compare(body.xSpeed, xSpeed) == 0 &&
                Double.compare(body.ySpeed, ySpeed) == 0 &&
                Double.compare(body.xAcceleration, xAcceleration) == 0 &&
                Double.compare(body.yAcceleration, yAcceleration) == 0 &&
                getName().equals(body.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getX(), getY(), getMass(), xSpeed, ySpeed, xAcceleration, yAcceleration);
    }
}
