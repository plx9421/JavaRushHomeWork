package com.javarush.test.level36.lesson04.home01;

import java.util.ArrayList;
import java.util.List;

/* MVC - простая версия
В отдельных файлах создай классы Service, Model, View, Controller.
Распредели методы из класса Solution по созданным классам учитывая, что должен получиться MVC.
Создай нужные поля класса при необходимости.
Не добавляй своих других методов.
Метод main оставь в классе Solution.
*/
public class Solution {
    public static void main(String[] args) {
//        Solution solution = new Solution();
        new View().fireEventShowData();
    }


}
