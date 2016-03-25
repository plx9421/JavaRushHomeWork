package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
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

        int min = Integer.MAX_VALUE;
        for (int b : a) {
            if ((b != 0) && (b < min)) min = b;
        }

        for (int i = 0; i < a.length; i++) {

            if ((a[i] != 0) && (a[i] == min)) System.out.print(i + " ");
        }
    }
}
