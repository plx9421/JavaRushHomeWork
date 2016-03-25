package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson
{
    private double averageGrade;

    private Date beginningOfSession;
    private Date endOfSession;
    private int course;

    public Student(String name, int age, double averageGrade){
        super(name, age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public void live()
    {
        learn();
    }

    public void learn(){
    }

    public void incAverageGrade(double delta)
    {
        setAverageGrade(getAverageGrade() + delta);
    }

    public void setAverageGrade(double value)
    {
        this.averageGrade = value;
    }

    public void setCourse(int course)
    {
        this.course = course;
    }

    public void setBeginningOfSession(Date date)
    {
        this.beginningOfSession = date;
    }

    public void setEndOfSession(Date date)
    {
        this.endOfSession = date;
    }

    public double getAverageGrade()
    {
        return averageGrade;
    }

    public int getCourse()
    {
        return course;
    }

    @Override
    public String getPosition()
    {
        return "Студент";
    }
}
