package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
*/

import javax.swing.*;
import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nS1 = reader.readLine();
        String nS2 = reader.readLine();

        int n1 = Integer.parseInt(nS1);

        int n2 = Integer.parseInt(nS2);

        if (n1 < n2) System.out.println(n1); else System.out.println(n2);


    }
}