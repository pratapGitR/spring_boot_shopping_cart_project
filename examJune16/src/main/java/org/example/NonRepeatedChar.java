package org.example;

public class NonRepeatedChar {
    public static void main(String[] args) {

        String str = "AADRAFDTYSS";
        String nonRepeatedChar = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
                nonRepeatedChar += str.charAt(i);
            }
        }
        System.out.println(nonRepeatedChar.charAt(0));
    }
}
