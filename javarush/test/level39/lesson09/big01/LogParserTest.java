package com.javarush.test.level39.lesson09.big01;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Alexey on 13.04.2016.
 */
public class LogParserTest {
    SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy");

    private List<String> initLgParser() {
        List<String> list = new ArrayList<>();
        list.add("127.0.0.1\tAmigo\t30.08.2012 16:08:13\tLOGIN\tOK");
        list.add("192.168.100.2\tVasya Pupkin\t30.08.2012 16:08:40\tDONE_TASK 15\tOK");
        list.add("146.34.15.5\tEduard Petrovich Morozko\t13.09.2013 5:04:50\tDOWNLOAD_PLUGIN\tOK");
        list.add("127.0.0.1\tEduard Petrovich Morozko\t11.12.2013 10:11:12\tWRITE_MESSAGE\tFAILED");
        list.add("146.34.15.5\tEduard Petrovich Morozko\t12.12.2013 21:56:30\tWRITE_MESSAGE\tOK");
        list.add("146.34.15.5\tEduard Petrovich Morozko\t03.01.2014 03:45:23\tLOGIN\tOK");
        list.add("192.168.100.2\tVasya Pupkin\t30.01.2014 12:56:22\tSOLVE_TASK 18\tERROR");
        list.add("127.0.0.1\tVasya Pupkin\t14.11.2015 07:08:01\tWRITE_MESSAGE\tOK");
        list.add("192.168.100.2\tVasya Pupkin\t19.03.2016 00:00:00\tSOLVE_TASK 1\tOK");
        list.add("146.34.15.5\tEduard Petrovich Morozko\t05.01.2021 20:22:55\tDONE_TASK 48\tFAILED");
        list.add("127.0.0.1\tVasya Pupkin\t14.10.2021 11:38:21\tLOGIN\tOK");
        list.add("12.12.12.12\tAmigo\t21.10.2021 19:45:25\tSOLVE_TASK 18\tOK");
//        list.add("");
        return list;
    }

    @Test
    public void testGetAllUsers() throws Exception {
        LogParser logParser = new LogParser(initLgParser());
        int actual = logParser.getAllUsers().size();
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetNumberOfUsers() throws Exception {
        LogParser logParser = new LogParser(initLgParser());
        int actual = logParser.getNumberOfUsers(null, null);
        int expected = 3;
        assertEquals(expected, actual);

        actual = logParser.getNumberOfUsers(df.parse("13.09.2013"), df.parse("19.03.2016"));
        expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetNumberOfUserEvents() throws Exception {
        LogParser logParser = new LogParser(initLgParser());
        int actual = logParser.getNumberOfUserEvents("Eduard Petrovich Morozko", null, null);
        int expected = 5;
        assertEquals(expected, actual);

        actual = logParser.getNumberOfUserEvents("Vasya Pupkin", df.parse("13.09.2013"), df.parse("19.03.2016"));
        expected = 3;
        assertEquals(expected, actual);

        actual = logParser.getNumberOfUserEvents("", null, null);
        expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void testGetUsersForIP() throws Exception {
        LogParser logParser = new LogParser(initLgParser());
        String actual = logParser.getUsersForIP("127.0.0.1", null, null).toString();
        String expected = "[Vasya Pupkin, Amigo, Eduard Petrovich Morozko]";
        assertEquals(expected, actual);

        actual = logParser.getUsersForIP("127.0.0.1", df.parse("13.09.2013"), df.parse("19.03.2016")).toString();
        expected = "[Vasya Pupkin, Eduard Petrovich Morozko]";
        assertEquals(expected, actual);

        actual = logParser.getUsersForIP("", null, null).toString();
        expected = "[]";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetLoggedUsers() throws Exception {
        LogParser logParser = new LogParser(initLgParser());
        String actual = logParser.getLoggedUsers(null, null).toString();
        String expected = "[Vasya Pupkin, Amigo, Eduard Petrovich Morozko]";
        assertEquals(expected, actual);

        actual = logParser.getLoggedUsers(df.parse("13.09.2013"), df.parse("19.03.2016")).toString();
        expected = "[Eduard Petrovich Morozko]";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetDownloadedPluginUsers() throws Exception {
        LogParser logParser = new LogParser(initLgParser());
        String actual = logParser.getDownloadedPluginUsers(null, null).toString();
        String expected = "[Eduard Petrovich Morozko]";
        assertEquals(expected, actual);

        actual = logParser.getDownloadedPluginUsers(df.parse("11.12.2013"), df.parse("19.03.2016")).toString();
        expected = "[]";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetWroteMessageUsers() throws Exception {
        LogParser logParser = new LogParser(initLgParser());
        String actual = logParser.getWroteMessageUsers(null, null).toString();
        String expected = "[Vasya Pupkin, Eduard Petrovich Morozko]";
        assertEquals(expected, actual);

        actual = logParser.getWroteMessageUsers(df.parse("11.12.2013"), df.parse("30.01.2014")).toString();
        expected = "[Eduard Petrovich Morozko]";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetSolvedTaskUsers() throws Exception {
        LogParser logParser = new LogParser(initLgParser());
        String actual = logParser.getSolvedTaskUsers(null, null).toString();
        String expected = "[Vasya Pupkin, Amigo]";
        assertEquals(expected, actual);

        actual = logParser.getSolvedTaskUsers(df.parse("11.12.2013"), df.parse("19.03.2016")).toString();
        expected = "[Vasya Pupkin]";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetSolvedTaskUsersInt() throws Exception {
        LogParser logParser = new LogParser(initLgParser());
        String actual = logParser.getSolvedTaskUsers(null, null, 18).toString();
        String expected = "[Vasya Pupkin, Amigo]";
        assertEquals(expected, actual);

        actual = logParser.getSolvedTaskUsers(df.parse("11.12.2013"), df.parse("19.03.2016"), 18).toString();
        expected = "[Vasya Pupkin]";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetDoneTaskUsers() throws Exception {
        LogParser logParser = new LogParser(initLgParser());
        String actual = logParser.getDoneTaskUsers(null, null).toString();
        String expected = "[Vasya Pupkin, Eduard Petrovich Morozko]";
        assertEquals(expected, actual);

        actual = logParser.getDoneTaskUsers(df.parse("11.12.2013"), df.parse("19.03.2016")).toString();
        expected = "[]";
        assertEquals(expected, actual);
    }

    @Test
    public void testGetDoneTaskUsersInt() throws Exception {
        LogParser logParser = new LogParser(initLgParser());
        String actual = logParser.getDoneTaskUsers(null, null, 15).toString();
        String expected = "[Vasya Pupkin]";
        assertEquals(expected, actual);

        actual = logParser.getDoneTaskUsers(df.parse("11.12.2013"), df.parse("19.03.2016"), 15).toString();
        expected = "[]";
        assertEquals(expected, actual);
    }
}