package com.javarush.test.level21.lesson16.big01;

/**
 * Created by Alexey on 31.01.2016.
 */
public class Horse {
    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
    public void move (){
        distance += speed * Math.random();
    }
    public void print(){
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < distance; i++) {
            result.append(".");
        }
        result.append(name);
        System.out.println(result);
    }

    private String name;
    private double speed;
    private double distance;
}
