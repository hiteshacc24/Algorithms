package com.company;

public class GFG {
    public static int max_sum(int[] arr, int n, int k) {
        if(n < k) {
            return -1;
        }
        int max_sum = Integer.MIN_VALUE;
        for(int i = 0; i < n - k + 1; i++) {
            int current_sum = 0;
            for(int j = 0; j < k ; j++) {
                current_sum += arr[ i + j ];
            }
            max_sum = Math.max(max_sum, current_sum);
        }
        return max_sum;
    }
    public static int sw(int[] arr, int n, int k) {
        if(n < k) {
            return -1;
        }
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int window_sum = sum;
        for(int i = k ; i <  n; i++) {
            window_sum += arr[i] - arr[i - k];
            sum = Math.max(window_sum, sum);
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr = {100,200,300,400};
        int n = arr.length;
        int sum = sw(arr, n,2);
        System.out.println(sum);
    }
}
