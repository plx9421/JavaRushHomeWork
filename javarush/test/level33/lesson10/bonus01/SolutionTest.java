package com.javarush.test.level33.lesson10.bonus01;

import com.javarush.test.level33.lesson10.home01.Shop;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Alexey on 16.03.2016.
 */
public class SolutionTest {

    @Test
    public void testToXmlWithComment() throws Exception {
//        System.out.println(new Solution().toXmlWithComment(new Shop(), "count", "test a comment"  ));

        System.out.println(new Solution().toXmlWithComment(new AnExample(), "needCDATA", "it's a comment - <needCDATA>"));

    }
}