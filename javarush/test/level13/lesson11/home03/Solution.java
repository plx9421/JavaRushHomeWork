package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.*;


public class Solution
{
    public static void main(String[] args)
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String fileName = reader.readLine();
            InputStream inStream = new FileInputStream(fileName);

            while (inStream.available() > 0)
            {
                int data = inStream.read();
                System.out.print((char) data);
            }

            inStream.close();
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }




    }
}
