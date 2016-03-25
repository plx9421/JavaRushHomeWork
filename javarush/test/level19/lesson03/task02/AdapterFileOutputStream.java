package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter{
    private FileOutputStream fl;
    public AdapterFileOutputStream(FileOutputStream o){
        this.fl = o;
    }

    @Override
    public void flush() throws IOException {
        fl.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        fl.write(s.getBytes());
    }

    @Override
    public void close() throws IOException {
        fl.close();
    }
}

