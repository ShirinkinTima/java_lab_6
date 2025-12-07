package ru.shirinkin.testtwo;

import ru.shirinkin.annotation.Two;

public class TwoRunner {
    public static void run() {
        // Получаем ссылку на класс
        Class<TestTwo> targetClass = TestTwo.class;

        System.out.println("Анализ класса: " + targetClass.getSimpleName());

        // Проверяем наличие аннотации
        if (targetClass.isAnnotationPresent(Two.class)) {
            // Получаем экземпляр аннотации
            Two annotation = targetClass.getAnnotation(Two.class);

            // Считываем значения свойств
            String firstValue = annotation.first();
            int secondValue = annotation.second();

            // Выводим результат
            System.out.println("Аннотация @Two найдена.");
            System.out.println("Значение 'first': " + firstValue);
            System.out.println("Значение 'second': " + secondValue);
        } else {
            System.out.println("Аннотация @Two не найдена.");
        }
    }
}
