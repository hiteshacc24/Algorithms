package com.company;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class palindrom2 {
    public boolean validPalindrome(String s) {
        if(s.length() == 0) return true;
        int i = 0;
        int j = s.length() - 1;
        int count = 0;
        while(i < j) {
            while(i < j && Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while(i < j && Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if(i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                count++;
            }
            i++;
            j--;
        }
        if(count > 1) {
            return false;
        }
        else if(count == 0 ) {
            return true;
        }
        else if(count == 1 && s.length() > 3) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        palindrom2 p = new palindrom2();
        String s = "abc";
        boolean b = p.validPalindrome(s);
        System.out.print(b);
        Queue<String> q = new LinkedList<String>();

    }
}
