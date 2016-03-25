package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //напишите тут ваш код
        Map<String, Cat> h = new HashMap<String, Cat>();
        h.put("арбуз", new Cat("ягода"));
        h.put("банан", new Cat("трава"));
        h.put("вишня", new Cat("ягода"));
        h.put("груша", new Cat("фрукт"));
        h.put("дыня", new Cat("овощ"));
        h.put("ежевика", new Cat("куст"));
        h.put("жень-шень", new Cat("корень"));
        h.put("земляника", new Cat("ягода"));
        h.put("ирис", new Cat("цветок"));
        h.put("картофель", new Cat("клубень"));

        return h;

    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //напишите тут ваш код
        Set<Cat> s = new HashSet<Cat>();

        for (Map.Entry<String, Cat> pair : map.entrySet()){
            s.add(pair.getValue());
        }

        return s;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
