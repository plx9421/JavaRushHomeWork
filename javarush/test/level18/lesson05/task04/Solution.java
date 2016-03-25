package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();

        FileInputStream file1 = new FileInputStream(name1);
        FileOutputStream file2 = new FileOutputStream(name2);

        byte[] buffer1 = new byte[file1.available()];
        int count = file1.read(buffer1);

        byte[] buffer2 = new byte[buffer1.length];
        for (int i = 0; i < buffer1.length; i++) {
            buffer2[buffer2.length-i-1] = buffer1[i];
        }
        file2.write(buffer2);


        reader.close();
        file1.close();
        file2.close();

    }
}
