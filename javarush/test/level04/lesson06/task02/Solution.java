package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++)
        {
            String nS1 = reader.readLine();
            int n1 = Integer.parseInt(nS1);
            if (n1 > max) max = n1;
        }

        System.out.println(max);
        //напишите тут ваш код

    }
}
