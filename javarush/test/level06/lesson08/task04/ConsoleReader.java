package com.javarush.test.level06.lesson08.task04;

import java.util.Scanner;

/* Класс ConsoleReader
Сделать класс ConsoleReader, у которого будут 4 статических метода:
String readString() – читает с клавиатуры строку
int readInt() – читает с клавиатуры число
double readDouble() – читает с клавиатуры дробное число
boolean readBoolean() – читает с клавиатуры строку "true" или "false" и возвращает соответствующую логическую переменную true или false
Внимание: создавайте переменную для чтения данных с консоли (BufferedReader или Scanner) внутри каждого метода
*/

public class ConsoleReader
{
    public static String readString() throws Exception
    {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        return name;
    }

    public static int readInt() throws Exception
    {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        return age;
    }

    public static double readDouble() throws Exception
    {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        Double age = scanner.nextDouble();
        return age;

    }

    public static boolean readBoolean() throws Exception
    {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if (name.equals("true")) return true; else return false;

    }
}
