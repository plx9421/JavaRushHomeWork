package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())));

        while (br.ready()) {
            String inpuntLine = br.readLine();
            String[] arrayInputLine = inpuntLine.split(" ");
            for (int i = 0; i < arrayInputLine.length; i++) {
                String primeString = arrayInputLine[i];
                String reversString = new StringBuilder(primeString).reverse().toString();
                boolean wordPresent = false;
                for (int j = 0; j < result.size(); j++) {
                    Pair p1 = result.get(j);
                    if (p1.second != null) continue;
                    wordPresent = true;
                    if (primeString.equals(p1.first)) {
                        if (primeString.equals(reversString)) {
                            p1.second = primeString;
                            wordPresent = true;
                            break;
                        }
                    }
                    if (reversString.equals(p1.second)) break;
                    if (primeString.equals(p1.second)) break;

                    if (reversString.equals(p1.first)) {
                        p1.second = primeString;
                        wordPresent = true;
                        break;
                    }
                    wordPresent = false;
                }
                if (!wordPresent) {
                    Pair p2 = new Pair();
                    p2.first = primeString;
                    result.add(p2);
                }
            }
        }
        for (int i = result.size()-1; i >= 0; i--) {
            if (result.get(i).second == null) result.remove(i);
        }

        for (Pair p : result) {
            System.out.println(p.toString());
        }
        reader.close();
        br.close();
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
