package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexey on 10.02.2016.
 */
public final class CommandExecutor
{
    private static Map<Operation, Command> operationCommandMap = new HashMap<>();

    private CommandExecutor()
    {
    }

    static
    {
        operationCommandMap.put(Operation.DEPOSIT, new DepositCommand());
        operationCommandMap.put(Operation.EXIT, new ExitCommand());
        operationCommandMap.put(Operation.INFO, new InfoCommand());
        operationCommandMap.put(Operation.WITHDRAW, new WithdrawCommand());
        operationCommandMap.put(Operation.LOGIN, new LoginCommand());
    }

    public static final void execute(Operation operation) throws InterruptOperationException
    {
        operationCommandMap.get(operation).execute();
//        for (Map.Entry<Operation, Command> p : operationCommandMap.entrySet())
//        {
//            if (operation.equals(p.getKey()))
//            {
//                p.getValue().execute();
//                break;
//            }
//        }
    }

}
