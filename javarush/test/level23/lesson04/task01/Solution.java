package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] sa = new Solution[2];

        sa[0] = new Solution();
        sa[1] = new Solution();

        sa[0].innerClasses[0] = sa[0].new InnerClass();
        sa[0].innerClasses[1] = sa[0].new InnerClass();
        sa[1].innerClasses[0] = sa[1].new InnerClass();
        sa[1].innerClasses[1] = sa[1].new InnerClass();

        return sa;
    }

    public static void main(String[] args) {
        System.out.println(getTwoSolutions());
    }
}
