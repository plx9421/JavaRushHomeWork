package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Stallone1", new Date("JUNE 1 1980"));
        map.put("Stallone2", new Date("JUNE 12 1980"));
        map.put("Stallone3", new Date("JUNE 21 1980"));
        map.put("Stallone4", new Date("august 1 1980"));
        map.put("Stallone5", new Date("september 1 1980"));
        map.put("Stallone6", new Date("september 13 1980"));
        map.put("Stallone7", new Date("september 21 1980"));
        map.put("Stallone8", new Date("may 1 1980"));
        map.put("Stallone9", new Date("may 11 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> itt = map.entrySet().iterator();
        while (itt.hasNext()){
            Map.Entry<String, Date> pair = itt.next();
            String key = pair.getKey();
            Date value = pair.getValue();
            if ((value.getMonth()>4) && (value.getMonth()<8)) itt.remove();
        }
    }


}
