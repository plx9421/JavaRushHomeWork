package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно,
инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = "C:\\tmp\\result.txt";//reader.readLine();
        String fileName = reader.readLine();

        BufferedReader fr = new BufferedReader(new FileReader(fileName));

        int maxId = 0;
        while (fr.ready())
        {
            String str = fr.readLine();
            if ("".equals(str)) continue;
            int id = Integer.parseInt(str.substring(0, 8).trim());
            if (id > maxId) maxId = id;
        }
        fr.close();

        FileWriter fw = new FileWriter(fileName, true);

        fw.write("\n" + String.format("%1$-8d%2$-30s%3$-8s%4$-4s", ++maxId, args[1], args[2], args[3]));

        fw.close();
        reader.close();

    }
}
