package org.example;

public class CheckNumIsPrime {
    public static void main(String[] args) {
        int num = 1;
        boolean isPrime = true;

        if (num <= 1) {
            System.out.println(num + " is not a prime number.");
            return;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }
}
