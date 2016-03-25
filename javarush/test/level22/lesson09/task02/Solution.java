package com.javarush.test.level22.lesson09.task02;

import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {

        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, String> pair : params.entrySet())
        {
            String key = pair.getKey();
            String value = pair.getValue();

            if (value == null) continue;
            if (result.length() > 0) result.append(" and ");

            result.append(key + " = '" + value + "'");

        }

        return result;
    }

}
