package com.javarush.test.level22.lesson18.big01;

import junit.framework.TestCase;


/**
 * Created by Alexey on 02.02.2016.
 */
public class FieldTest extends TestCase {

    public void testRemoveFullLines() throws Exception {
        Field f = new Field(10,20);
        int[][] m = f.getMatrix();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                m[i][j] = 1;
            }
        }

        f.removeFullLines();

        m = f.getMatrix();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(m[i][j]);
            }
            System.out.println();
        }




    }
}