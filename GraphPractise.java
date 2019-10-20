package com.company;
import java.util.*;
public class GraphPractise {
    static class GraphNode {
        int V;
        LinkedList<Integer>[] adj;

        public GraphNode(int V) {
            this.V = V;
            adj= new LinkedList[V];
            for(int i = 0; i < V; i++) {
                adj[i] = new LinkedList<>();
            }
        }
        public void addEdge(int v, int w) {
            adj[v].add(w);
        }
        void bfs(int s) {
            boolean[] visited = new boolean[V];
            for (int i = 0; i < V; i++) {
                visited[i] = false;
            }
            Queue<Integer> q = new LinkedList<>();
            q.add(s);
            while(!q.isEmpty()) {
               s = q.poll();
                System.out.print(s + " ");
                visited[s] = true;
                Iterator<Integer> i = adj[s].iterator();
                while(i.hasNext()) {
                    int v = i.next();
                    if(!visited[v]) {
                        visited[v] = true;
                        q.add(v);
                    }
                }
            }

        }
        void dfs() {
            Vector<Boolean> visited = new Vector<>(V);
            for(Boolean b : visited) {
                visited.add(false);
            }
            for(int i = 0; i < V; i++) {
                if(!visited.get(i)) {
                    DFSutil(i, visited);
                }
            }

        }
        void DFSutil(int s, Vector<Boolean> visited) {
            Stack<Integer> stack = new Stack<>();
            stack.push(s);
            while(!stack.isEmpty()) {
                s = stack.pop();

                if(!visited.get(s)) {
                    System.out.print(s);
                    visited.add(s, true);
                }
                Iterator<Integer> i = adj[s].iterator();
                while(i.hasNext()) {
                   int v = i.next();
                   if(!visited.get(v)) {
                       stack.push(v);
                   }
                }

             }

        }
    }


    public static void main(String[] args) {
        GraphNode g = new GraphNode(5);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
    }
}
