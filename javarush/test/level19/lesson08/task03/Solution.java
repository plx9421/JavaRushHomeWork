package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.

Пример вывода:
12345678
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

        char[] buff = arr.toString().toCharArray();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < buff.length; i++) {
            if (Character.isDigit(buff[i])) {
                result.append(buff[i]);
            }

        }
        System.out.println(result.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
