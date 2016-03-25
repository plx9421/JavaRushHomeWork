package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fis1 = null;
        try
        {
            fis1 = new FileInputStream(reader.readLine());
//            fis1 = new FileInputStream("C:\\tmp\\2222");
            load(fis1);

            fis1.close();
            reader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        p.putAll(properties);
        p.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties p = new Properties();
        p.load(inputStream);

        Enumeration<?> propertyNames = p.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String key = (String) propertyNames.nextElement();
            properties.put(key, p.getProperty(key));
        }

    }
    public static void main(String[] args) throws Exception
    {
        new Solution().fillInPropertiesMap();

//        for (Map.Entry<String, String> pair : properties.entrySet())
//        {
//            String key = pair.getKey();
//            String value = pair.getValue();
//            System.out.println(key + " = " + value);
//        }

        FileOutputStream fos = new FileOutputStream("C:\\tmp\\2222.out");
        new Solution().save(fos);
        fos.close();

    }

}
