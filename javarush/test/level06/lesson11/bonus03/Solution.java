package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] n = new int[5];

        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            n[i] = Integer.parseInt(reader.readLine());
        }

        int m1 = Integer.MAX_VALUE;
        int a1 = 0;
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (n[j] < m1)
                {
                    m1 = n[j];
                    a1 = j;
                }
            }
            System.out.println(m1);
            n[a1] = Integer.MAX_VALUE;
            m1 = Integer.MAX_VALUE;
        }


        //напишите тут ваш код
    }
}
