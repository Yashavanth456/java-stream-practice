package org.example;

public class Test implements A, B{

    @Override
    public void show(){
        System.out.println("Calling from Test");
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.show();
    }
}
