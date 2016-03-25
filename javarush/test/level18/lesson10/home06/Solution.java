package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream f1 = new FileInputStream(args[0]);

        int[] resArr = new int[256];
        while (f1.available() > 0)
        {
            resArr[f1.read()]++;
        }
        for (int i = 0; i < resArr.length; i++)
        {
            if (resArr[i] == 0) continue;
            System.out.println((char) i + " " + resArr[i]);
        }

        f1.close();

    }
}
