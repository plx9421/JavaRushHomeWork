package com.javarush.test.level38.lesson06.home01;

/**
 * Created by Alexey on 12.04.2016.
 */
public class FabricException {
    public static Throwable getException(Enum message) {
        String result = message.toString().charAt(0) + message.toString().substring(1).replaceAll("_", " ").toLowerCase();

        if (message instanceof ExceptionApplicationMessage) {
            return new Exception(result);
        }
        if (message instanceof ExceptionDBMessage) {
            return new RuntimeException(result);
        }
        if (message instanceof ExceptionUserMessage) {
            return new Error(result);
        }

        return new IllegalArgumentException();
    }
}
