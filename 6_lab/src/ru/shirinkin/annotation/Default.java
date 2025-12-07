package ru.shirinkin.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация для указания типа по умолчанию.
 * Может применяться к классам и полям для определения типа по умолчанию.
 *
 */
// Аннотация будет доступна через Reflection API при запуске
@Retention(RetentionPolicy.RUNTIME)
// Можно вешать на классы/интерфейсы (TYPE) и на поля (FIELD)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Default {
    // Обязательное свойство типа Class
    Class<?> value();
}