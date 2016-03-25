package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/


import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));

        Map<String, Double> hm = new TreeMap<String, Double>();

        while (reader.ready())
        {
            String[] str = reader.readLine().split(" ");

            Double dt = Double.parseDouble(str[1]);
            if (hm.containsKey(str[0]))
            {
                dt += hm.get(str[0]);
            }
            hm.put(str[0], dt);

        }

        for (Map.Entry<String, Double> pair : hm.entrySet())
        {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

        reader.close();

    }
}
