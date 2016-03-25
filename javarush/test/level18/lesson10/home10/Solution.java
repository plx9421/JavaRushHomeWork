package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/


import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        List<String> listOfFiles = new ArrayList<String>();
//        listOfFiles.addAll(Arrays.asList("C:\\tmp\\Lion.avi.part1",
//                "C:\\tmp\\Lion.avi.part5", "C:\\tmp\\Lion.avi.part3",
//                "C:\\tmp\\Lion.avi.part2"));

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String strBuffer = "";
        while (!"end".equals(strBuffer.toLowerCase())){
            strBuffer = reader.readLine().trim();
            if (!"".equals(strBuffer))
                if (strBuffer.contains(".part")) listOfFiles.add(strBuffer);
        }
        reader.close();

        Collections.sort(listOfFiles);
        String primaryFileName = listOfFiles.get(0);
        primaryFileName = primaryFileName.substring(0, primaryFileName.lastIndexOf('.'));
        FileOutputStream fo = new FileOutputStream(primaryFileName, true);

        for (int i = 0; i < listOfFiles.size(); i++)
        {
            FileInputStream fi = new FileInputStream(listOfFiles.get(i));
            byte[] buff = new byte[1000];
            while (fi.available() > 0)
            {
                int count = fi.read(buff);
                fo.write(buff, 0, count);
            }
            fi.close();
        }

        fo.close();

    }
}
