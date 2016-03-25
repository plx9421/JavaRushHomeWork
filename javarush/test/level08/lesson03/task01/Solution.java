package com.javarush.test.level08.lesson03.task01;

/* HashSet из растений
Создать коллекцию HashSet с типом элементов String.
Добавить в неё 10 строк: арбуз, банан, вишня, груша, дыня, ежевика, жень-шень, земляника, ирис, картофель.
Вывести содержимое коллекции на экран, каждый элемент с новой строки.
Посмотреть, как изменился порядок добавленных элементов.
*/

import java.util.HashSet;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        HashSet<String> c1 = new HashSet<String>();
        c1.add("арбуз");
        c1.add("банан");
        c1.add("вишня");
        c1.add("груша");
        c1.add("дыня");
        c1.add("ежевика");
        c1.add("жень-шень");
        c1.add("земляника");
        c1.add("ирис");
        c1.add("картофель");


        for (String a : c1) System.out.println(a);

    }
}
