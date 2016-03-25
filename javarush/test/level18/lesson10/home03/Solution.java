package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream f1 = new FileOutputStream(reader.readLine());
        FileInputStream f2 = new FileInputStream(reader.readLine());
        FileInputStream f3 = new FileInputStream(reader.readLine());

        byte[] buff = new byte[1000];
        while (f2.available() > 0) {
            int count = f2.read(buff);
            f1.write(buff, 0, count);
        }
        while (f3.available() > 0) {
            int count = f3.read(buff);
            f1.write(buff, 0, count);
        }

        reader.close();
        f1.close();
        f2.close();
        f3.close();

    }
}
