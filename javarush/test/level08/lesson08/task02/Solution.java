package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;


/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        //напишите тут ваш код
        HashSet<Integer> h = new HashSet<Integer>();
        for (int i = 0; i < 20; i++) {
            h.add(i);
        }
        return h;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        //напишите тут ваш код
        Iterator<Integer> itt = set.iterator();
        while (itt.hasNext()){
            int i1 = itt.next();
            if (i1 > 10) itt.remove();
        }
        return set;
    }
    public static void main(String[] args) {
        System.out.println(removeAllNumbersMoreThan10(createSet()));
    }


}
