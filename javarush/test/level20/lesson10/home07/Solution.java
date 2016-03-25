package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    private static final long serialVersionUID = 3453454;
    private transient FileOutputStream stream;
    private String fileName = "";

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        String fName = "C:\\tmp\\s2.tmp";
        Solution s = new Solution(fName);
        s.writeObject("Not OK");
        s.close();

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\tmp\\s3o.tmp"));
        os.writeObject(s);
        os.close();

        ObjectInputStream oi = new ObjectInputStream(new FileInputStream("C:\\tmp\\s3o.tmp"));
        Solution s2 = (Solution) oi.readObject();
        s2.writeObject("All OK");
        oi.close();

        System.out.println(s);
        System.out.println(s2);
    }
}
