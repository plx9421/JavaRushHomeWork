package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так,
 чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //Написать тут ваш код
        Human gf1 = new Human("Tom", true, 80, null, null);
        Human gf2 = new Human("Petr", true, 89, null, null);
        Human gm1 = new Human("Ann", false, 81, null, null);
        Human gm2 = new Human("Kate", false, 88, null, null);
        Human m1 = new Human("Ivi", false, 59, gf1, gm1);
        Human f2 = new Human("Serg", true, 60, gf2, gm2);
        Human c1 = new Human("Pet", true, 30, f2, m1);
        Human c2 = new Human("Iren", false, 35, f2, m1);
        Human c3 = new Human("Alex", true, 37, f2, m1);

        System.out.println(gf1);
        System.out.println(gf2);
        System.out.println(gm1);
        System.out.println(gm2);
        System.out.println(m1);
        System.out.println(f2);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);


    }

    public static class Human
    {
        String name = "";
        boolean sex = true;
        int age = 0;
        Human father = null;
        Human mother = null;

        //Написать тут ваш код

        Human(String name, boolean sex, int age, Human father, Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
