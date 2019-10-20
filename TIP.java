package com.company;

import java.util.LinkedList;
import java.util.Queue;

class TIP {
    public static int treasureIsland(char[][] island) {

        int rows = island.length;
        int cols = island[0].length;

        int[][] dirs = new int[][] {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };

        Queue<Coordinate> q = new LinkedList<>();
        q.add(new Coordinate(0, 0));
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;
        int steps = 0;
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                Coordinate c = q.poll();
                int x = c.x;
                int y = c.y;
                if(island[x][y] == 'X') return steps;
                for(int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if(newX >= 0 && newX < rows && newY >= 0 && newY < cols && island[newX][newY] != 'D' && !visited[newX][newY]) {
                        q.add(new Coordinate(newX, newY));
                        visited[newX][newY] = true;
                    }
                }

            }
            steps++;
        }
        return steps;
    }

    static class Coordinate {
        int x;
        int y;
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        char[][] island = new char[][]{
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}
        };
        int result = TIP.treasureIsland(island);
        System.out.println(String.format("%s (expect 5)", result));
    }
}
