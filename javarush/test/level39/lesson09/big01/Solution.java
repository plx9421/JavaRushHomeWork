package com.javarush.test.level39.lesson09.big01;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("C:\\Users\\Alexey\\OneDrive\\Documents\\workspace.java\\JavaRushHomeWork\\src\\com\\javarush\\test\\level39\\lesson09\\big01\\logs\\"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));

        for (String ip : logParser.getUniqueIPs(null, new Date())) System.out.println(ip);

        System.out.println();
        for (String ip : logParser.getIPsForUser("Eduard Petrovich Morozko", null, new Date())) System.out.println(ip);

        System.out.println();
        for (String ip : logParser.getIPsForEvent(Event.WRITE_MESSAGE, null, new Date())) System.out.println(ip);

        System.out.println();
        for (String ip : logParser.getIPsForStatus(Status.OK, null, new Date())) System.out.println(ip);

        System.out.println("getUsersForIP:");
        for (String ip : logParser.getUsersForIP("127.0.0.1", null, new Date())) System.out.println(ip);

        System.out.println("getLoggedUsers:");
        for (String ip : logParser.getLoggedUsers(null, new Date())) System.out.println(ip);

        System.out.println("getSolvedTaskUsers");
        for (String ip : logParser.getSolvedTaskUsers(null, new Date(), 1)) System.out.println(ip);

        System.out.println("getDoneTaskUsers");
        for (String ip : logParser.getDoneTaskUsers(null, new Date(), 15)) System.out.println(ip);


    }
}
