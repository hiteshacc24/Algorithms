package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatternMatching {

    public List<Integer> strStr(String haystack, String needle) {
        List<Integer> result = new ArrayList<>();
        int[] pattern = buildPattern(needle);
        int i = 0;
        int j = 0;
        while(i < haystack.length() && j < needle.length()) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                if(j == needle.length() - 1) {
                    result.add(i - needle.length() + 1);
                    i++;
                    j = 0;
                }
            } else if(j > 0) {
                j = pattern[j - 1] + 1;
            } else {
                i++;
            }
        }
        return result;
    }
    public int[] buildPattern(String substring) {
        int[] pattern = new int[substring.length()];
        Arrays.fill(pattern, -1);
        int i = 1;
        int j = 0;
        while(i < substring.length()) {
            if(substring.charAt(i) == substring.charAt(j)) {
                pattern[i] = j;
                i++;
                j++;
            } else if(j > 0) {
                j = pattern[j - 1] + 1;
            } else {
                i++;
            }
        }
        return pattern;
    }
    public static void main(String[] args) {
        PatternMatching p = new PatternMatching();
        int i = 0;
        List<Integer> result = new ArrayList<>();
        result = p.strStr("mississippi", "s");
        System.out.print(result);
    }
}
