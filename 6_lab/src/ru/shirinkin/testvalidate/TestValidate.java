package ru.shirinkin.testvalidate;

import ru.shirinkin.annotation.Validate;

// Если свойство одно и называется 'value', его имя можно опустить при вызове
@Validate({UserValidator.class, DateValidator.class, String.class})
public class TestValidate {
    public void process() {
        System.out.println("Processing data...");
    }
}

// Вспомогательные классы для примера проверки
class UserValidator {}
class DateValidator {}
