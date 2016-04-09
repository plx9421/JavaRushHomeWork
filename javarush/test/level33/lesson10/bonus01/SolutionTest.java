package com.javarush.test.level33.lesson10.bonus01;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alexey on 09.04.2016.
 */
public class SolutionTest {

    @Test
    public void testToXmlWithComment() throws Exception {

        String actual = Solution.toXmlWithComment(new AnExample(), "needCDATA", "it's a comment - <needCDATA>");
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\r\n" +
                "<anExample>\r\n" +
                "    <!--it's a comment - <needCDATA>-->\r\n" +
                "    <needCDATA><![CDATA[need CDATA because of < and >]]></needCDATA>\r\n" +
                "    <!--it's a comment - <needCDATA>-->\r\n" +
                "    <needCDATA/>\r\n" +
                "</anExample>\r\n";
        assertEquals(expected, actual);
    }
}