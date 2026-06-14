package org.example;

import java.util.function.Function;

class Pdf_Programs {
    public static void main(String[] args) {
        int number = 5;
        Function<Integer, Integer> oddEven = (n) -> (n % 2 == 0) ? 1 : 0;
        int result = oddEven.apply(number);
        if (result == 1) {
            System.out.println(number + " is an even number.");
        } else {
            System.out.println(number + " is an odd number.");
        }
    }
}
