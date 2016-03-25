package com.javarush.test.level18.lesson10.bonus03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine(); //читаем строку с клавиатуры
        bufferedReader.close();

//        String fileName = "C:\\tmp\\result.txt";

        List<String> workFileInMap = new ArrayList<String>();

        BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        while (fr.ready())
        {
            String str = fr.readLine();
            if ("".equals(str)) continue;
            workFileInMap.add(str);
        }
        fr.close();

        int uidRecord = Integer.parseInt(args[1]);
        switch (args[0])
        {
            case "-d":
            {
                if (args.length > 1)
                {
                    for (int i = 0; i < workFileInMap.size(); i++)
                    {
                        int id = Integer.parseInt(workFileInMap.get(i).substring(0, 8).trim());
                        if (uidRecord == id)
                        {
                            workFileInMap.remove(i);
                            i--;
                        }
                    }
                }
            }
            case "-u":
            {
                if (args.length > 4)
                {
                    String strBuffer = String.format("%1$-8d%2$-30s%3$-8s%4$-4s", uidRecord, args[2], args[3], args[4]);
                    for (int i = 0; i < workFileInMap.size(); i++)
                    {
                        int id = Integer.parseInt(workFileInMap.get(i).substring(0, 8).trim());
                        if (uidRecord == id)
                        {
                            workFileInMap.set(i, strBuffer);
                        }
                    }
                }
            }

        }

        BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, false));
        for (int i = 0; i < workFileInMap.size(); i++)
            fw.write(workFileInMap.get(i) + System.getProperty("line.separator"));
        fw.close();

    }
}
