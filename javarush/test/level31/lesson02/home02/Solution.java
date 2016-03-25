package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution
{
    public static List<String> getFileTree(String root) throws IOException
    {
        PriorityQueue<File> queueOfFile = new PriorityQueue<>();
        List<String> listOfFiles = new ArrayList<>();

        queueOfFile.addAll(Arrays.asList(new File(root).listFiles()));
        while (queueOfFile.size() > 0)
        {
            if (queueOfFile.element().isDirectory())
            {
                queueOfFile.addAll(Arrays.asList(queueOfFile.element().listFiles()));
            } else
            {
                listOfFiles.add(queueOfFile.element().getAbsolutePath());
            }
            queueOfFile.remove();

        }
        return listOfFiles;
    }
}
