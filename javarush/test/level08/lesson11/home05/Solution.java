package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        //String s = " и это тоже пройдет";
        //String s = "  мама     мыла раму.   ";
        char[] c = s.toCharArray();
        boolean flagWord = true;
        for (int i = 0; i < c.length; i++) {
            if (flagWord) {
                 c[i] = Character.toUpperCase(c[i]);
                flagWord = false;
            }
            if (c[i] == ' ') flagWord = true;
        }

        System.out.println(c);
        //напишите тут ваш код
    }


}
