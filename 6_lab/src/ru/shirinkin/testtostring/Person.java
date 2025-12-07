package ru.shirinkin.testtostring;

import ru.shirinkin.annotation.ToString;

@ToString // По умолчанию value = YES
public class Person {
    // Аннотации нет. Значит, по умолчанию YES
    private String name;
    private int age;

    // Исключаем это поле
    @ToString(ToString.Shape.NO)
    private String password;

    public Person(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }
}