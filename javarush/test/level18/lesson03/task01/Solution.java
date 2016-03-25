package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        FileInputStream file = new FileInputStream(name);
        int max = Integer.MIN_VALUE;
        int n = 0;
        while (file.available() != 0) {
            n = file.read();
            if (n > max) max = n;
        }
        file.close();

        System.out.println(max);
    }
}
