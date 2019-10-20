package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class MinCostRepair {
    int n;
    int[] parent;
    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if(px != py) {
            parent[py] = px;
            n--;
        }
    }
    public boolean isConnected(int x, int y) {
        int px = find(x);
        int py = find(y);
        return px == py;
    }
    public int minCostToRepairEdges(int N, int[][] edges,int[][] edgesToRepair) {
        n = N;
        parent = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        Set<String> set = new HashSet<>();
        for(int[] edge : edgesToRepair) {
            StringBuilder sb = new StringBuilder();
            sb.append(edge[0] + "#" + edge[1]);
            set.add(sb.toString());
        }
        for(int edge[] : edges) {
            StringBuilder sb = new StringBuilder();
            sb.append(edge[0] + "#" + edge[1]);
            if(!set.contains(sb.toString())) {
                union(edge[0], edge[1]);
            }
        }
        Arrays.sort(edgesToRepair, (a, b)-> (a[2] - b[2]));
        int cost = 0;
        for(int[] repairEdge: edgesToRepair) {
            if(!isConnected(repairEdge[0], repairEdge[1])) {
                cost += repairEdge[2];
                union(repairEdge[0], repairEdge[1]);
            }
        }
        return n == 1 ? cost : -1;

    }
    public static void main(String[] args) {

        MinCostRepair main = new MinCostRepair();
        int tc1 = main.minCostToRepairEdges(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}, new int[][]{{1, 2, 12}, {3, 4, 30}, {1, 5, 8}});
        int tc2 = main.minCostToRepairEdges(6, new int[][]{{1, 2}, {2, 3}, {4, 5}, {3, 5}, {1, 6}, {2, 4}}, new int[][]{{1, 6, 410}, {2, 4, 800}});
        int tc3 = main.minCostToRepairEdges(6, new int[][]{{1, 2}, {2, 3}, {4, 5}, {5, 6}, {1, 5}, {2, 4}, {3, 4}}, new int[][]{{1, 5, 110}, {2, 4, 84}, {3, 4, 79}});
        if(tc1==20 && tc2==410 && tc3==79) {
            System.out.println("All Test Cases Pases!");
        } else {
            System.out.println("There are test failures!");
        }
    }
}
