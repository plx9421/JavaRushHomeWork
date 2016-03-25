package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] ar1 = new int[3];
        int ia = 0;
        for (int i = 0; i < 3; i++)
        {
            String nS1 = reader.readLine();
            ar1[i] = Integer.parseInt(nS1);
        }

        for (int i = 0; i < 3; i++)
        {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < 3; j++)
            {
                if ((ar1[j] > max))
                {
                    ia = j;
                    max = ar1[j];
                }
            }
            System.out.println(max);
            ar1[ia] = Integer.MIN_VALUE;
        }


    }
}
