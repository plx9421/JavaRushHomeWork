package com.javarush.test.level39.lesson09.big01;

import java.nio.file.Paths;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        LogParser logParser = new LogParser(Paths.get("C:\\Users\\Alexey\\OneDrive\\Documents\\workspace.java\\JavaRushHomeWork\\src\\com\\javarush\\test\\level39\\lesson09\\big01\\logs\\"));
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
    }
}
