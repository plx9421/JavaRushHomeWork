package com.javarush.test.level39.lesson09.big01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alexey on 13.04.2016.
 */
public class LogEntry {
    private String ip;
    private String name;
    private Date date;
    private String event;
    private Status status;

    public LogEntry(String logString) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy' 'HH:mm:ss");

        String[] logArray = logString.split("\\t");
        ip = logArray[0];
        name = logArray[1];
        date = df.parse(logArray[2]);
        event = logArray[3];
        status = Status.valueOf(logArray[4]);
    }

    public String getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Status getStatus() {
        return status;
    }

    public String  getEvent() {
        return event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LogEntry)) return false;

        LogEntry logEntry = (LogEntry) o;

        if (!ip.equals(logEntry.ip)) return false;
        if (!name.equals(logEntry.name)) return false;
        if (!date.equals(logEntry.date)) return false;
        if (status != logEntry.status) return false;
        return event == logEntry.event;

    }

    @Override
    public int hashCode() {
        int result = ip.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + event.hashCode();
        return result;
    }
}
