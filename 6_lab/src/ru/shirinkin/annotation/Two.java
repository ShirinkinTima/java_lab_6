package ru.shirinkin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация с двумя обязательными свойствами разных типов.
 * Демонстрирует аннотацию с несколькими обязательными параметрами.
 *
 */
@Target(ElementType.TYPE) // Цель: ТИП (класс, интерфейс, enum)
@Retention(RetentionPolicy.RUNTIME) // Доступна во время исполнения
public @interface Two {
    // Обязательное свойство first типа String
    String first();

    // Обязательное свойство second типа int
    int second();
}
