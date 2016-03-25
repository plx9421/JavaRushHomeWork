package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length != 3) System.exit(-1);
        if (!(("-e".equals(args[0])) || ("-d".equals(args[0])))) System.exit(-1);

        FileInputStream fi = new FileInputStream(args[1]);
        FileOutputStream fo = new FileOutputStream(args[2]);

        byte[] buff = new byte[1000];
        while (fi.available() > 0) {
            int count = fi.read(buff);
            for (int i = 0; i < buff.length; i++) {
                if ("-e".equals(args[0])) {
                    buff[i] = (byte) (buff[i] ^ 85);
                } else {
                    buff[i] = (byte) (buff[i] ^ 85);
                }
            }
            fo.write(buff, 0, count);
        }
        fi.close();
        fo.close();

    }

}
