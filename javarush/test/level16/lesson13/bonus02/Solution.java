package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution
{
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static
    {
        threads.add(new Thread_1());
        threads.add(new Thread_2());
        threads.add(new Thread_3());
        threads.add(new Thread_4());
        threads.add(new Thread_5());
    }

    public static class Thread_1 extends Thread
    {
        @Override
        public void run()
        {
            while (!isInterrupted());
        }
    }

    public static class Thread_2 extends Thread
    {
        @Override
        public void run()
        {
            while (!isInterrupted())
            {
                try
                {
                    sleep(10000);
                }
                catch (InterruptedException e)
                {
                    System.out.println("InterruptedException");
                }
            }
        }
    }

    public static class Thread_3 extends Thread
    {
        @Override
        public void run()
        {
            while (!isInterrupted())
            {
                try
                {
                    System.out.println("Ура");
                    sleep(500);
                }
                catch (InterruptedException e)
                {
                    break;
                }
            }
        }
    }

    public static class Thread_4 extends Thread implements Message
    {
        @Override
        public void run()
        {
            while (!isInterrupted());
        }

        @Override
        public void showWarning()
        {
            this.interrupt();
            try
            {
                this.join();
            }
            catch (InterruptedException e)
            {
            }
        }
    }

    public static class Thread_5 extends Thread
    {
        @Override
        public void run()
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = 0;
            try
            {
                String inputLine = reader.readLine();
                while (!"N".equals(inputLine))
                {
                    if (!"".equals(inputLine)) n += Integer.parseInt(inputLine);
                    inputLine = reader.readLine();
                }
                reader.close();
                System.out.println(n);
            }
            catch (Exception e)
            {
                System.out.println(n);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException
    {

        for (Thread t : threads) t.start();

        Thread.sleep(1000);

        for (Thread t : threads) t.interrupt();

    }
}
