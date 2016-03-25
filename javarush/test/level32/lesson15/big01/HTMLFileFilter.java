package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Alexey on 15.03.2016.
 */
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {

        if (f.isDirectory()) {
            return true;
        }
        String buff = f.getName().toLowerCase();

        if (buff.endsWith(".html") || buff.endsWith(".htm")) return true;
        else return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
