package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.charset.Charset;


/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(args[0]);
             FileOutputStream outputStream = new FileOutputStream(args[1])) {

            while (inputStream.available() > 0) {

                byte[] buffer = new byte[inputStream.available()];
                int count = inputStream.read(buffer);

                String s = new String(buffer, Charset.forName("UTF-8"));

                buffer = s.getBytes(Charset.forName("Windows-1251"));
                outputStream.write(buffer);
            }
        }
    }
}
