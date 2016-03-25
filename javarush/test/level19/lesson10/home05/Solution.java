package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        FileWriter fileWriter = new FileWriter(args[1]);

        while (reader.ready())
        {
            String[] str = reader.readLine().split(" ");
            for (int i = 0; i < str.length; i++)
            {
                char[] c = str[i].toCharArray();
                boolean bD = false;
                boolean bA = true;
                for (int j = 0; j < c.length-1; j++)
                {
                    if (Character.isDigit(c[j])) bD = true;
                    if (Character.isAlphabetic(c[j]))
                    {
                        bA = true;

                    }
                }
                if (bD && bA){
                    fileWriter.write(str[i] + " ");
                }
            }
        }

        fileWriter.close();
        reader.close();
    }
}
