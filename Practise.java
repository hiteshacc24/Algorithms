package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Practise {
    public static int treasureIsland2(char[][] island) {
        if(island.length == 0 || island == null) return 0;
        boolean[][] visited = new boolean[island.length][island[0].length];
        int[][] dirs = new int[][] {
                {1,0},
                {0,1},
                {-1,0},
                {0,-1}
        };
        Queue<Coordinates> q = new LinkedList<>();
        q.add(new Coordinates(0,0));
        visited[0][0] = true;
        int steps = 0;
        while(!q.isEmpty()) {
            int current_size = q.size();
            for(int i = 0; i < current_size; i++) {
                Coordinates c = q.poll();
                int x = c.x;
                int y = c.y;
                if(island[x][y] == 'X') {
                    return steps;
                }
                for(int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if(newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length && island[newX][newY] != 'D'
                            && !visited[newX][newY]) {
                        q.add(new Coordinates(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    public static void main(String[] args) {
        char[][] island = new char[][]{
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}
        };
        System.out.print(treasureIsland2(island));
    }
    static class Coordinates {
        int x;
        int y;

        Coordinates(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }
}
