package com.javarush.test.level38.lesson06.home01;

/**
 * Created by Alexey on 12.04.2016.
 */
public class FabricException {
    public static Throwable getException(Enum message) {
        String result = "";
        if (message instanceof ExceptionApplicationMessage) {
            result = message.toString().substring(0, 1) + message.toString().substring(1).replace("_", " ").toLowerCase();
            return new Exception(result);
        }
        if (message instanceof ExceptionDBMessage) {
            result = message.toString().substring(0, 1) + message.toString().substring(1).replace("_", " ").toLowerCase();
            return new RuntimeException(result);
        }
        if (message instanceof ExceptionUserMessage) {
            result = message.toString().substring(0, 1) + message.toString().substring(1).replace("_", " ").toLowerCase();
            return new Error(result);
        }


        return new IllegalArgumentException();
    }
}
