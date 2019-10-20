package com.company;

class LongestPalindromicString {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) return s;

        String longest = "";
        for(int i = 0; i < len; i++) {
            String s1 = expand(s, i, i);
            if(s1.length() > longest.length()) longest = s1;
            String s2 = expand(s, i, i+1);
            if(s2.length() > longest.length()) longest = s2;


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
        return s.substring(i+1, j);
    }
    public static void main(String[] args) {
        LongestPalindromicString l = new LongestPalindromicString();
        String ans = l.longestPalindrome("babad");
        System.out.print(ans);
    }
}
