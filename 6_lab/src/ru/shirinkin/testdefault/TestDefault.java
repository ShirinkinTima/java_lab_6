package ru.shirinkin.testdefault;

import ru.shirinkin.annotation.Default;

// Класс, который мы аннотируем
// Указываем, что классом по умолчанию для него является DefaultClass
@Default(value = DefaultClass.class)
public class TestDefault {
    // Аннотируем поле
    @Default(value = String.class)
    private Object someField;
}

// Класс, который мы будем указывать как дефолтный
class DefaultClass {
}

