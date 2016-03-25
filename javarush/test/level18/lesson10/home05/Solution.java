package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f1 = new BufferedReader(new FileReader(reader.readLine()));

        FileWriter f2 = new FileWriter(reader.readLine());

        StringBuffer strBuff = new StringBuffer();
        while (f1.ready())
        {
            String[] bt = f1.readLine().split(" ");
            for (int i = 0; i < bt.length; i++)
            {
                int iOut = Math.round(Float.parseFloat(bt[i]));
                f2.write(iOut + " ");
            }

        }
        reader.close();
        f1.close();
        f2.close();
    }
}
