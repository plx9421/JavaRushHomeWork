package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fi = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fo = new BufferedWriter(new FileWriter(reader.readLine()));

        while (fi.ready()) {
            String buff = fi.readLine();
            String[] aStr = buff.split("[,;:.!?\\s]+");
            for (int i = 0; i < aStr.length; i++) {
                if (aStr[i].matches("\\b[0-9]+\\b")) {
                    fo.write(aStr[i] + " ");
                }
            }
        }
    reader.close();
    fi.close();
    fo.close();
}
}
