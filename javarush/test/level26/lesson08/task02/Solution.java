package com.javarush.test.level26.lesson08.task02;

/* Мудрый человек думает раз, прежде чем два раза сказать.
Все методы класса Solution должны быть потоково-безопасными.
Сделайте так, чтобы оба метода могли выполняться одновременно двумя различными трэдами.
synchronized(this) для этого не подходит, используйте другой объект для лока.
*/
public class Solution
{
    int var1;
    int var2;
    int var3;
    int var4;
    private final Object l1 = new Object();
    private final Object l2 = new Object();

    public Solution(int var1, int var2, int var3, int var4)
    {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;
    }

    public int getSumOfVar1AndVar2()
    {
        synchronized (l1)
        {
            return var1 + var2;
        }
    }

    public int getSumOfVar3AndVar4()
    {
        synchronized (l2)
        {
            return var3 + var4;
        }
    }

    public static void main(String[] args)
    {
        new Solution(1, 2, 3, 4);

    }
}

