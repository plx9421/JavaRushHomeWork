package com.javarush.test.level21.lesson05.task03;

import java.util.Date;

/* Ошибка в equals/hashCode
Исправьте ошибки реализаций методов equals и hashCode для класса Solution
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;

        Solution solution1 = (Solution) o;

        if (Double.compare(solution1.aDouble, aDouble) != 0) return false;
        if (anInt != solution1.anInt) return false;
        if (date != null ? !date.equals(solution1.date) : solution1.date != null) return false;
        if (solution != null ? !solution.equals(solution1.solution) : solution1.solution != null) return false;
        if (string != null ? !string.equals(solution1.string) : solution1.string != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        result = 31 * result + string.hashCode();
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + date.hashCode();
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        Date date1 = new Date(1220227200L * 1000);
        Date date2 = new Date(1220227200L * 1000);
        Date date3 = new Date(1220227200L * 1000 + 1);
        Solution instance = new Solution(44, "Batman", 22.0, new Date(), null);
        Solution solution1 = new Solution(12, "Max", 13.0, date1, instance);
        Solution solution2 = new Solution(12, "Max", 13.0, date2, instance);
        Solution solution3 = new Solution(12, "Max", 13.0, date2, instance);
        System.out.println(solution1.equals(solution2));
        System.out.println(solution2.equals(solution3));
    }
}
