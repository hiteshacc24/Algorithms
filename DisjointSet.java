package com.company;


class DisjointSet {

    int V, E;
    Edge edge[]; //collection of all Edges
    class Edge {
        int src, dest;
    };
    DisjointSet(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for(int i = 0; i <  E; i++) {
            edge[i] = new Edge();
        }
    }
    int find(int[] parent, int i) {
        if(parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
    }
    // A utility function to do union of two subsets
    void Union(int[] parent, int x, int y) {
        int xset = find(parent , x);
        int yset = find(parent , y);
        parent[xset] = yset;
    }
    int isCycle(DisjointSet graph) {
        //Allocating memory for creating v subsets
        int[] parent = new int[graph.V];

        //Initialize all subsets as single elements sets
        for(int i = 0; i < graph.V; i++) {
            parent[i] = -1;
        }
        // Iterate through all edges of graph, find subset of both
        // vertices of every edge, if both subsets are same, then
        // there is cycle in graph.
        for(int i = 0; i < graph.E; i++) {
            int x = graph.find(parent, graph.edge[i].src);
            int y = graph.find(parent, graph.edge[i].dest);
            if(x == y) return 1;
            graph.Union(parent, x , y);
        }
        return 0;


    }
    public static void main(String[] args) {
        int V = 3;
        int E = 3;
        DisjointSet graph = new DisjointSet(V, E);
        //adding edge between 0 and 1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        //adding edge between 1 and 2
        graph.edge[1].src = 1;
        graph.edge[1].src = 2;

        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;
        if (graph.isCycle(graph)==1)
            System.out.println( "graph contains cycle" );
        else
            System.out.println( "graph doesn't contain cycle" );
    }
}
