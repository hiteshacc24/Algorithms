package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0) return result;
        HashMap<Integer, List<Integer[]>> map = new HashMap<>();
        for(int i = 1; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int currentSum = nums[i] + nums[j];
                int diff = target - currentSum;
                if(map.containsKey(diff)) {
                    for(Integer[] pair : map.get(diff)) {
                        result.add(new ArrayList<>(Arrays.asList(pair[0], pair[1], nums[i], nums[j])));
                    }
                }
            }
            for(int k = 0; k < i; k++) {
                int currentSum = nums[i] + nums[k];
                Integer[] pair = {nums[i], nums[k]};
                if(!map.containsKey(currentSum)) {
                    List<Integer[]> newPair = new ArrayList<>();
                    newPair.add(pair);
                    map.put(currentSum, newPair);
                } else {
                    map.get(currentSum).add(pair);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] array = {-3,-2,-1,0,0,1,2,3};
        List<List<Integer>> result = fourSum(array, 0);
        System.out.print(result);
    }
}