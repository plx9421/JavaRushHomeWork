package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    private static int create(String name, String sex, String bd) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date d = simpleDateFormat.parse(bd);
        Person p;
        if ("м".equals(sex)) p = Person.createMale(name, d);
        else p = Person.createFemale(name, d);
        allPeople.add(p);

        return allPeople.indexOf(p);
    }

    private static void update(String id, String name, String sex, String bd) throws ParseException {
        int index = Integer.parseInt(id);
        if (index < allPeople.size()) {
            Person p = allPeople.get(index);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date d = simpleDateFormat.parse(bd);
            if ("м".equals(sex)) p = Person.createMale(name, d);
            else p = Person.createFemale(name, d);
            allPeople.set(index, p);
        }

    }

    private static void delete(String id) {
        int index = Integer.parseInt(id);
        if (index < allPeople.size()) {
            Person p = allPeople.get(index);
            p.setSex(null);
            p.setBirthDay(null);
            p.setName(null);
            allPeople.set(index, p);
        }
    }

    private static String info(String id) {
        int index = Integer.parseInt(id);
        String s = null;
        if (index < allPeople.size()) {
            Person p = allPeople.get(index);
            s = p.getName();
            if (Sex.MALE.equals(p.getSex())) s += " м ";
            else s += " ж ";
            SimpleDateFormat formatDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            s += formatDate.format(p.getBirthDay());
        }
        return s;
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        if (args.length != 0) {
            switch (args[0]) {
                case "-c":
                    if (args.length >= 4) {
                        synchronized (allPeople) {
                            for (int i = 1; i < args.length; i += 3) {
                                if (args.length >= i + 3) {
                                    System.out.println(create(args[i], args[i + 1], args[i + 2]));
                                }
                            }
                        }
                    }
                    break;
                case "-u":
                    if (args.length >= 5) {
                        synchronized (allPeople) {
                            for (int i = 1; i < args.length; i += 4) {
                                if (args.length >= i + 4) {
                                    update(args[i], args[i + 1], args[i + 2], args[i + 3]);
                                }
                            }
                        }
                    }
                    break;
                case "-d":
                    if (args.length >= 2) {
                        synchronized (allPeople) {
                            for (int i = 1; i < args.length; i++) {
                                delete(args[i]);
                            }
                        }
                    }
                    break;
                case "-i":
                    if (args.length >= 2) {
                        synchronized (allPeople) {
                            for (int i = 1; i < args.length; i++) {
                                System.out.println(info(args[i]));
                            }
                        }
                    }
                    break;

            }
            //for (Person p : allPeople) System.out.println(p);
        }
    }
}
