package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес.
Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    //напишите тут ваш код
    String name = null;
    int weight = 3;
    int age = 1;
    int color = 0;
    String adress = null;

    public void initialize(String name){};
    public void initialize(String name, int weight, int age){};
    public void initialize(String name, int age){
        this.name = name;
        this.age = age;
        this.weight = 3;
    };
    public void initialize(int weight, int color){
        this.weight = weight;
        this.color = color;
        this.name = null;
        this.adress = null;
        this.age = 1;
    }
    public void initialize(int weight, int color, String adress){
        this.weight = weight;
        this.color = color;
        this.name = null;
        this.adress = adress;
        this.age = 1;
    }


}
