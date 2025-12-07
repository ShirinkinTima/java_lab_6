package ru.shirinkin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для указания областей кеширования.
 * Используется для пометки классов, которые должны кешироваться в указанных областях.
 *
 */
@Target(ElementType.TYPE) // Цель: ТИП (класс, интерфейс)
@Retention(RetentionPolicy.RUNTIME) // Доступна через рефлексию (runtime)
public @interface Cache {
    // Необязательное свойство value типа String[]
    // Значение по умолчанию: пустой массив
    String[] value() default {};
}

