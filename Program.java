package com.company;

import java.util.*;
import java.util.HashMap;

class Program {
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        // Write your code here.
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int i = 0;
        int j = 0;
        int difference = Integer.MAX_VALUE;
        int[] result = new int[2];
        int current_difference  = Integer.MAX_VALUE;
        while(i < arrayOne.length && j < arrayTwo.length) {
            int firstnum = arrayOne[i];
            int secondnum = arrayTwo[j];
            if(firstnum < secondnum) {
                current_difference = secondnum - firstnum;
                i++;
            } else if(secondnum < firstnum) {
                current_difference =  firstnum - secondnum;
                j++;
            } else {
                result[0] = firstnum;
                result[1] = secondnum;
                return result;
            }
            if(current_difference < difference) {
                difference = current_difference;
                result = new int[] {firstnum, secondnum};
            }
        }
        return result;
    }
    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        if(array.length == 0) return new int[0];
        int[] result = {-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++) {
            int complement = targetSum - array[i];
            if(map.containsKey(complement)) {
                result[0] = complement;
                result[1] = map.get(complement);
                Arrays.sort(result);
                return result;
            }
            map.put(complement, array[i]);
        }
        return new int[0];
    }
    public static int[] subarraySort(int[] array) {
        // Write your code here.
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++) {
            int num = array[i];
            if(isOutOfOrder(i, num, array)) {
                min = Math.max(min, num);
                max = Math.max(max, num);
            }
        }
        if(min == Integer.MAX_VALUE){
            return new int[]{-1, -1};
        }
        int i = 0;
        int j = array.length - 1;
        while(min >= array[i]) i++;
        while(max <= array[j]) j--;
        return new int[] {i, j};

    }
    public static boolean isOutOfOrder(int i, int num, int[] array) {
        if(i == 0) return num > array[i + 1];
        if(i == array.length - 1) return num < array[i - 1];

        return num > array[i + 1] || num < array[i - 1];
    }
    public static int maxProduct(int[] nums) {
        int maxProdCurr = nums[0];
        int maxProd = nums[0];
        for(int i = 1; i < nums.length; i++) {
            maxProdCurr = Math.max(nums[i], maxProdCurr * nums[i]);
            maxProd = Math.max(maxProd, maxProdCurr);
        }
        return maxProd;
    }
    public static int longestConsecutive(int[] nums) {
        int[] bestRange = new int[2];
        int longest = 0;
        HashMap<Integer, Boolean> map = new HashMap();
        for(int num : nums) {
            map.put(num, true);
        }
        for(int num : nums) {
            if(!map.get(num)) continue;
            map.put(num, false);
            int left = num - 1;
            int right = num + 1;
            int current_len = 1;
            while(map.containsKey(left)) {
                map.put(left, false);
                current_len++;
                left--;
            }
            while(map.containsKey(right)) {
                map.put(right, false);
                current_len++;
                right++;
            }
            if(current_len > longest) {
                longest = current_len;
                bestRange[0] = left + 1;
                bestRange[1] = right - 1;
            }
        }
        return bestRange[1] - bestRange[0] + 1;
    }
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        // Write your code here.
        int[] minWays = new int[n + 1];
        Arrays.fill(minWays, Integer.MAX_VALUE);
        minWays[0] = 0;
        int toCompare = 0;
        for(int denom : denoms) {
            for(int amount = 0; amount < minWays.length; amount++) {
                if(denom <= amount) {
                    if(minWays[amount - denom] == Integer.MAX_VALUE) {
                        toCompare = minWays[amount - denom];
                    } else {
                        toCompare = 1 + minWays[amount - denom];
                    }
                    minWays[amount] = Math.min(minWays[amount], toCompare);
                }
            }
        }
        if(minWays[n] == Integer.MAX_VALUE) {
            return -1;
        } else return minWays[n];
    }
    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        int[] result = new int[3];
        PriorityQueue<Integer> p = new PriorityQueue<>((x, y) -> y - x);
        for(int num : array) {
            p.add(num);
        }
        for(int i = 2; i >= 0; i--) {
            if(!p.isEmpty()) {
                result[i] = p.poll();
            }
        }
        return result;
    }
    public static void main(String[] args) {
        //int[] arr = {1,2,3,4,5,6};
        //int[] result = twoNumberSum(arr, 8);
        //int[] arr2 = {100,4,200,1,3,2};
        //int[] ans = smallestDifference(arr,arr2);
        //int[] array = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        //int[] ans = subarraySort(array);
        //System.out.print(maxProduct(arr2));
        //System.out.print(longestConsecutive(arr2));
        int[] denom = {7,8,551,2, 3, 4, 89};
        int[] a = findThreeLargestNumbers(denom);
    }
}
