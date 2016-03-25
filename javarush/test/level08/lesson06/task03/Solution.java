package com.javarush.test.level08.lesson06.task03;

import java.util.*;

/* Измерить сколько времени занимает 10 тысяч вставок для каждого списка
Измерить, сколько времени занимает 10 тысяч вставок для каждого списка.
Метод getTimeMsOfInsert  должен вернуть время его исполнения в миллисекундах.
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(getTimeMsOfInsert(new ArrayList(20000)));
        System.out.println(getTimeMsOfInsert(new LinkedList()));
    }

    public static long  getTimeMsOfInsert(List list)
    {
        //напишите тут ваш код
        Date t1 = new Date();

        insert10000(list);

        //напишите тут ваш код
        Date t2 = new Date();

        return t2.getTime() - t1.getTime();

    }

    public static void insert10000(List list)
    {
        for (int i=0;i<10000;i++)
        {
            list.add(0, new Object());
        }
    }
}
