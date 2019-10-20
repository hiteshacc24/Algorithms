package com.company;

import java.util.LinkedList;
import java.util.Queue;

class AmazonTreasureIsland {
    public static int treasureIsland(char[][] island) {
        int[][] dirs = new int[][]{
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1}
        };
        int steps = 0;
        if (island == null || island.length == 0) return 0;
        boolean[][] visited = new boolean[island.length][island[0].length];
        Queue<Coordinate> q = new LinkedList<>();
        for(int i = 0; i < island.length; i++) {
            for(int j = 0; j < island[0].length; j++) {
                if(island[i][j] == 'S') {
                    q.add(new Coordinate(i,j));
                    visited[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            int current_size = q.size();
            for (int i = 0; i < current_size; i++) {
                Coordinate c = q.poll();
                int x = c.x;
                int y = c.y;
                if (island[x][y] == 'X') return steps;
                for(int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length &&
                            island[newX][newY] != 'D' && !visited[newX][newY]) {
                        q.add(new Coordinate(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
            steps++;
        }
        return 0;
    }

    public static void main(String[] args) {
        char[][] island = new char[][]{
                {'S', 'O', 'O', 'S', 'S'},
                {'D', 'O', 'D', 'O', 'D'},
                {'O', 'O', 'O', 'O', 'X'},
                {'X', 'D', 'D', 'O', 'O'},
                {'X', 'D', 'D', 'D', 'O'}};
        System.out.print(treasureIsland(island));
    }

    static class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}