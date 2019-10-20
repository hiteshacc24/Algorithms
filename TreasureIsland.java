package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland {
//    public static int treasureIsland(char[][] island) {
//        if (island == null || island.length == 0) return 0;
//
//        int steps = 0;
//        Queue<Coordinate> queue = new LinkedList<>();
//        queue.add(new Coordinate(0, 0));
//        boolean[][] visited = new boolean[island.length][island[0].length];
//        visited[0][0] = true;
//        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//
//        // bfs
//        while (!queue.isEmpty()) {
//
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Coordinate coordinate = queue.poll();
//                int x = coordinate.x;
//                int y = coordinate.y;
//                if (island[x][y] == 'X') return steps;
//
//                for (int[] dir : dirs) {
//                    int newX = x + dir[0];
//                    int newY = y + dir[1];
//
//                    if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length &&
//                            island[newX][newY] != 'D' && !visited[newX][newY]) {
//                        queue.add(new Coordinate(newX, newY));
//                        visited[newX][newY] = true;
//                    }
//                }
//            }
//            steps++;
//        }
//
//        return 0;
//
//
//    }
public static int treasureIslandHoGAYA(char[][] island) {

    if(island == null || island.length == 0) return 0;
    int rows = island.length;
    int cols = island[0].length;
    int dirs[][] = new int[][] {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
    boolean[][] visited = new boolean[rows][cols];
    Queue<Coordinate> q = new LinkedList<>();
    q.add(new Coordinate(0, 0));
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

    public static void main(String[] args) {
        char[][] island = new char[][]{
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}
        };
        int result = TreasureIsland.treasureIslandHoGAYA(island);
        System.out.println(String.format("%s (expect 5)", result));
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
