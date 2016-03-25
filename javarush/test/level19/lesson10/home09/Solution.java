package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution
{
    public static TestString testString = new TestString();

    public static void main(String[] args)
    {
        PrintStream old = System.out;

        ByteArrayOutputStream arr = new ByteArrayOutputStream(1000);
        PrintStream newStr = new PrintStream(arr);

        System.setOut(newStr);
        testString.printSomething();
        System.setOut(old);

        String[] str = arr.toString().split(System.lineSeparator());
        for (int i = 0; i < str.length; i++)
        {
            System.out.println(str[i]);
            i++;
            if (i>=str.length) break;
            System.out.println(str[i]);
            System.out.println("JavaRush - курсы Java онлайн");
        }

    }

    public static class TestString
    {
        public void printSomething()
        {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
