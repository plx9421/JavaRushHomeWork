package com.javarush.test.level34.lesson15.big01.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Alexey on 25.03.2016.
 */
public class LevelLoader {
    //    Параметр levels – это    путь к тестовому файлу, содержащему описание уровней.
    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {

        Set<Wall> w = new HashSet<>();
        Set<Box> b = new HashSet<>();
        Set<Home> h = new HashSet<>();

        w.add(new Wall(20, 20));
        w.add(new Wall(200, 200));
        w.add(new Wall(180, 180));
        w.add(new Wall(220, 220));

        b.add(new Box(240, 240));
        b.add(new Box(20, 60));

        h.add(new Home(60, 20));
        h.add(new Home(80, 80));


        return new GameObjects(w, b, h, new Player(60, 60));
    }

}
