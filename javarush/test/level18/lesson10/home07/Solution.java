package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader fi = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        StringBuffer strB = new StringBuffer();
        while (fi.ready()){
            strB.append(fi.readLine());
            String[] strA = strB.toString().split(" ");
            //id productName price quantity
            int a1 = Integer.parseInt(args[0]);
            int a2 = Integer.parseInt(strA[0]);
            if (a1 == a2 ){
                System.out.println(strB);
                break;
            }
            strB = new StringBuffer();
        }

        reader.close();
        fi.close();
    }
}
