package com.company;

class lcs {
    public static int longestCommonSubsequence(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 0; i < len1; i++) {
            for(int j = 0; j < len2; j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[i+1][j+1] = 1 + dp[i][j];
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[len1][len2];
    }
    public static void main(String[] args) {
        System.out.print(longestCommonSubsequence("abc", "abc"));
    }
}
