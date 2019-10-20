package com.company;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);

                return result;
            }

            map.put(nums[i], i);
        }

        return result;
    }
    public int minSwapsCouples(int[] row) {
        Arrays.sort(row);
        int count = 0;
        for(int i = 0; i < row.length; i++ ) {
            if(i != row[i]) count++;
        }
        return count/2;
    }
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] arr = {1,2,11,15,4,5};
//        int[] arr1 = new int[2];
//        arr1 = s.twoSum(arr, 9);
        int[] arr = {0, 2, 1, 3};
        int res = s.minSwapsCouples(arr);
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] abc = s.reorderLogFiles(logs);
        int[][] matrix = {
                {1,1,1},
                {2,2,2},
                {3,3,3}
        };
        Arrays.sort(matrix);

    }
}