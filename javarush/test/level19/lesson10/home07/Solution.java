package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader brf1 = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        FileWriter fo2 = new FileWriter(args[1]);
        boolean fw = false;
        while (brf1.ready())
        {
            String[] str = brf1.readLine().split(" ");
            for (int i = 0; i < str.length; i++)
            {
                if (str[i].length() > 6)
                {
                    if (fw) fo2.write(',');
                    fo2.write(str[i]);
                    fw = true;
                }
            }
        }
        brf1.close();
        fo2.close();
    }
}
