package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fi = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fo = new BufferedWriter(new FileWriter(reader.readLine()));

        while (fi.ready()) {
            int buff = fi.read();
            if ('.' == buff) buff = '!';
            fo.write(buff);
        }
        reader.close();
        fi.close();
        fo.close();

    }
}
