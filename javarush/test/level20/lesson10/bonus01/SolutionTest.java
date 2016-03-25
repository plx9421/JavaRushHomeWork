package com.javarush.test.level20.lesson10.bonus01;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alexey on 17.02.2016.
 */
public class SolutionTest
{

    @Test(timeout = 10000)
    public void testGetNumbers() throws Exception
    {
        int[] expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153};
        int[] actual = Solution.getNumbers(912985154);
        assertArrayEquals(expected, actual);
    }
}

//    public static void main(String[] args)
//    {
//        long memoryStart = Runtime.getRuntime().freeMemory();
//        Long t0 = System.currentTimeMillis();
//
//        int[] a = getNumbers(10000000);
//        for (int i = 0; i < a.length; i++)
//        {
//            if (a[i] != 0) System.out.print(a[i] + " ");
//        }
//
//        System.out.println();
//        long memoryEnd = Runtime.getRuntime().freeMemory();
//        System.out.println((memoryStart - memoryEnd) / 1024 + " KBytes"); // итог получаем байты.
//
//        Long t1 = System.currentTimeMillis();
//        System.out.println("Time need to create the arrray = " + ((t1 - t0) / 1));
//
//
//    }