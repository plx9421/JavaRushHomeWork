package com.javarush.test.level17.lesson10.bonus01;
//todo не проходит тестирование

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String_t
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        if (args.length != 0) {
            switch (args[0]) {
                case "-c":
                    if (args.length == 4) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                        Date d = simpleDateFormat.parse(args[3]);

                        Person p;
                        if ("м".equals(args[2])) p = Person.createMale(args[1], d);
                        else p = Person.createFemale(args[1], d);
                        allPeople.add(p);
                        System.out.println(allPeople.indexOf(p));
                    }
                    break;
                case "-u": //-u 1 Миронов м 15/04/1990
                    if (args.length == 5) {
                        int index = Integer.parseInt(args[1]);
                        Person p = allPeople.get(index);
                        //allPeople.remove(index);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                        Date d = simpleDateFormat.parse(args[4]);
                        if ("м".equals(args[3])) p = Person.createMale(args[2], d);
                        else p = Person.createFemale(args[2], d);
                        allPeople.set(index, p);
                    }
                    break;
                case "-d": //-d 1
                    if (args.length == 2) {
                        Person person = Person.createFemale(null, null);
                        person.setSex(null);
                        allPeople.set(Integer.parseInt(args[1]), person);
                    }
                    break;
                case "-i":
                    if (args.length == 2) {
                        int index = Integer.parseInt(args[1]);
                        System.out.println(allPeople.get(index));
                    }
                    break;

            }
//                   for (Person p : allPeople) System.out.println(p);
        }
    }
}
