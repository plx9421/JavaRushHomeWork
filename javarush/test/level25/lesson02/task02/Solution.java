package com.javarush.test.level25.lesson02.task02;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            String[] s = loadWheelNamesFromDB();
            wheels = new LinkedList<Wheel>();
            for (int i = 0; i < s.length; i++)
            {
                try
                {
                    wheels.add(Wheel.valueOf(s[i]));
                } catch (IllegalArgumentException e){
                    System.out.println(e);

                }

            }
            //init wheels here
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT", "ddd"};
        }
    }

    public static void main(String[] args)
    {
        for (int i = 0; i < 4; i++)
        {
//            .get(i));
        }
        System.out.println(new Car().wheels);
    }
}
