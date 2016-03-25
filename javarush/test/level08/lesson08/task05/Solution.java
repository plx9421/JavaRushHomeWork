package com.javarush.test.level08.lesson08.task05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> mp)
    {
        HashMap<String, String> m = new HashMap<String, String>(mp);
        Iterator<Map.Entry<String, String>> itt = m.entrySet().iterator();
        while (itt.hasNext()){
            Map.Entry<String, String> pair = itt.next();
            String value = pair.getValue();
            if (getCountTheSameFirstName(m, value)>1) removeItemFromMapByValue(mp, value);
        }
    }

    public static int getCountTheSameFirstName(HashMap<String, String> m, String name)
    {
        int countFirstName = 0;
        HashMap<String, String> copy = new HashMap<String, String>(m);
        Iterator<Map.Entry<String, String>> itt = copy.entrySet().iterator();
        while (itt.hasNext()){
            Map.Entry<String, String> pair = itt.next();
            String value = pair.getValue();
            if (value.equals(name)) countFirstName++;
        }
        return countFirstName;
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> g = createMap();
        System.out.println(g);

        removeTheFirstNameDuplicates(g);
        System.out.println(g);
    }
}
