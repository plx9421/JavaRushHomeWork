package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Alexey on 31.01.2016.
 */
public class Hippodrome {
    private ArrayList<Horse> horses = new ArrayList<Horse>();

    public ArrayList<Horse> getHorses() {
        return horses;
    }

    public static Hippodrome game;

    public void move() {
        for (Horse h : horses) {
            h.move();
        }
    }

    public void print() {
        for (Horse h : horses) {
            h.print();
        }
        System.out.println();
        System.out.println();
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner() {
        Horse result = null;
        for (Horse h : horses) {
            if (result == null) result = h;
            if (h.getDistance() > result.getDistance()) result = h;
        }
        return result;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome();
        Horse h1 = new Horse("Sleven", 3, 0);
        Horse h2 = new Horse("Lucky", 3, 0);
        Horse h3 = new Horse("Gomer", 3, 0);

        game.getHorses().add(h1);
        game.getHorses().add(h2);
        game.getHorses().add(h3);

        game.run();

        game.printWinner();

    }
}
