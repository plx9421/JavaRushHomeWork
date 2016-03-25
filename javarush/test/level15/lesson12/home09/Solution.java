package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inStr = reader.readLine();
//        String inStr = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";
//        String inStr = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
//        String inStr = "http://javarush.ru/alpha/index.html?obj=3.158k4&name=Amigo";

        String buffStr = inStr.substring(inStr.indexOf("?") + 1);
        String[] buffArr = buffStr.split("&");

        String strAlert = null;
        for (String s1 : buffArr)
        {
            String[] s2 = s1.split("=");
            System.out.print(s2[0] + " ");
            if ("obj".equals(s2[0])) strAlert = s2[1];
        }

        if (strAlert != null)
        {
            try
            {
                System.out.println();
                alert(Double.parseDouble(strAlert));
            }
            catch (NumberFormatException e)
            {
                //System.out.println();
                alert(strAlert);
            }
        }
        reader.close();
    }

    public static void alert(double value)
    {
        System.out.println("double " + value);
    }

    public static void alert(String value)
    {
        System.out.println("String " + value);
    }
}
