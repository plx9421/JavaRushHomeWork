package com.javarush.test.level07.lesson09.task01;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Три массива
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число делится на 3 (x%3==0), делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<Integer> n = new ArrayList<Integer>();
        ArrayList<Integer> n3 = new ArrayList<Integer>();
        ArrayList<Integer> n2 = new ArrayList<Integer>();
        ArrayList<Integer> n0 = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 20; i++) {
            int ni = Integer.parseInt(reader.readLine());
            n.add(ni);
            if (ni%3 == 0) n3.add(ni);
            if (ni%2 == 0) n2.add(ni);
            if (!(ni%3 == 0) && !(ni%2 == 0)) n0.add(ni);

        }

        printList(n3);
        printList(n2);
        printList(n0);



    }

    public static void printList(List<Integer> list)
    {
        //напишите тут ваш код
        for(int i : list) System.out.println(i);
    }
}
