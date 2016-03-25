package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] a = new int[256];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        FileInputStream file = new FileInputStream(name);

        int n = 0;
        while (file.available() != 0) {
            n = file.read();
            a[n]++;
        }
        file.close();

        int max = Integer.MIN_VALUE;
        for (int b : a) {
            if (b > max) max = b;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] == max) System.out.print(i + " ");
        }


    }
}
