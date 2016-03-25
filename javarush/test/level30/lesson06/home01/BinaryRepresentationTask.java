package com.javarush.test.level30.lesson06.home01;

import java.util.concurrent.RecursiveTask;

/**
 * Created by Alexey on 09.03.2016.
 */
public class BinaryRepresentationTask extends RecursiveTask {

    private int x;

    public BinaryRepresentationTask(int i) {
        this.x = i;
    }

    @Override
    protected String compute() {

        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        BinaryRepresentationTask bn;
        if (b > 0) {

            bn = new BinaryRepresentationTask(b);
            bn.fork();
            return bn.join() + result;
        } else return result;


    }
}
