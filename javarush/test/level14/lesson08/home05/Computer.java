package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Alexey on 28.10.2015.
 */
//        6. � ����� Computer ������ ��������� ���� ���� Keyboard.
//        7. � ����� Computer ������ ��������� ���� ���� Mouse.
//        8. � ����� Computer ������ ��������� ���� ���� Monitor.
//        9. ������ ����������� � ������ Computer ��������� ���������� ������ Alt+Insert ������ ������ (������� Constructor).
//        10 ������ ������������ ��������������� ��� ��� ���� (����������) ������
//        11. ������ ������� ��� ����� ������ Computer (� ������ ��������� ���������� ������ Alt+Insert � ������ ������� Getter).

public class Computer {
    private Keyboard keyboard;
    private Mouse mouse;
    private Monitor monitor;

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public Monitor getMonitor() {
        return monitor;
    }
    public Computer() {
        this.keyboard = new Keyboard();
        this.mouse = new Mouse();
        this.monitor = new Monitor();
    }

    public Computer(Keyboard keyboard, Mouse mouse, Monitor monitor) {
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.monitor = monitor;
    }
}
