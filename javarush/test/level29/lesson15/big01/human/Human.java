package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive
{
    public static final int FIRST = 1;
    public static final int SECOND = 2;
    public static final int THIRD = 3;
    public static final int FOURTH = 4;
    private List<Human> children = new ArrayList<>();

    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    protected Size size = new Size();

    private BloodGroup bloodGroup;

    public Human(String name, int age)
    {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public List<Human> getChildren()
    {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human child)
    {
        children.add(child);
    }

    public void removeChild(Human child)
    {
        children.remove(child);
    }

    public void setBloodGroup(BloodGroup bloodGroup)
    {
       this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup()
    {
        return bloodGroup;
    }

    public int getAge()
    {
        return age;
    }

    public String getName()
    {
        return name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void printSize()
    {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    @Override
    public void live()
    {

    }

    public String getPosition()
    {
        return "Человек";
    }

    public class Size
    {
        public int height;
        public int weight;
    }
}
