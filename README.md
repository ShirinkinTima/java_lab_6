# Лабораторная работа Java №6

## Содержание
1. [Аннотации](#аннотации)
2. [Класс Processor](#класс-processor)
3. [Аннотация @Invoke](#аннотация-invoke)
4. [Аннотация @Default](#аннотация-default)
5. [Аннотация @ToString](#аннотация-tostring)
6. [Аннотация @Validate](#аннотация-validate)
7. [Аннотация @Two](#аннотация-two)
8. [Аннотация @Cache](#аннотация-cache)

## Аннотации

### Перечень созданных аннотаций:
- **@Invoke** - маркер для автоматического вызова методов
- **@Default** - указание типа по умолчанию
- **@ToString** - управление строковым представлением объектов
- **@Validate** - указание классов для валидации
- **@Two** - аннотация с двумя обязательными параметрами
- **@Cache** - указание областей кеширования

## Класс Processor

Основной класс-обработчик, содержащий статические методы для работы с кастомными аннотациями через Reflection API.

## Аннотация @Invoke

### Назначение
Маркерная аннотация для автоматического вызова методов помеченных классов.

### Алгоритм обработки (processInvoke)

1. **Проверка входных данных** - валидация null объекта
```java
if (object == null) {
    throw new NullPointerException("Object is null");
}
```

2. **Сканирование методов** - получение всех методов класса через reflection
```java
for (Method method : object.getClass().getDeclaredMethods()) {
    Invoke inv = method.getAnnotation(Invoke.class);
```

3. **Вызов помеченных методов**
```java
method.invoke(object);
```

4. **Обработка исключений** - перехват ошибок выполнения

**Особенности:** Поддерживает вызов private методов через `setAccessible(true)`


![Img](https://github.com/MineMoon/JavaLab6/blob/main/PNGFR/Invoke1.png)

## Аннотация @Default

### Назначение
Указание типа по умолчанию для классов и полей.

### Алгоритм обработки (processDefaultClass)

1. **Получение аннотации** - извлечение @Default с класса
```java
Default def = someClass.getAnnotation(Default.class);
```

2. **Возврат значения** - возврат класса, указанного в аннотации

### Алгоритм обработки (processDefaultFields)

1. **Сканирование полей** - итерация по всем полям класса
```java
for (Field field : someClass.getDeclaredFields()) {
    field.setAccessible(true);
```

2. **Фильтрация по аннотации** - отбор полей с @Default
```java
Default def = field.getAnnotation(Default.class);
if (def != null) {
    fields.add(field);
}
```

**Особенности:** Работает как на уровне класса, так и на уровне полей


![Img](https://github.com/MineMoon/JavaLab6/blob/main/PNGFR/Default1.png)

## Аннотация @ToString

### Назначение
Управление включением полей в строковое представление объектов.

### Алгоритм обработки (processToString)

1. **Проверка аннотации класса** - определение глобального поведения
```java
ToString toS = object.getClass().getAnnotation(ToString.class);
if(toS.value()==Mode.NO){
    return "The class is annotated with a notation having the NO mode";
}
```

2. **Анализ полей** - проверка аннотации каждого поля
```java
toS = field.getAnnotation(ToString.class);
if (toS == null || toS.value() == Mode.YES) {
```

3. **Формирование результата** - построение строки с учетом фильтрации
```java
result.append(field.getName()).append(" = ").append(field.get(object)).append(",\n");
```

**Особенности:** Поддерживает режимы YES/NO для полей и классов (включать/не включать)


![Img](https://github.com/MineMoon/JavaLab6/blob/main/PNGFR/ToString1.png)

## Аннотация @Validate

### Назначение
Указание списка классов для валидации с автоматическим удалением дубликатов.

### Алгоритм обработки (processValidate)

1. **Валидация входных данных** - проверка null и пустого массива
```java
if (valid.value().length == 0) {
    throw new IllegalArgumentException("The array of classes in @Validate annotation cannot be empty");
}
```

2. **Удаление дубликатов** - использование LinkedHashSet для сохранения порядка
```java
Set<Class<?>> resultSet = new LinkedHashSet<>();
for (Class<?> tempClass : classes) {
    resultSet.add(tempClass);
}
```

3. **Форматирование вывода** - построение читаемого списка классов

**Особенности:** Автоматически удаляет дубликаты, сохраняет порядок элементов


![Img](https://github.com/MineMoon/JavaLab6/blob/main/PNGFR/Validate1.png)

## Аннотация @Two

### Назначение
Аннотация с двумя обязательными параметрами разных типов - строковым (`first`) и целочисленным (`second`). Демонстрирует работу с аннотациями, имеющими несколько обязательных параметров различных типов.

### Алгоритм обработки (processTwo)

1. **Проверка входных данных** - валидация null параметра
```java
if (someClass == null) {
    throw new NullPointerException("someClass is null");
}
```

2. **Извлечение аннотации** - получение аннотации @Two с класса через Reflection
```java
Two two = someClass.getAnnotation(Two.class);
```

3. **Извлечение параметров** - получение значений обоих обязательных параметров
```java
String str = two.first();
int num = two.second();
```

4. **Формирование результата** - возврат значений в виде типизированной пары
```java
return new Pair<>(str, num);
```

5. **Обработка отсутствия аннотации** - возврат пары с значениями по умолчанию и информационным сообщением

### Особенности реализации:
- **Типизированный возврат** - метод возвращает параметризованный объект `Pair<String, Integer>`
- **Защита от отсутствия аннотации** - корректная обработка случаев, когда аннотация отсутствует на классе
- **Сохранение информации о типах** - строгая типизация сохраняется через generics
- **Информативный вывод** - подробное сообщение при отсутствии аннотации


![Img](https://github.com/MineMoon/JavaLab6/blob/main/PNGFR/Two1.png)
## Аннотация @Cache

### Назначение
Указание областей кеширования для класса.

### Алгоритм обработки (processCache)

1. **Обработка массива строк** - извлечение областей кеширования
```java
String[] cacheAreas = cache.value();
```

2. **Фильтрация** - удаление пустых строк и дубликатов
```java
Set<String> resultSet = new LinkedHashSet<>();
for (String area : cacheAreas) {
    if (area != null && !area.trim().isEmpty()) {
        resultSet.add(area);
    }
}
```

3. **Форматированный вывод** - отображение списка областей

**Особенности:** Автоматическая очистка от некорректных значений


![Img](https://github.com/MineMoon/JavaLab6/blob/main/PNGFR/Cache1.png)
