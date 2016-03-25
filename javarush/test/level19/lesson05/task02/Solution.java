package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fr = new BufferedReader(new FileReader(reader.readLine()));
        int count = 0;
        while (fr.ready()){
            String buff = fr.readLine();
            String[] aStr = buff.split("[,;:.!?\\s]+");
            for (int i = 0; i < aStr.length; i++) {
                if ("world".equals(aStr[i].toLowerCase())) count++;
            }
        }
        System.out.println(count);
        reader.close();
        fr.close();
    }
}
