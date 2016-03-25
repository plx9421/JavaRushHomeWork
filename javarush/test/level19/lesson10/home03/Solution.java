package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution
{
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        while (reader.ready())
        {
            String[] str = reader.readLine().split(" ");
            String tDate = str[str.length - 2] + "/" + str[str.length - 3] + "/" + str[str.length - 1];
            String tName = "";
            for (int i = 0; i < str.length - 3; i++)
            {
                tName += str[i] + " ";
            }

            tName = tName.trim();

//            System.out.println("-" + tName + "-");
            PEOPLE.add(new Person(tName, new Date(tDate)));

        }
        reader.close();
//        for (int i = 0; i < PEOPLE.size(); i++)
//            System.out.println(PEOPLE.get(i).getName() + " " + PEOPLE.get(i).getBirthday());
    }
}

