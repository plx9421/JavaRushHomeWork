package com.javarush.test.level36.lesson04.big01.view;

import com.javarush.test.level36.lesson04.big01.bean.User;
import com.javarush.test.level36.lesson04.big01.controller.Controller;
import com.javarush.test.level36.lesson04.big01.model.ModelData;

/**
 * Created by Alexey on 28.03.2016.
 */
public class UsersView implements View{
    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {
        System.out.println("All users:");

        for (User user : modelData.getUsers())
            System.out.println("\t" + user);

        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }
}
