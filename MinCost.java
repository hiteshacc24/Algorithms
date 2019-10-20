package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinCost {
    int n;
    int[] parent;

    boolean isConnected(int x, int y) {
        if(find(x) == find(y)) {
            return true;
        }
        return false;
    }
    int find(int i) {
        if(parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
    void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if(px != py) {
            parent[px] = py;
            n--;
        }
    }
    public int minCosttoConnectAllNodes(int N, int edges[][], int newEdges[][]) {
        n = N;
        parent = new int[N + 1];
        for(int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        for(int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        Arrays.sort(newEdges, (a, b) -> (a[2] - b[2]));
        int cost = 0;
        for(int[] newEdge : newEdges) {
            if(!isConnected(newEdge[0], newEdge[1])) {
                cost += newEdge[2];
                union(newEdge[0], newEdge[1]);
            }
        }
        return n == 1 ? cost : -1;

    }
    public static void main(String[] args) {
        MinCost main = new MinCost();
        int tc1=main.minCosttoConnectAllNodes(6, new int[][]{{1, 4}, {4, 5}, {2, 3}}, new int[][]{{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}});
        if(tc1==7) {
            System.out.println("All Test Case Pases!");
        } else {
            System.out.println("There are test failures!");
        }
    }
}
