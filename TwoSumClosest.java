package com.company;

import java.util.Arrays;

public class TwoSumClosest {
    public static int[] twoSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[2];
        while(i < j) {
            int diff = target - (nums[i] + nums[j]);
            if(diff > 0) {
                if(diff < minDiff) {
                    minDiff = diff;
                    result[0] = nums[i];
                    result[1] = nums[j];
                }
                i++;
            } else if(diff < 0) {
                j--;
            } else {
                result[0] = nums[i];
                result[1] = nums[j];
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] result = twoSumClosest(nums, 10);
        System.out.print(result[0] + " , " + result[1] );
    }
}
