package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human c1 = new Human("san1", true, 10);
        Human c2 = new Human("dother", false, 12);
        Human c3 = new Human("san3", true, 14);

        Human m1 = new Human("mat1", false, 35);
        m1.children.add(c1);
        m1.children.add(c2);
        m1.children.add(c3);

        Human p1 = new Human("otec1", true, 36);
        p1.children.add(c1);
        p1.children.add(c2);
        p1.children.add(c3);

        Human gm1 = new Human("grandmother1", false, 60);
        gm1.children.add(m1);

        Human gm2 = new Human("grandmother2", false, 61);
        gm2.children.add(p1);

        Human gp1 = new Human("granpather1", true, 61);
        gp1.children.add(m1);

        Human gp2 = new Human("granpather2", true, 62);
        gp2.children.add(p1);

        System.out.println(gp2);
        System.out.println(gp1);
        System.out.println(gm2);
        System.out.println(gm1);
        System.out.println(m1);
        System.out.println(p1);
        System.out.println(c3);
        System.out.println(c2);
        System.out.println(c1);



    }

    public static class Human
    {
        //напишите тут ваш код
        private String name = "";
        private boolean sex = false;
        private int age = 0;
        private ArrayList<Human> children;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
            children = new ArrayList<Human>();
        }
        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
