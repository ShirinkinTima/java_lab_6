package ru.shirinkin.testinvoke;

import java.lang.reflect.Method;
import ru.shirinkin.annotation.*;

public class InvokeRunner {
    public static void run() {
        TestInvoke service = new TestInvoke();

        // Получаем объект типа Class, описывающий наш TestInvoke
        Class<?> clazz = service.getClass();

        // Получаем все методы класса (включая private), используя getDeclaredMethods()
        // Если использовать getMethods(), не увидим private методы
        Method[] methods = clazz.getDeclaredMethods();

        System.out.println("Запуск автоматического вызова методов...\n");

        for (Method method : methods) {
            // Проверяем, стоит ли над методом аннотация @Invoke
            if (method.isAnnotationPresent(Invoke.class)) {
                try {
                    // Разрешаем доступ к методу (нужно для private методов)
                    method.setAccessible(true);

                    // Вызываем метод
                    // Аргументы: (объект, у которого вызвать метод, ...параметры метода)
                    method.invoke(service);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("\nГотово.");
    }
}