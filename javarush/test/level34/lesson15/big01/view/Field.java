package com.javarush.test.level34.lesson15.big01.view;


import com.javarush.test.level34.lesson15.big01.controller.EventListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alexey on 23.03.2016.
 */
public class Field extends JPanel {
    private View view;
    private EventListener eventListener;

    public Field(View view){
        this.view = view;
    }

    public void paint(Graphics g){
        new com.javarush.test.level34.lesson15.big01.model.Box(100, 100).draw(g);
        new com.javarush.test.level34.lesson15.big01.model.Player(200, 200).draw(g);
        new com.javarush.test.level34.lesson15.big01.model.Home(300, 300).draw(g);

    }

    public void setEventListener(EventListener eventListener){
        this.eventListener = eventListener;
    }

}
