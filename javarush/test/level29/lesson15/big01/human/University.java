package com.javarush.test.level29.lesson15.big01.human;

import java.util.LinkedList;
import java.util.List;

public class University
{

    private List<Student> students = new LinkedList<>();
    private String name;
    private int age;

    public University(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade)
    {
        for (Student s : students)
        {
            if (s.getAverageGrade() == averageGrade) return s;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade()
    {
        Student result = null;
        double maxGrade = 0;
        for (Student s : students)
        {
            if (s.getAverageGrade() > maxGrade)
            {
                maxGrade = s.getAverageGrade();
                result = s;
            }
        }
        return result;
    }

    public Student getStudentWithMinAverageGrade()
    {
        Student result = null;
        double minGrade = students.get(0).getAverageGrade();
        for (Student s : students)
        {
            if (s.getAverageGrade() < minGrade)
            {
                minGrade = s.getAverageGrade();
                result = s;
            }
        }
        return result;
    }

    public void expel(Student student)
    {
        if (students.contains(student)) students.remove(student);
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
