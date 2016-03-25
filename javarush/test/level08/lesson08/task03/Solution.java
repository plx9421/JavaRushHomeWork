package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> h = new HashMap<String, String>();
        h.put("арбуз", "ягода");
        h.put("банан", "трава");
        h.put("вишня", "ягода");
        h.put("груша", "фрукт");
        h.put("дыня", "овощ");
        h.put("ежевика", "куст");
        h.put("жень-шень", "корень");
        h.put("земляника", "ягода");
        h.put("ирис", "цветок");
        h.put("картофель", "клубень");

        return h;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int countFirstName = 0;

        Iterator<Map.Entry<String, String>> itt = map.entrySet().iterator();
        while (itt.hasNext()){
            Map.Entry<String, String> pair = itt.next();
            String key = pair.getKey();
            String value = pair.getValue();
            if (value.equals(name)) countFirstName++;
        }
        return countFirstName;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        int countLastName =0;
        //напишите тут ваш код

        Iterator<Map.Entry<String, String>> itt = map.entrySet().iterator();
        while (itt.hasNext()){
            Map.Entry<String, String> pair = itt.next();
            String key = pair.getKey();
            String value = pair.getValue();
            if (key.equals(familiya)) countLastName++;
        }

        return countLastName;
    }
}
