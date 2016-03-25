package com.javarush.test.level26.lesson02.task01;

import java.util.Arrays;
import java.util.Comparator;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution
{
    public static Integer[] sort(Integer[] array)
    {
        //implement logic here
        Integer[] ar = array.clone();
        Arrays.sort(ar);

        double med = ar[(ar.length / 2)];
        if (ar.length % 2 == 0)
        {
            med = (ar[(ar.length / 2) - 1] + ar[(ar.length / 2)]) / 2.0;
        }

        final double median = med;
//        System.out.println(median);

        Comparator<Integer> comparator = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                double result = (Math.abs(o1 - median) - Math.abs(o2 - median));
                return result == 0 ? o1 - o2 : (int) Math.round(result);
            }
        };
        Arrays.sort(ar, comparator);

        return ar;
    }

    public static void main(String[] args)
    {
        Integer[] a = new Integer[6];
        for (int i = 0; i < a.length; i++)
        {
            a[i] = i;
        }
        Integer[] b = sort(a);
        for (int w : b) System.out.print(w + " ");
    }
}
