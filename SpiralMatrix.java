package com.company;

public class SpiralMatrix {
    public static int[][] spiral(int n) {
        int k = 1;
        int[][] matrix = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;

        while(k <= n*n) {

            for(int i = left; i <= right; i++) {
                matrix[top][i] = k;
                k++;
            }
            top++;
            for(int i = top; i <= bottom; i++) {
                matrix[i][bottom] = k;
                k++;
            }
            right--;
            for(int i = right; i >= left; i--) {
                matrix[bottom][i] = k;
                k++;
            }
            bottom--;
            for(int i = bottom; i >= top; i--) {
                matrix[i][left] = k;
                k++;
            }
            left++;

        }
        return matrix;
    }
    public static void main(String[] args) {
        int[][] result = spiral(4);
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + ",");
            }
            System.out.println();
        }
    }
}
