package com.test.test;

public class Test {
    public static void main(String[] args) {

        String str = "ABCDEF";

        char[] chars = str.toCharArray();

        for (int i=0,j=chars.length-1; i<j; i++,j--) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
         }

        System.out.println(new String(chars));

        
    }
}
