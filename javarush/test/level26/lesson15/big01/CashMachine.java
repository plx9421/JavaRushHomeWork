package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;

/**
 * Created by Alexey on 10.02.2016.
 */
public class CashMachine
{
    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";

    public static void main(String[] args)
    {
        Locale.setDefault(Locale.ENGLISH);
        try
        {
            Operation operation = Operation.LOGIN;
            do
            {
                CommandExecutor.execute(operation);
                operation = ConsoleHelper.askOperation();
            }
            while (!Operation.EXIT.equals(operation));
        }
        catch (InterruptOperationException e)
        {
            ConsoleHelper.printExitMessage();
        }
    }

}
