package org.example;

public class ReverseIntArr {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int[] reverse = new int[arr.length]; //will be same length as arr
        System.out.println("Original array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //populating reverse array
        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            reverse[j] = arr[i];
            j++;
        }
        System.out.println("Reverse array: ");
        //printing reverse array
        for (int k : reverse) {
            System.out.print(k + " ");
        }
    }
}
