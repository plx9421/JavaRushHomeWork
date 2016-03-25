package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//TODO сделать
/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки,
которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution
{
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader f2 = new BufferedReader(new FileReader(reader.readLine()));

        while (f1.ready()) allLines.add(f1.readLine());

        while (f2.ready()) forRemoveLines.add(f2.readLine());

        new Solution().joinData();

        f1.close();
        f2.close();
        reader.close();
    }

    public void joinData() throws CorruptedDataException
    {
        List<String> fullList = new ArrayList<>(allLines);
        List<String> etalonList = new ArrayList<>(forRemoveLines);

        label_1:
        for (int i = 0; i < fullList.size(); i++)
        {
            for (int j = 0; j < etalonList.size(); j++)
            {
                if (etalonList.get(j).equals(fullList.get(i)))
                {
                    etalonList.remove(j);
                    fullList.remove(i);
                    i--;
                    continue label_1;
                }
            }
        }
        if (etalonList.size() ==0 ) allLines = fullList;
        else {
            allLines = new ArrayList<String>();
            throw new CorruptedDataException();
        }
    }
}
