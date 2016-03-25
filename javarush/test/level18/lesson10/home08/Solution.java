package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        while (!"exit".equals(str)) {
            new ReadThread(str).start();
            str = reader.readLine();
        }
        reader.close();
    }

    public static class ReadThread extends Thread {
        private FileInputStream fi;
        private String filename;

        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.filename = fileName;
            fi = new FileInputStream(fileName);
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run()
        {
            int[] b = new int[256];
            try {
                while (fi.available() > 0){
                    b[fi.read()]++;                
                }                    
                fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            int iMax=0;
            for (int i = 0; i < b.length; i++) {
                if (b[i] > b[iMax]) iMax = i;
            }
            synchronized (resultMap)
            {
                resultMap.put(filename, (int) iMax);
            }
        }
    }
}
