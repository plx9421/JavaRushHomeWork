package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution
{
    public static void main(String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try
        {
            //File your_file_name = File.createTempFile("C:\\tmp\\3333", null);
            File your_file_name = new File("C:\\tmp\\2222 ");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User u1 = new User();
            u1.setFirstName("alex");
            u1.setLastName("first");
            u1.setMale(true);
            u1.setCountry(User.Country.UKRAINE);
            u1.setBirthDate(new Date());
            javaRush.users.add(u1);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            for (User u4 : loadedObject.users)
            {
                System.out.println(u4.getFirstName());
                System.out.println(u4.getLastName());
                System.out.println(u4.isMale());
                System.out.println(u4.getCountry());
                System.out.println(u4.getBirthDate());

            }

            outputStream.close();
            inputStream.close();

        }
        catch (IOException e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush
    {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println("javaRush");
            writer.println(this.users.size());
            for (User u3 : this.users)
            {
                writer.println(u3.getFirstName());
                writer.println(u3.getLastName());
                writer.println(u3.isMale());
                writer.println(u3.getCountry());
                writer.println(u3.getBirthDate().getTime());
            }

            writer.close();
        }

        public void load(InputStream inputStream) throws Exception
        {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            if ("javaRush".equals(reader.readLine()))
            {
                int count = Integer.parseInt(reader.readLine());
                for (int i = 0; i < count; i++)
                {
                    User u2 = new User();
                    u2.setFirstName(reader.readLine());
                    u2.setLastName(reader.readLine());
                    u2.setMale("true".equals(reader.readLine()));
                    u2.setCountry(User.Country.valueOf(reader.readLine()));
                    u2.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                    this.users.add(u2);
                }
            }
            reader.close();
        }
    }
}
