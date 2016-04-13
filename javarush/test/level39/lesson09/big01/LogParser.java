package com.javarush.test.level39.lesson09.big01;

import com.javarush.test.level39.lesson09.big01.query.IPQuery;

import java.io.*;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.*;

public class LogParser implements IPQuery {
    private Set<LogEntry> logEntries = new HashSet<>();

    public LogParser(Path logDir) {
        List<File> logFileList = getFileTree(logDir.toString());
        for (File loop : logFileList) {
            try (BufferedReader reader = new BufferedReader(new FileReader(loop))) {
                while (reader.ready()) {
                    logEntries.add(new LogEntry(reader.readLine()));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private List<File> getFileTree(String root) {
        List<File> fileList = new ArrayList<>();
        File rootDir = new File(root);
        File[] subDirs = rootDir.listFiles();
        for (File file : subDirs) {
            if (file.isFile() && file.getName().endsWith(".log")) {
                fileList.add(file);
            }
        }
        return fileList;
    }

    private boolean compareDate(Date after, Date before, Date date) {
        if (after != null && before != null) {
            return before.getTime() >= date.getTime() && after.getTime() <= date.getTime();
        }
        if (after == null && before != null) {
            return before.getTime() >= date.getTime();
        }
        return after == null || after.getTime() <= date.getTime();
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set<String> ipSet = new HashSet<>();

        for (LogEntry logEntry : logEntries) {
            if (compareDate(after, before, logEntry.getDate())) {
                ipSet.add(logEntry.getIp());
            }
        }

        return ipSet.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return null;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return null;
    }
}
