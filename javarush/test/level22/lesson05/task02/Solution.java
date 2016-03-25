package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();
        if (string.isEmpty()) throw new TooShortStringException();

        int firstTab = string.indexOf("\t");
        if (firstTab < 0) throw new TooShortStringException();
        int secondTab = firstTab;

        secondTab = string.indexOf("\t", secondTab + 1);
        if (secondTab < 0) throw new TooShortStringException();

        return string.substring(firstTab + 1, secondTab);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
