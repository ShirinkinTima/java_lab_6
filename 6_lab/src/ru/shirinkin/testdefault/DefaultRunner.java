package ru.shirinkin.testdefault;

import ru.shirinkin.annotation.Default;
import java.lang.reflect.Field;

public class DefaultRunner {
    public static void run() {
        // Получаем класс, который хотим проверить
        Class<?> clazz = TestDefault.class;

        // Проверка аннотации на уровне класса
        if (clazz.isAnnotationPresent(Default.class)) {
            // Получаем аннотацию
            Default annotation = clazz.getAnnotation(Default.class);

            // Извлекаем значение (Class)
            Class<?> defaultValue = annotation.value();

            System.out.println("Для класса " + clazz.getSimpleName()
                    + " класс по умолчанию: " + defaultValue.getName());
        } else {
            System.out.println("Аннотация @Default не найдена в классе.");
        }

        // Проверка аннотации на уровне полей.
        // Возвращает массив объектов Field.
        // Каждый объект в этом массиве представляет собой переменную (поле),
        // которая была объявлена внутри класса clazz.
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Default.class)) {
                Default fieldAnnotation = field.getAnnotation(Default.class);
                System.out.println("Для поля '" + field.getName()
                + "' тип по умолчанию: " + fieldAnnotation.value().getSimpleName());
            }
        }
    }
}
