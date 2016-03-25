package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: маму, папу, сына, дочь, бабушку(мамина мама) и дедушку(папин папа).
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String Name = reader.readLine();
        Cat catDed = new Cat(Name);

        Name = reader.readLine();
        Cat catBabka = new Cat(Name);

        Name = reader.readLine();
        Cat catPapka = new Cat(Name, catDed, null);

        Name = reader.readLine();
        Cat catMother = new Cat(Name, null, catBabka);

        Name = reader.readLine();
        Cat catSan = new Cat(Name, catPapka, catMother);

        Name = reader.readLine();
        Cat catDaughter = new Cat(Name, catPapka, catMother);


        System.out.println(catDed);
        System.out.println(catBabka);
        System.out.println(catPapka);
        System.out.println(catMother);
        System.out.println(catSan);
        System.out.println(catDaughter);

    }

    public static class Cat
    {
        private String name;
        private Cat mother;
        private Cat father;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name, Cat father, Cat mother)
        {
            this.name = name;
            this.mother = mother;
            this.father = father;
        }

        @Override
        public String toString()
        {
            String result = "Cat name is " + name;

            if (mother == null) result = result + ", no mother";
            else result = result + ", mother is " + mother.name;


            if (father == null) result = result + ", no father";
            else result = result + ", father is " + father.name;

            return result;

        }
    }

}
