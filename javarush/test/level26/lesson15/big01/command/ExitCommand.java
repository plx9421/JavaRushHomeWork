package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Alexey on 10.02.2016.
 */
class ExitCommand implements Command
{
    private ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "exit");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));

        String inputString = ConsoleHelper.readString().toUpperCase();
        if (inputString != null)
            if (!"".equals(inputString))
                if (inputString.equals(res.getString("yes")))
                    ConsoleHelper.writeMessage(res.getString("thank.message"));
    }
}
