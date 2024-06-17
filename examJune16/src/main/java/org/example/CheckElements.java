package org.example;

public class CheckElements {
    public static void main(String[] args) {

//        int[] arr1 = {1, 2, 3, 4, 5};
//        int[] arr2 = {1, 2, 3, 4, 5};


        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 4, 5};
        boolean isSame = true;


        if (arr1.length != arr2.length) {
            isSame = false;
        } else {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    isSame = false;
                    break;
                }
            }
        }
        if (isSame) {
            System.out.println("The two arrays are having exactly isSame elements");
        } else {
            System.out.println("The two arrays are not having exactly isSame elements");
        }
    }
}
