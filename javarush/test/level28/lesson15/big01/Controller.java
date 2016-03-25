package com.javarush.test.level28.lesson15.big01;


import com.javarush.test.level28.lesson15.big01.model.Model;


/**
 * Created by Alexey on 17.02.2016.
 */
public class Controller
{

    private Model model;

    public Controller(Model model)
    {
        if (model == null) throw new IllegalArgumentException();

        this.model = model;
    }

    public void onCitySelect(String cityName){
        model.selectCity(cityName);
    }
}
