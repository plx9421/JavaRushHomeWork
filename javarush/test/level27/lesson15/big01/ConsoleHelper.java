package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexey on 14.02.2016.
 */
public class ConsoleHelper
{
    private static BufferedReader singleReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws IOException
    {
        return singleReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        String s = "";
        List<Dish> dishT = new ArrayList<Dish>();
        writeMessage(Dish.allDishesToString());
        writeMessage("выбрите блюдо или наберите exit для выхода: ");
        do
        {
            s = readString();
            if (s != null)
//                if (!"".equals(s))
                {
                    try
                    {
//                        s = s.toLowerCase().trim();
//                        s = s.substring(0, 1).toUpperCase() + s.substring(1);
                        dishT.add(Dish.valueOf(s));
                    }
                    catch (IllegalArgumentException ignory)
                    {
                        if ("exit".equals(s.toLowerCase())) break;

                        writeMessage(s + " is not detected");
                        continue;
                    }
                }
        }
        while (true);


        return dishT;
    }


}
