package com.javarush.test.level33.lesson10.bonus01;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Alexey on 23.03.2016.
 */
@XmlType(name = "anExample")
@XmlRootElement
public class AnExample {
    public String[] needCDATA = new String[]{"need CDATA because of < and >", ""};
}