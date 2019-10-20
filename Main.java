package com.company;
import java.util.*;
class Main {
    public static int maxNumberOfBalloons(String text) {
        int[] hash = new int[26];
        for(char c : text.toCharArray()) {
            hash[c-'a']++;
        }
        hash['l'-'a']/=2;
        hash['o'-'a']/=2;
        String b = "balloon";
        int min=Integer.MAX_VALUE;
        for(char c : b.toCharArray()) {
            min=Math.min(min, hash[c-'a']);
        }
        return min;
    }
    public static void main(String[] args) {
        System.out.print(maxNumberOfBalloons("ballon"));
    }
}
