package com.javarush.test.level34.lesson15.big01.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
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

        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = new Player(60, 60);
//
//        w.add(new Wall(20, 20));
//        w.add(new Wall(200, 200));
//        w.add(new Wall(180, 180));
//        w.add(new Wall(220, 220));
//
//        b.add(new Box(240, 240));
//        b.add(new Box(20, 60));
//
//        h.add(new Home(60, 20));
//        h.add(new Home(80, 80));
//
//

        int currentLevel = level;
        if (level > 60) currentLevel = level % 60;

        try (BufferedReader reader = Files.newBufferedReader(levels, Charset.defaultCharset());) {
            while (reader.ready()) {
                String buffString = reader.readLine();
                if (buffString.contains("Maze: ")) {
                    String[] splitStringArray = buffString.split(" ");
                    int parsedLevel;
                    try {
                        parsedLevel = Integer.parseInt(splitStringArray[1]);
                    } catch (NumberFormatException ignory) {
                        continue;
                    }
                    if (parsedLevel == currentLevel) {
                        for (int i = 0; i < 6; i++) reader.readLine();

                        char[] buffArray;
                        int y = 0;
                        while (reader.ready()) {
                            buffArray = reader.readLine().toCharArray();
                            if (buffArray.length == 0) break;

                            for (int i = 0; i < buffArray.length; i++) {
                                int zeroXY = Model.FIELD_SELL_SIZE / 2;
                                switch (buffArray[i]) {
                                    case 'X':
                                        walls.add(new Wall(i * Model.FIELD_SELL_SIZE + zeroXY, y * Model.FIELD_SELL_SIZE + zeroXY));
                                        break;
                                    case '*':
                                        boxes.add(new Box(i * Model.FIELD_SELL_SIZE + zeroXY, y * Model.FIELD_SELL_SIZE + zeroXY));
                                        break;
                                    case '.':
                                        homes.add(new Home(i * Model.FIELD_SELL_SIZE + zeroXY, y * Model.FIELD_SELL_SIZE + zeroXY));
                                        break;
                                    case '&':
                                        boxes.add(new Box(i * Model.FIELD_SELL_SIZE + zeroXY, y * Model.FIELD_SELL_SIZE + zeroXY));
                                        homes.add(new Home(i * Model.FIELD_SELL_SIZE + zeroXY, y * Model.FIELD_SELL_SIZE + zeroXY));
                                        break;
                                    case '@':
                                        player = new Player(i * Model.FIELD_SELL_SIZE + zeroXY, y * Model.FIELD_SELL_SIZE + zeroXY);
                                        break;
                                }
                            }
                            y++;
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new GameObjects(walls, boxes, homes, player);
    }

}
