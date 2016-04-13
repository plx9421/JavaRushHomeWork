package com.javarush.test.level39.lesson09.big01;

import com.javarush.test.level39.lesson09.big01.query.IPQuery;
import com.javarush.test.level39.lesson09.big01.query.UserQuery;

import java.io.*;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.*;

public class LogParser implements IPQuery, UserQuery {
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
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> ipSet = new HashSet<>();

        for (LogEntry logEntry : logEntries) {
            if (compareDate(after, before, logEntry.getDate())) {
                ipSet.add(logEntry.getIp());
            }
        }
        return ipSet;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> ipSet = new HashSet<>();

        for (LogEntry logEntry : logEntries) {
            if (compareDate(after, before, logEntry.getDate()) && user.equals(logEntry.getName())) {
                ipSet.add(logEntry.getIp());
            }
        }
        return ipSet;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> ipSet = new HashSet<>();

        for (LogEntry logEntry : logEntries) {
            if (compareDate(after, before, logEntry.getDate()) && logEntry.getEvent().contains(event.toString())) {
                ipSet.add(logEntry.getIp());
            }
        }
        return ipSet;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> ipSet = new HashSet<>();

        for (LogEntry logEntry : logEntries) {
            if (compareDate(after, before, logEntry.getDate()) && logEntry.getStatus().contains(status.toString())) {
                ipSet.add(logEntry.getIp());
            }
        }
        return ipSet;
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> userSet = new HashSet<>();

        for (LogEntry logEntry : logEntries) {
            userSet.add(logEntry.getName());
        }
        return userSet;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return getAllUsers().size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        List<String> eventsSet = new ArrayList<>();

        for (LogEntry logEntry : logEntries) {
            if (compareDate(after, before, logEntry.getDate()) && user.equals(logEntry.getName())) {
                eventsSet.add(logEntry.getEvent());
            }
        }
        return eventsSet.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> userSet = new HashSet<>();

        for (LogEntry logEntry : logEntries) {
            if (compareDate(after, before, logEntry.getDate()) && ip.equals(logEntry.getIp())) {
                userSet.add(logEntry.getName());
            }
        }
        return userSet;
    }

    private Set<String> getEventForDate(Event event, Date after, Date before) {
        Set<String> UserSet = new HashSet<>();

        for (LogEntry logEntry : logEntries) {
            if (compareDate(after, before, logEntry.getDate()) && logEntry.getEvent().contains(event.toString())) {
                if (logEntry.getStatus().equals(Status.OK.toString())){
                    UserSet.add(logEntry.getName());
                }
            }
        }
        return UserSet;
    }


    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        return getEventForDate(Event.LOGIN, after, before);
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        return getEventForDate(Event.DOWNLOAD_PLUGIN, after, before);
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        return getEventForDate(Event.WRITE_MESSAGE, after, before);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        return getEventForDate(Event.SOLVE_TASK, after, before);
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> UserSet = new HashSet<>();

        for (LogEntry logEntry : logEntries) {
            if (compareDate(after, before, logEntry.getDate()) && logEntry.getEvent().contains(Event.SOLVE_TASK.toString())) {
                if (logEntry.getStatus().equals(Status.OK.toString())) {
                    if (logEntry.getEvent().contains(task + "")) {
                        UserSet.add(logEntry.getName());
                    }
                }
            }
        }
        return UserSet;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        return getEventForDate(Event.DONE_TASK, after, before);
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> UserSet = new HashSet<>();

        for (LogEntry logEntry : logEntries) {
            if (compareDate(after, before, logEntry.getDate()) && logEntry.getEvent().contains(Event.DONE_TASK.toString())) {
                if (logEntry.getStatus().equals(Status.OK.toString())) {
                    if (logEntry.getEvent().contains(task + "")) {
                        UserSet.add(logEntry.getName());
                    }
                }
            }
        }
        return UserSet;
    }
}
