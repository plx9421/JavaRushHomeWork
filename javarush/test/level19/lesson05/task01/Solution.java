package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fi = new FileReader(reader.readLine());
        FileWriter fo = new FileWriter(reader.readLine());

        while (fi.ready()) {
            fi.read();
            if (fi.ready())fo.write(fi.read());
        }
        reader.close();
        fi.close();
        fo.close();
    }
}
