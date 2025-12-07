package ru.shirinkin.testtostring;

import ru.shirinkin.annotation.ToString;

import java.lang.reflect.Field;

public class ToStringRunner {
    public static String generate(Object object) {
        Class<?> clazz = object.getClass();

        // Cтоит ли аннотация на самом классе
        if (!clazz.isAnnotationPresent(ToString.class)) {
            return object.toString(); // Если нет аннотации, возвращаем стандартный toString
        }

        // Начинаем собирать строку
        StringBuilder sb = new StringBuilder();
        sb.append(clazz.getSimpleName()).append("{");

        // Возвращает массив объектов Field.
        // Каждый объект в этом массиве представляет собой переменную (поле),
        // которая была объявлена внутри класса clazz
        Field[] fields = clazz.getDeclaredFields();
        boolean first = true; // для прикольной записи

        for (Field field : fields) {
            // Разрешаем доступ к private полям
            field.setAccessible(true);

            boolean includeField = true;

            // Проверяем наличие аннотации на конкретном поле
            if (field.isAnnotationPresent(ToString.class)) {
                ToString annotation = field.getAnnotation(ToString.class);
                // Если явно сказано NO — не включаем
                if (annotation.value() == ToString.Shape.NO) {
                    includeField = false;
                }
            }
            // Если аннотации на поле нет, оно включается по умолчанию (так как default YES)

            if (includeField) {
                try {
                    if (!first) {
                        sb.append(", ");
                    }
                    // "Название поля = содержание поля"
                    sb.append(field.getName()).append("='").append(field.get(object)).append("'");
                    first = false;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        sb.append("}");
        return sb.toString();
    }
}
