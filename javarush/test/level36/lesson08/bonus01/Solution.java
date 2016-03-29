package com.javarush.test.level36.lesson08.bonus01;

/* Разбираемся в красно-черном дереве
Дана реализация красно-черного дерева.
Некоторые методы сломаны. Разберитесь в коде и исправьте ошибки.
Метод main не участвует в тестировании.
Все модификатры правильные.
Имена переменных и методов не изменяйте.
*/
public class Solution {
    public static void main(String[] args) {

        RedBlackTree redBlackTree = new RedBlackTree();

        redBlackTree.insert(13);
        redBlackTree.insert(8);
        redBlackTree.insert(17);
        redBlackTree.insert(22);
        redBlackTree.insert(27);
        redBlackTree.insert(6);
        redBlackTree.insert(11);

        System.out.println(redBlackTree.toString());
    }
}
