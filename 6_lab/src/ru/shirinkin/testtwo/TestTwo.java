package ru.shirinkin.testtwo;

import ru.shirinkin.annotation.Two;

// Так как свойства не имеют значений по умолчанию (default),
// мы обязаны указать их оба.
@Two(first = "Hello, Java!", second = 2025)
public class TestTwo {
    public void doWork() {
    System.out.println("Work...");
    }
}




