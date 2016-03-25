package com.javarush.test.level28.lesson06.home01;

/**
 * Created by Alexey on 17.02.2016.
 */
public class MyThread extends Thread
{
    private static int pr = 0;

    public MyThread()
    {
        if (pr >= MAX_PRIORITY) pr = MIN_PRIORITY;
        else pr++;
        setPriority(pr);
    }

    public MyThread(Runnable target)
    {
        super(target);
        if (pr >= MAX_PRIORITY) pr = MIN_PRIORITY;
        else pr++;
        setPriority(pr);
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        if (pr >= MAX_PRIORITY) pr = MIN_PRIORITY;
        else pr++;
        setPriority(pr);
    }

    public MyThread(String name)
    {
        super(name);
        if (pr >= MAX_PRIORITY) pr = MIN_PRIORITY;
        else pr++;
        setPriority(pr);
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        if (pr >= MAX_PRIORITY) pr = MIN_PRIORITY;
        else pr++;
        setPriority(pr);
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        if (pr >= MAX_PRIORITY) pr = MIN_PRIORITY;
        else pr++;
        setPriority(pr);
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        if (pr >= MAX_PRIORITY) pr = MIN_PRIORITY;
        else pr++;
        setPriority(pr);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        if (pr >= MAX_PRIORITY) pr = MIN_PRIORITY;
        else pr++;
        setPriority(pr);
    }
}
