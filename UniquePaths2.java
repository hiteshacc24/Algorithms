package com.company;

import java.util.Stack;

public class UniquePaths2 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid == null) return 0;

        int rows = obstacleGrid.length;
        int cols = obstacleGrid.length;

        int[][] dirs = new int[][]{
                {1, 0},
                {0, 1}
        };
        Stack<Coordinate> stack = new Stack<>();
        stack.push(new Coordinate(0, 0));
        int path = 0;
        while(!stack.isEmpty()) {
            int size = stack.size();
            for(int i = 0; i < size; i++) {
                Coordinate c = stack.pop();
                for(int[] dir : dirs) {
                    int x = c.x + dir[0];
                    int y = c.y + dir[1];
                    if(x == rows - 1 && y == cols - 1) {
                        path++;
                    }
                    if(x < rows && y < cols && obstacleGrid[x][y] == 0 ) {
                        stack.add(new Coordinate(x, y));
                        obstacleGrid[x][y] = 1;
                    }
                }
            }
        }

        return path;
    }
    static class Coordinate {
        int x;
        int y;
        Coordinate(int _x ,int _y) {
            x = _x;
            y = _y;
        }
    }
    public static void main(String[] args) {
        int[][] input = new int[][] {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        int x = uniquePathsWithObstacles(input);
        System.out.print(x);
    }
 }
