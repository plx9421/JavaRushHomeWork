package com.javarush.test.level31.lesson06.home01;

import com.sun.corba.se.spi.orbutil.fsm.Input;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {

    private static byte[] inputStreamToArray(InputStream o) throws IOException {
        int len;
        int size = 1024;
        byte[] buf;

        ByteArrayOutputStream bos = new ByteArrayOutputStream(size);
        buf = new byte[size];
        while ((len = o.read(buf, 0, size)) != -1)
            bos.write(buf, 0, len);
        buf = bos.toByteArray();
        return buf;
    }

    public static void main(String[] args) throws IOException {

        Path pathFileName = Paths.get(args[0]);
        String fileName = pathFileName.getFileName().toString();

        String zipFileName = args[1];

        Map<String, byte[]> mapOfZipEntry = new HashMap<>();
        ZipInputStream zip = new ZipInputStream(new FileInputStream(zipFileName));

        ZipEntry ze;
        boolean flag = false;
        while ((ze = zip.getNextEntry()) != null) {
            if (("new/" + fileName).equals(ze.getName())) {
                flag = true;
                continue;
            }
            mapOfZipEntry.put(ze.getName(), inputStreamToArray(zip));
        }

        mapOfZipEntry.put("new/", new byte[0]);
        ByteArrayOutputStream ba = new ByteArrayOutputStream((int) Files.size(pathFileName));
        Files.copy(pathFileName, ba);
        mapOfZipEntry.put("new/" + fileName, ba.toByteArray());

        zip.close();

        if (flag) {
            ZipOutputStream zip2 = new ZipOutputStream(new FileOutputStream(zipFileName));

            for (Map.Entry<String, byte[]> m : mapOfZipEntry.entrySet()) {
                zip2.putNextEntry(new ZipEntry(m.getKey()));
                zip2.write(m.getValue());
                zip2.closeEntry();
            }
            zip2.close();
        }
    }
}
