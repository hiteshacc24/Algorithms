package com.company;

import java.util.ArrayList;
import java.util.List;

class PartitionLabel {
    public static List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastIndexes = new int[26];
        for(int i = 0; i < s.length(); i++) {
            lastIndexes[s.charAt(i) - 'a'] = i;
        }
        int i = 0;
        while(i < s.length()) {
            int end = lastIndexes[s.charAt(i) - 'a'];
            int j = i;
            while(j < end) {
                end = Math.max(end, lastIndexes[s.charAt(j) - 'a']);
                j++;
            }
            result.add(j - i + 1);
            i = j+1;
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.print(partitionLabels(s));
    }
}