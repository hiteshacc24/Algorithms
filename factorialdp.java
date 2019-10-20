package com.company;

public class factorialdp {
    public static int factorial(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] * i;
        }
        return n * dp[n-1];
     }
    public static void main(String[] args) {
        int x = factorial(10);
        System.out.print(x);
    }
}
