package com.javarush.test.level25.lesson05.home01;

/**
 * Created by Alexey on 05.02.2016.
 */
public class LoggingStateThread extends Thread
{
    private Thread privateThread;

    public LoggingStateThread(Thread privateThread)
    {
        super();
        this.privateThread = privateThread;
        setDaemon(true);
    }

    @Override
    public void run()
    {
        Thread.State state = privateThread.getState();
        System.out.println(state);
        while (state != Thread.State.TERMINATED)
        {
            if (state != privateThread.getState())
            {
                state = privateThread.getState();
                System.out.println(state);
            }
        }
    }
}
