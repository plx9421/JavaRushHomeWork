package com.javarush.test.level36.lesson04.big01.model;


import com.javarush.test.level36.lesson04.big01.bean.User;

import java.util.ArrayList;

/**
 * Created by Alexey on 28.03.2016.
 */
public class FakeModel implements Model {
    private ModelData modelData = new ModelData();
    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {

        ArrayList<User> arrayList = new ArrayList<>();
        arrayList.add(new User("A", 1, 1));
        arrayList.add(new User("B", 2, 2));
        arrayList.add(new User("C", 3, 3));
        arrayList.add(new User("D", 4, 4));

        modelData.setUsers(arrayList);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }
}
