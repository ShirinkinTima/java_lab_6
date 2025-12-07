package ru.shirinkin.testcache;

import ru.shirinkin.annotation.Cache;

// Так как свойство называется 'value', имя можно опустить.
// Передаем несколько областей для кеширования.
@Cache({ "UserCache", "ProductCache", "Settings" })
class TestCache {
    public void connect() {
        System.out.println("Connected to DB");
    }
}

// Пример класса с пустым списком (используется значение default)
@Cache
class TempService {
}
