package com.javarush.test.level31.lesson06.bonus01;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipInputStream;

/* Разархивируем файл
В метод main приходит список аргументов.
Первый аргумент - имя результирующего файла resultFileName, остальные аргументы - имена файлов fileNamePart.
Каждый файл (fileNamePart) - это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String resultFileName = args[0];

        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(args));
        list.remove(0);
        Collections.sort(list);


        ByteArrayOutputStream bos = new ByteArrayOutputStream(100_000);

        for (String fileZipName : list) {
            Files.copy(Paths.get(fileZipName), bos);
        }

        ZipInputStream zip = new ZipInputStream(new ByteArrayInputStream(bos.toByteArray()));
        zip.getNextEntry();
        Files.copy(zip, Paths.get(resultFileName));
    }
}
