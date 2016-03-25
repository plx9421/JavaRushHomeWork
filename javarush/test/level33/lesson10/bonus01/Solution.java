package com.javarush.test.level33.lesson10.bonus01;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* Комментарий внутри xml
Реализовать метод toXmlWithComment, который должен возвращать строку - xml представление объекта obj.
В строке перед каждым тэгом tagName должен быть вставлен комментарий comment.
Сериализация obj в xml может содержать CDATA с искомым тегом. Перед ним вставлять комментарий не нужно.

Пример вызова:  toXmlWithComment(firstSecondObject, "second", "it's a comment")
Пример результата:
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<first>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second>some string</second>
    <!--it's a comment-->
    <second><![CDATA[need CDATA because of < and >]]></second>
    <!--it's a comment-->
    <second/>
</first>
*/
public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) {
        JAXBContext context = null;
        StringWriter writer = new StringWriter();
        try {
            context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(obj, writer);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        boolean cdataFlag = false;
        BufferedReader reader = new BufferedReader(new StringReader(writer.toString()));
        try
        {
            String buff = "";
            while ((buff = reader.readLine()) != null)
            {
        //// TODO: 16.03.2016
//                System.out.println(buff);
//                int index = buff.indexOf(tagName);
//                int iCDATA = buff.indexOf("{CDATA");
//                if (cdataFlag)
//
//
//                if (iCDATA > 0) {cdataFlag = true;}




            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return writer.toString();
    }
}
