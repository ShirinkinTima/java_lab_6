package ru.shirinkin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Аннотация-маркер для автоматического вызова методов.
 * Методы, помеченные этой аннотацией, будут автоматически вызваны обработчиком.
 *
 */
// Аннотация будет доступна во время выполнения (Runtime)
@Retention(RetentionPolicy.RUNTIME)
// Аннотацию можно вешать только на методы
@Target(ElementType.METHOD)
public @interface Invoke {
    // Внутри пусто, так как по условию свойств нет
}