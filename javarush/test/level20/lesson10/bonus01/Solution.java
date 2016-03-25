package com.javarush.test.level20.lesson10.bonus01;

import java.util.Arrays;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution
{
    public static int[] getNumbers(int N)
    {
        int[] result = new int[31];
        int countNumberOfResultArray = 0;
        for (int i = 1; i < N; i++)
        {
            int powM = 1; //степень
            int[] ar = new int[16];
            int index = i;
            int res1 = 0;

            for (int j = 0; j < ar.length; j++)
            {
                ar[j] = index % 10;
                index /= 10;
                if (index == 0)
                {
                    powM = j+1;
                    break;
                }
            }
            for (int j = 0; j < powM; j++)
            {
                int res2 = 1;
                for (int k = 0; k < powM; k++)
                {
                    res2 *= ar[j];
                }
                res1 += res2;
            }
            if (res1 == i)
            {
                result[countNumberOfResultArray] = res1;
                countNumberOfResultArray++;
            }

        }
        return Arrays.copyOf(result, countNumberOfResultArray);
    }

    public static void main(String[] args)
    {
        long memoryStart = Runtime.getRuntime().freeMemory();
        Long t0 = System.currentTimeMillis();

        int[] a = getNumbers(150000000);
//        int[] a = getNumbers(10000);
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] != 0) System.out.print(a[i] + " ");
        }

        System.out.println();
        long memoryEnd = Runtime.getRuntime().freeMemory();
        System.out.println((memoryStart - memoryEnd) / 1024 + " KBytes"); // итог получаем байты.

        Long t1 = System.currentTimeMillis();
        System.out.println("Time need to create the arrray = " + ((t1 - t0) / 1));


    }
}