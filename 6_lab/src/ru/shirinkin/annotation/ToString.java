package ru.shirinkin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для управления включением полей в строковое представление объекта.
 * Определяет, какие поля должны включаться в результат метода toString.
 *
 */
// Аннотация доступна в Runtime
@Retention(RetentionPolicy.RUNTIME)
// Цель: Класс (TYPE) или Поле (FIELD)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface ToString {

    // Перечисление для вариантов значений
    enum Shape { YES, NO }

    // Свойство со значением по умолчанию YES
    Shape value() default Shape.YES;
}