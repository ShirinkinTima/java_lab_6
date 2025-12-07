package ru.shirinkin.testvalidate;

import ru.shirinkin.annotation.Validate;

public class ValidateRunner {
    public static void run() {
        // Получаем класс, который хотим проверить
        Class<TestValidate> targetClass = TestValidate.class;

        System.out.println("Анализ класса: " + targetClass.getSimpleName());

        // Проверяем наличие аннотации
        if (targetClass.isAnnotationPresent(Validate.class)) {
            // Получаем экземпляр аннотации
            Validate validateAnnotation = targetClass.getAnnotation(Validate.class);

            // Извлекаем массив классов из свойства value()
            Class<?>[] classesToValidate = validateAnnotation.value();

            System.out.println("Найдена аннотация @Validate.");
            System.out.println("Список классов для проверки:");

            // Выводим классы
            for (Class<?> clazz : classesToValidate) {
                System.out.println(" - " + clazz.getName());
            }
        } else {
            System.out.println("Аннотация @Validate не найдена.");
        }
    }
}
