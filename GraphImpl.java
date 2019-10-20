package com.company;

import java.util.LinkedList;
import java.util.Vector;

public class GraphImpl {

    static class GraphNode {
        int V;
        int data;
        LinkedList[] adjList;
        GraphNode(int V) {
            this.V = V;
            adjList = new LinkedList[V];
            for(LinkedList adj : adjList) {
                adj = new LinkedList<>();
            }
        }
        void addEdge(int src, int dest) {
            adjList[src].add(dest);
        }
        void dfs() {
            Vector<Boolean> visited = new Vector<>();
            for(Boolean v : visited) {
                visited.add(false);
            }
            for(int i = 0; i < V; i++) {
                if(!visited.get(i)) {
                    dfsutil(i, visited);
                }
            }

        }
        void dfsutil(int N, Vector<Boolean> visited) {

        }
    }


    public static void main(String[] args) {
        GraphImpl g = new GraphImpl();
        GraphNode graph = new GraphNode(5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3 ,4);
        graph.addEdge(4, 5);
        graph.addEdge(2, 4);
        graph.addEdge(5, 1);

    }
}
