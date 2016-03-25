package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Model;
import com.javarush.test.level28.lesson15.big01.model.MoikrugStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.view.HtmlView;


/**
 * Created by Alexey on 17.02.2016.
 */
public class Aggregator
{
    public static void main(String[] args)
    {

        HtmlView view = new HtmlView();

        view.setController(new Controller(
                new Model(view,
                        new Provider[]{new Provider(new HHStrategy()), new Provider(new MoikrugStrategy())})));

        view.userCitySelectEmulationMethod();


    }
}
