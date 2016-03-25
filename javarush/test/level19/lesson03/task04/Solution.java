package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке.
Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner s = null;

        public PersonScannerAdapter(Scanner o) {
            this.s = o;
        }

        @Override
        public Person read() throws IOException {
            if (s.hasNext()) {
                String lastName = s.next();
                String firstName = s.next();
                String middleName = s.next();
                int day = s.nextInt();
                int month = s.nextInt() - 1;
                int year = s.nextInt();
                Calendar birthDate = new GregorianCalendar(year, month, day);

                return new Person(firstName, middleName, lastName, birthDate.getTime());
            } else return null;
        }

        @Override
        public void close() throws IOException {
            s.close();
        }
        public static void main(String[] args) throws IOException {

            PersonScannerAdapter adapter = new PersonScannerAdapter(
                    new Scanner(
                            new File("C:\\tmp\\result2.txt")));

            System.out.println(adapter.read());
            adapter.close();

        }
    }
}
