package ru.lukdiman.multithreading.bytecode;

public class ExceptionExample {
    public void foo() {
        try {
            tryMethod();
        } catch (Exception e) {
            catchMethod();
        } finally {
            finallyMethod();
        }
    }

    private void tryMethod() throws Exception {}

    private void catchMethod() {}

    private void finallyMethod() {}
}
