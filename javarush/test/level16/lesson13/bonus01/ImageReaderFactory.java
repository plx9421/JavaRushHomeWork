package com.javarush.test.level16.lesson13.bonus01;


import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Alexey on 08.12.2015.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes it)
    {
        if (it == null) throw new IllegalArgumentException("Неизвестный тип картинки");

        switch (it)
        {
            case BMP:
                return new BmpReader();
            case JPG:
                return new JpgReader();
            case PNG:
                return new PngReader();
            default:
                throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}
