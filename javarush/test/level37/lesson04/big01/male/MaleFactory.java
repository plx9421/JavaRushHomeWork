package com.javarush.test.level37.lesson04.big01.male;

import com.javarush.test.level37.lesson04.big01.Human;

/**
 * Created by Алексей on 10.04.2016.
 */
public class MaleFactory {
    public Human getPerson(int age){
        if (age <= KidBoy.MAX_AGE) return new KidBoy();
        if (age <= TeenBoy.MAX_AGE) return  new TeenBoy();
        return new Man();
    }
}
