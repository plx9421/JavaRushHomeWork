package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> l = new ArrayList<String>();
        l.add("January");
        l.add("February");
        l.add("March");
        l.add("April");
        l.add("May");
        l.add("June");
        l.add("Jule");
        l.add("August");
        l.add("September");
        l.add("October");
        l.add("November");
        l.add("December");

        String nameOfMonth = reader.readLine();
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).equals(nameOfMonth)) {
                System.out.println(nameOfMonth + " is " + (i+1) + " month");
                break;
            }
        }

        //напишите тут ваш код

    }

}
