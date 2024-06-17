package org.example;

public class NumsDivisibleBy {
    public static void main(String[] args) {

        int num = 100;
        System.out.print("Numbers divisible by 3 are: ");
        for (int i = 1; i <= num; i++) {
             if (i % 3 == 0) {
                System.out.print(i + ",");
            }
        }
        System.out.println();
        System.out.print("Numbers divisible by 5 are: ");
        for (int i = 1; i <num ; i++) {
            if(i%5==0){

                System.out.print( i + ",");
            }
        }
        System.out.println();
        System.out.print("Numbers divisible by 3 & 5 are: ");
        for (int i = 1; i <num ; i++) {
            if(i%3==0 && i%5==0){
                System.out.print(  i + ",");
            }
        }

    }
}
