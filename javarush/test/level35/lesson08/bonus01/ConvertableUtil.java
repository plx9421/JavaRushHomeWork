package com.javarush.test.level35.lesson08.bonus01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <N extends Convertable> Map convert(List<N> list) {
        Map result = new HashMap();

        for (N n : list)
            result.put(n.getKey(), n);

        return result;
    }
}
