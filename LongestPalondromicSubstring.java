package com.company;

//Longest Palindromic Substring
//Given a string s, find the longest palindromic substring in s. You may assume that the
//maximum length of s is 1000.
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.

class LongestPalondromicSubstring {
    public String longestpalindromic(String s) {
        int len = s.length();
        if(len < 2) return s;

        String longest = "";
        for(int i = 0; i <  len; i++) {
            String temp1 = expand(s, i, i);
            if(temp1.length() > longest.length()) {
                longest = temp1;
            }
            String temp2 = expand(s, i, i + 1);
            if(temp2.length() > longest.length()) {
                longest = temp2;
            }

        }
        return longest;
    }
    public String expand(String s, int start, int end) {
        int i = start;
        int j = end;
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }
    public static void main(String[] args) {
        LongestPalondromicSubstring l = new LongestPalondromicSubstring();
        String ans = l.longestpalindromic("babad");
        System.out.print(ans);
    }
}
