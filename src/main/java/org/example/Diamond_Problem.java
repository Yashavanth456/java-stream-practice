package org.example;

interface A{
    default void show() {
        System.out.println("Calling from A");
    }
}

interface B{
    default void show() {
        System.out.println("Calling from B");
    }
}

public class Diamond_Problem implements A, B {

    @Override
    public void show() {
        A.super.show(); // Call the show method from interface A
        B.super.show(); // Call the show method from interface B
    }

    public static void main(String[] args) {
        Diamond_Problem dp = new Diamond_Problem();
        dp.show();
    }
}

