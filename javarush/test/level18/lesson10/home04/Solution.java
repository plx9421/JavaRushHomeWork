package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
        FileInputStream f11 = new FileInputStream(fileName);
        byte[] buff11 = new byte[f11.available()];
        f11.read(buff11);
        f11.close();

        FileInputStream f2 = new FileInputStream(reader.readLine());
        FileOutputStream f12 = new FileOutputStream(fileName);

        byte[] buff12 = new byte[f2.available()];
        f2.read(buff12);
        f12.write(buff12);
        f12.write(buff11);

        reader.close();
        f2.close();
        f12.close();

    }
}
