package com.javarush.test.level04.lesson16.home02;

import java.io.*;
import java.util.Scanner;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (((a < b) && (a > c)) || ((a > b) && (a < c))) System.out.println(a);
        if (((b < a) && (b > c)) || ((b > a) && (b < c))) System.out.println(b);
        if (((c < b) && (c > a)) || ((c > b) && (c < a))) System.out.println(c);




    }
}
