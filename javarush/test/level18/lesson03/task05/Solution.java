package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
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

        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) System.out.print(i + " ");
        }
    }
}

