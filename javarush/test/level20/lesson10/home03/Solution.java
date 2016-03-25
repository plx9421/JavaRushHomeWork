package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable {
    public static class A {
        public A() {
        }

        protected String name = "A";

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B() {
        }

        public B(String name) {
            super(name);
            this.name += name;
        }

        private void writeObject(ObjectOutputStream stream)
                throws IOException {
            stream.defaultWriteObject();
            stream.writeObject(name);
        }

        private void readObject(ObjectInputStream stream)
                throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            name = (String) stream.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File your_file_name = File.createTempFile("C:\\tmp\\s2.tmp", null);
        ObjectOutputStream p = new ObjectOutputStream(new FileOutputStream(your_file_name));
        ObjectInputStream i = new ObjectInputStream(new FileInputStream(your_file_name));

        Solution s = new Solution();

        Solution.B b1 = s.new B("B");
        p.writeObject(b1);
        p.flush();

        Solution.B b2 = (Solution.B) i.readObject();

        System.out.println(b1.name);
        System.out.println(b2.name);
        p.close();


    }
}
