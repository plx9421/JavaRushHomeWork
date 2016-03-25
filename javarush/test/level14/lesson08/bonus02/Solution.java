package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(reader.readLine());
        int n2 = Integer.parseInt(reader.readLine());
        int min = 1;
        if (n1 < n2 ) min = n1; else min = n2;

        int nod = min;
        for (int i = 1; i <= min; i++) {
            if ((n1%i == 0) && (n2%i == 0)) nod = i;
        }

        System.out.println(nod);

    }
}
