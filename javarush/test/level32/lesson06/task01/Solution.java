package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        boolean smallIsPresent = false;
//        boolean numIsPresent = false;
//        boolean bigIsPresent = false;
//        do {
//            while (byteArrayOutputStream.size() < 8) {
//                switch ((int) (Math.random() * 3)) {
//                    case 1:
//                        byteArrayOutputStream.write((byte) (Math.random() * 10 + 48));
//                        numIsPresent = true;
//                        break;
//                    case 2:
//                        byteArrayOutputStream.write((byte) (Math.random() * 26 + 65));
//                        bigIsPresent = true;
//                        break;
//                    default:
//                        byteArrayOutputStream.write((byte) (Math.random() * 26 + 97));
//                        smallIsPresent = true;
//                        break;
//                }
//            }
//        }
//        while(!smallIsPresent && !numIsPresent && bigIsPresent);


        byteArrayOutputStream.write((byte) (Math.random() * 10 + 48));
        byteArrayOutputStream.write((byte) (Math.random() * 10 + 48));
        byteArrayOutputStream.write((byte) (Math.random() * 10 + 48));
        byteArrayOutputStream.write((byte) (Math.random() * 10 + 48));
        byteArrayOutputStream.write((byte) (Math.random() * 26 + 97));
        byteArrayOutputStream.write((byte) (Math.random() * 26 + 65));
        byteArrayOutputStream.write((byte) (Math.random() * 26 + 97));
        byteArrayOutputStream.write((byte) (Math.random() * 26 + 65));

        return byteArrayOutputStream;
    }
}
