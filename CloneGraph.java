package com.company;
import java.util.*;
public class CloneGraph {
    class Node {
        int val;
        List<Node> neighbors;
        public Node() {}
        public Node(int x, List<Node> n) {
            val = x;
            neighbors = n;
        }
    }

    Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        return dfs(node);
    }
    public Node dfs(Node node) {
        if(visited.containsKey(node)) return visited.get(node);
        Node newNode = new Node(node.val, new ArrayList<>());
        visited.put(node, newNode);
        for(Node nb : node.neighbors) {
            Node cp = dfs(nb);
            newNode.neighbors.add(cp);
        }
        return newNode;
    }
}
