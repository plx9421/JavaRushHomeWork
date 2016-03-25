package com.javarush.test.level31.lesson02.home01;

import java.io.*;
import java.util.*;

/* Проход по дереву файлов
1. На вход метода main подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
2.1. Если у файла длина в байтах больше 50, то удалить его.

2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"

2.3. Удалить директории без файлов (пустые).
Все файлы имеют расширение txt.
*/
public class Solution
{
    private static List<File> listOfFiles = new ArrayList<>();
    private static File resultFileAbsolutePath;

    private static boolean eraseDir(File dir){
        String s1 = resultFileAbsolutePath.getParent();
        String s2 = dir.getAbsolutePath();

        if (!s1.equals(s2)) return dir.delete();
        return false;
    }

    private static void recursionMain(File path)
    {

        if (eraseDir(path)) return;

        for (File f : path.listFiles())
        {
            if (f.isDirectory())
            {
                recursionMain(f);
                eraseDir(f);
                continue;
            }

            if (f.getName().endsWith(".txt"))
            {

                if (f.length() > 50)
                {
                    f.delete();
                    continue;
                }
                if (f.length() <= 50) listOfFiles.add(f);
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        if (args.length < 2) System.exit(-1);

        File path = new File(args[0]);
        resultFileAbsolutePath = new File(args[1]);

        recursionMain(path);

        Collections.sort(listOfFiles, new Comparator<File>()
        {
            public int compare(File file1, File file2)
            {
                return file1.getName().compareTo(file2.getName());
            }
        });

        if (!eraseDir(path))

        {
            FileOutputStream fos = new FileOutputStream(resultFileAbsolutePath);
            boolean f = false;
            for (int i = 0; i < listOfFiles.size(); i++)            {

                if (f) fos.write("\n".getBytes());
                FileInputStream reader = new FileInputStream(listOfFiles.get(i));
                byte[] buff = new byte[50];
                while (reader.available() > 0)
                {
                    int count = reader.read(buff);
                    fos.write(buff, 0, count);
                }
                reader.close();
                f = true;
            }
            fos.close();

            resultFileAbsolutePath.renameTo(new File(resultFileAbsolutePath.getParentFile() + File.separator + "allFilesContent.txt"));
        }
    }
}
