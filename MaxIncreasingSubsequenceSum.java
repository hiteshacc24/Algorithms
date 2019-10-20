package com.company;

import java.util.*;

public class MaxIncreasingSubsequenceSum {
    public static List<List<Integer>> maxSum(int[] array) {
        if(array == null || array.length == 0) return new ArrayList<>();
        int[] sequences = new int[array.length];
        Arrays.fill(sequences, Integer.MIN_VALUE);
        int[] sums = array.clone();
        int maxIdx = 0;
        for(int i = 0; i < array.length; i++) {
            int currentNum = array[i];
            for(int j = 0; j < i; j++) {
                int otherNum = array[j];
                if(otherNum < currentNum && currentNum + sums[j] >= sums[i]) {
                    sums[i] = currentNum + sums[j];
                    sequences[i] = j;
                }
            }
            if(sums[i] >= sums[maxIdx]) {
                maxIdx = i;
            }

        }
        return buildSequence(array, sequences, maxIdx, sums[maxIdx]);
    }
    public static List<List<Integer>> buildSequence(int[] array, int[] sequences, int currentIdx, int maxSum) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        result.get(0).add(maxSum);
        while(currentIdx != Integer.MIN_VALUE) {
            result.get(1).add(0, array[currentIdx]);
            currentIdx = sequences[currentIdx];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] array = {8, 12, 2, 3, 15, 5, 7};
        List<List<Integer>> result = maxSum(array);
        System.out.print(result);

    }
}
