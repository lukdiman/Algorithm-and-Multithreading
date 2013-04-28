package ru.lukdiman.multithreading.bytecode;

public class Step {
    public static void main(String[] args) {
        foo();
    }

    private static void foo() {
        bar();
    }

    private static void bar() {
        test();
    }

    private static void test() {
        System.out.println("test");
    }
}
