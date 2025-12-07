package ru.shirinkin.testcache;

import ru.shirinkin.annotation.Cache;

public class CacheRun {
    public static void run() {
        // Выбираем класс для проверки (можно поменять на TempService.class для теста пустого списка)
        Class<?> targetClass = TestCache.class;

        System.out.println("Анализ класса: " + targetClass.getSimpleName());

        // Проверяем наличие аннотации
        if (targetClass.isAnnotationPresent(Cache.class)) {
            // Получаем аннотацию
            Cache cacheAnnotation = targetClass.getAnnotation(Cache.class);

            // Получаем массив строк
            String[] regions = cacheAnnotation.value();

            // Логика вывода
            if (regions.length > 0) {
                System.out.println("Список кешируемых областей:");
                for (String region : regions) {
                    System.out.println(" - " + region);
                }
            } else {
                System.out.println("Список кешируемых областей пуст.");
            }
        } else {
            System.out.println("Аннотация @Cache не найдена.");
        }
    }
}
