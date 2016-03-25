package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream old = System.out;

        ByteArrayOutputStream arr = new ByteArrayOutputStream();
        PrintStream newStr = new PrintStream(arr);

        System.setOut(newStr);

        testString.printSomething();

        System.setOut(old);

        String[] buff = arr.toString().split(" ");
        String a = buff[0];
        String b = buff[2];
        String o = buff[1];
//TODO может понадобиться вывод в две строки
        System.out.println(a + " " + o + " " + b + " = " + calc(a, b, o));
    }

    public static int calc(String a, String b, String o) {
        switch (o) {
            case "+": {
                return Integer.parseInt(a) + Integer.parseInt(b);
            }
            case "-": {
                return Integer.parseInt(a) - Integer.parseInt(b);
            }
            case "*": {
                return Integer.parseInt(a) * Integer.parseInt(b);
            }
            default:
                return -1;
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");

        }
    }

}

