package com.javarush.test.level07.lesson06.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* Самая длинная строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую длинную строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> s = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            s.add(scanner.nextLine());
        }
        int max = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).length() > max) {
                max = s.get(i).length();
            }
        }

        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).length() == max) {
                System.out.println(s.get(i));
            }
        }


    }
}
