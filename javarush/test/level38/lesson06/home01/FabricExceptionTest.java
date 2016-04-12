package com.javarush.test.level38.lesson06.home01;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alexey on 12.04.2016.
 */
public class FabricExceptionTest {

    @Test
    public void testGetException() throws Exception {
        FabricException.getException(ExceptionApplicationMessage.SOCKET_IS_CLOSED).getMessage();
        FabricException.getException(ExceptionApplicationMessage.UNHANDLED_EXCEPTION);
        FabricException.getException(ExceptionDBMessage.NOT_ENOUGH_CONNECTIONS);
        FabricException.getException(ExceptionDBMessage.RESULT_HAS_NOT_GOTTEN_BECAUSE_OF_TIMEOUT);
    }
}