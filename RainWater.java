package com.company;

public class RainWater {
    public static int waterArea(int[] heights) {
        // Write your code here.
        int[] maxes = new int[heights.length];
        int leftMax = 0;
        for(int i = 0; i < heights.length; i++) {
            int height = heights[i];
            maxes[i] = leftMax;
            leftMax = Math.max(height, leftMax);
        }
        int rightMax = 0;
        for(int i = heights.length - 1; i >= 0; i--) {
            int height = heights[i];
            int min = Math.min(rightMax, maxes[i]);
            if(height < min) {
                maxes[i] = min - height;
            } else {
                maxes[i] = 0;
            }
            rightMax = Math.max(rightMax, height);
        }
        int sum = 0;
        for(int i = 0; i < maxes.length; i++) {
            sum += maxes[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = waterArea(arr);
    }
}
