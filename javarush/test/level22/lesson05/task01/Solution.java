package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {

        if (string == null) throw new TooShortStringException();
        if (string.isEmpty()) throw new TooShortStringException();

        int firstSpace = string.indexOf(" ");
        if (firstSpace < 0) throw new TooShortStringException();
        int fourSpace = firstSpace;

        for (int i = 0; i < 4; i++) {
            fourSpace = string.indexOf(" ", fourSpace + 1);
            if (fourSpace < 0) throw new TooShortStringException();
        }
        return string.substring(firstSpace + 1, fourSpace);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
//        System.out.println(getPartOfString("JavaRush - лучший сервис   обучения Java.") + ".");
//        System.out.println(getPartOfString("JavaRush") + ".");
        System.out.println("." + getPartOfString("a + b = c ") + ".");


        System.out.println("." + getPartOfString("  1 + 2= 3") + ".");

    }
}
