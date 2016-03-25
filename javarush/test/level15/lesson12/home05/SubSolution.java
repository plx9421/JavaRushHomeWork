package com.javarush.test.level15.lesson12.home05;

/**
 * Created by Alexey on 01.11.2015.
 */
public class SubSolution extends Solution {
    public SubSolution() {
    }

    public SubSolution(int i) {
        super(i);
    }

    public SubSolution(String s) {
        super(s);
    }

    protected SubSolution(int a, int b) {
        super(a, b);
    }

    protected SubSolution(String a, String b) {
        super(a, b);
    }

    protected SubSolution(Double a, Double b) {
        super(a, b);
    }

    SubSolution(int a, int b, int c) {
        super(a, b, c);
    }

    SubSolution(Double a, Double b, Double c) {
        super(a, b, c);
    }

    SubSolution(String a, String b, String c) {
        super(a, b, c);
    }

    private SubSolution(Integer a){}
    private SubSolution(Character c){}
    private SubSolution(Double d){}

}
