package ru.shirinkin.testinvoke;

import ru.shirinkin.annotation.Invoke;

public class TestInvoke {

    @Invoke
    public void methodOne() {
        System.out.println("Вызван methodOne (Public)");
    }

    // Этот метод без аннотации, он не должен вызваться
    public void methodTwo() {
        System.out.println("Этот метод не должен быть вызван.");
    }

    @Invoke
    private void methodThree() {
        System.out.println("Вызван methodThree (Private!)");
    }

    @Invoke
    public void methodFour() {
        System.out.println("Вызван methodFour (Public)");
    }
}