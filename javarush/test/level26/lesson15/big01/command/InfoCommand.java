package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.ResourceBundle;

/**
 * Created by Alexey on 10.02.2016.
 */
class InfoCommand implements Command
{
    private ResourceBundle res =
            ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "info");

    @Override
    public void execute()
    {

        ConsoleHelper.writeMessage(res.getString("before"));

        Collection<CurrencyManipulator> mHashMap = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if (mHashMap == null || mHashMap.size() == 0) {
            ConsoleHelper.writeMessage(res.getString("no.money"));
            return;
        }

        for(CurrencyManipulator m : mHashMap){
            if(m.hasMoney()) System.out.println(m.getCurrencyCode() + " - " + m.getTotalAmount());
            else ConsoleHelper.writeMessage(res.getString("no.money"));
        }


    }
}
