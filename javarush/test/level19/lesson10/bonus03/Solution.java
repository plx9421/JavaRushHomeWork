package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    private static String etalonTag;
    private static String etalonTagOpen;
    private static String etalonTagClose;
    private static List<String> list = new ArrayList<>();

    private static int recurs(String buffString) {

        int tagOpenIndex = buffString.indexOf(etalonTagOpen, etalonTagOpen.length());
        int tagCloseIndex = buffString.indexOf(etalonTagClose, etalonTagOpen.length());

        while (tagOpenIndex < tagCloseIndex) {
            if (tagOpenIndex < 0 || tagCloseIndex < 0) break;
            recurs(buffString.substring(tagOpenIndex));
            tagOpenIndex = buffString.indexOf(etalonTagOpen, tagCloseIndex + etalonTagClose.length());
            tagCloseIndex = buffString.indexOf(etalonTagClose, tagCloseIndex + etalonTagClose.length());
        }
        list.add(buffString.substring(0, tagCloseIndex + etalonTagClose.length()));

        return tagOpenIndex;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = bufferedReader.readLine(); //читаем строку с клавиатуры
        bufferedReader.close();
//        String inputString = "C:\\tmp\\result.html";

        if (args == null || args.length == 0) return;
        etalonTag = args[0];
        etalonTagOpen = "<" + args[0];
        etalonTagClose = "</" + args[0] + ">";

        BufferedReader fileHTML = new BufferedReader(new FileReader(inputString));
        String buff = "";
        while (fileHTML.ready()) buff += fileHTML.readLine();
        fileHTML.close();

        int tagOpenIndexBuff = buff.indexOf(etalonTagOpen, 0);
        if (tagOpenIndexBuff < 0) return;

        int tagCloseIndexBuff = buff.lastIndexOf(etalonTagClose);
        if (tagCloseIndexBuff < 0) return;

        String s = buff.substring(tagOpenIndexBuff, tagCloseIndexBuff + etalonTagClose.length());
        int tagOpenIndex = s.indexOf(etalonTagOpen);
        int tagCloseIndex = s.lastIndexOf(etalonTagClose);

        while (s.length() > 0) {
            if (tagOpenIndex < 0 || tagCloseIndex < 0) break;

            int index = recurs(s);
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.println(list.get(i));
            }
            list = new ArrayList<>();

            if (index < 0) break;
            s = s.substring(index);

            tagOpenIndex = buff.indexOf(etalonTagOpen);
            tagCloseIndex = buff.lastIndexOf(etalonTagClose);
        }

    }
}
