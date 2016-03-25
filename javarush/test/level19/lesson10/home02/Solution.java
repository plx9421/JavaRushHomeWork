package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        TreeMap<String, Double> hm = new TreeMap<>();
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
        reader.close();

        Double dMax = Double.MIN_VALUE;
        for (Map.Entry<String, Double> ps : hm.entrySet())
        {
            if (dMax < ps.getValue()) dMax = ps.getValue();
        }

        for (Map.Entry<String, Double> ps : hm.entrySet()){
            if (dMax == ps.getValue()) System.out.println(ps.getKey());

        }
    }
}
