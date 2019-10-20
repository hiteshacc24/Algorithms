package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIslandP {

    public static int TreasureIsland(char[][] island) {
        if(island == null || island.length == 0) return -1;
        Queue<Coordinate> q = new LinkedList<>();
        int[][] dirs = {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };
        int steps = 0;
        boolean[][] visited = new boolean[island.length][island[0].length];
        q.add(new Coordinate(0, 0));
        visited[0][0] = true;
        while(!q.isEmpty()) {
            int s = q.size();
            for(int i = 0; i < s; i++) {
                Coordinate c = q.poll();
                int x = c.x;
                int y = c.y;
                if(island[x][y] == 'X') return steps;

                for(int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if(newX >= 0 && newX < island.length && newY >= 0 &&
                            newY < island[0].length && island[newX][newY] != 'D' && !visited[newX][newY]) {
                        q.add(new Coordinate(newX, newY));
                        visited[newX][newY] = true;
                    }
                }

            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        char[][] island = new char[][]{
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}
        };
        int result = TreasureIslandP.TreasureIsland(island);
        System.out.println(String.format("%s (expect 5)", result));
    }
    static class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}