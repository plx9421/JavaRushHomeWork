package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();

        Scanner fileInput = new Scanner(new File(name));
        ArrayList<Integer> arrayList = new ArrayList<Integer>();


        while (fileInput.hasNext()){
            int inputInt = fileInput.nextInt();
            if (inputInt%2 == 0) arrayList.add(inputInt);
        }
        fileInput.close();

        Integer[] ar = arrayList.toArray(new Integer[arrayList.size()]);
        Arrays.sort(ar);

        for (Integer outInt : ar){
            System.out.println(outInt);
        }
    }
}
