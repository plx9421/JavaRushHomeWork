package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        private String name = "";
        private int age = 0;
        private boolean sex = false;
        private String adress = "";
        private String color = "";
        private int weight = 0;
        public Human(){}
        public Human(String name){}
        public Human(String name, int age){}
        public Human(String name, int age, boolean sex){}
        public Human(String name, int age, boolean sex, String adress){}
        public Human(String name, int age, boolean sex, String adress, String color){}
        public Human(String name, int age, boolean sex, String adress, int weight, String color){}
        public Human(String name, int age, boolean sex, String adress, int weight){}
        public Human(String name, int age, boolean sex, int weight){}
        public Human(String name, int age, boolean sex, int weight, String color){}






    }
}
