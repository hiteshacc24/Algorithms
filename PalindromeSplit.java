package com.company;

import com.sun.xml.internal.ws.util.StringUtils;

public class PalindromeSplit {

    public static void main(String[] args) {


        System.out.println(findPalindromeSplitIndex("qwwe", "asdq"));
    }

    private static int findPalindromeSplitIndex(String string1, String string2) {
        if (string1.length() == 0 || string2.length() ==0) {
            System.out.println("string1 or string2 cannot be blank or null.");
            return -1;
        }
        if (string1.length() != string2.length()) {
            System.out.println("Length of 2 strings is not equal.");
            return -1;
        }
        if (string1.length() == 1) {
            if (string1.equals(string2)) {
                return 0;
            }
            else {
                return -1;
            }
        }
        int length = string1.length();
        for (int i = 0; i < length/2; i++) {
            if (string1.charAt(i) != string2.charAt(length - i - 1)) {
                return -1;
            }
        }
        return length/2;
    }
}