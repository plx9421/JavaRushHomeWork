package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution
{
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String firstFileName = bufferedReader.readLine();
//        String secondFileName = bufferedReader.readLine();
        bufferedReader.close();

        String firstFileName = "C:\\tmp\\19bonus1_1.txt";
        String secondFileName = "C:\\tmp\\19bonus1_2.txt";

        BufferedReader file1 = new BufferedReader(new FileReader(firstFileName));
        BufferedReader file2 = new BufferedReader(new FileReader(secondFileName));

        String str1File1 = "1";
        String str1File2 = "1";
        String str2File1 = "";
        String str2File2 = "";

        if (file1.ready() && file2.ready())
        {
            str2File1 = file1.readLine().trim();
            str2File2 = file2.readLine().trim();
        }

        boolean readFile1 = true;
        boolean readFile2 = true;

        while (!"".equals(str1File1) && !"".equals(str1File2))
        {

            if (readFile1)
                if (!file1.ready())
                {
                    str1File1 = str2File1;
                    str2File1 = "";
                    readFile1 = false;
                } else
                {
                    str1File1 = str2File1;
                    str2File1 = file1.readLine().trim();
                    readFile1 = false;
                }

            if (readFile2)
                if (!file2.ready())
                {
                    str1File2 = str2File2;
                    str2File2 = "";
                    readFile2 = false;
                } else
                {
                    str1File2 = str2File2;
                    str2File2 = file2.readLine().trim();
                    readFile2 = false;
                }


            if (str1File1.equals(str1File2))
            {
                lines.add(new LineItem(Type.SAME, str1File1));
                readFile1 = true;
                readFile2 = true;

            } else if (str1File1.equals(str2File2))
            {
                lines.add(new LineItem(Type.ADDED, str1File2));
                readFile2 = true;

            } else if (str2File1.equals(str1File2))
            {
                lines.add(new LineItem(Type.REMOVED, str1File1));
                readFile1 = true;

            } else break;

        }


        file1.close();
        file2.close();
        for (LineItem l : lines) System.out.println(l.type + " " + l.line);

    }


    public static enum Type
    {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem
    {
        public Type type;
        public String line;

        public LineItem(Type type, String line)
        {
            this.type = type;
            this.line = line;
        }
    }
}
