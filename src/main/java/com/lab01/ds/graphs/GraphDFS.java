package com.lab01.ds.graphs;

import java.util.*;

public class GraphDFS {

    public static void main(String[] args) {
        Graph<String> graph = createGraph();
        Set<String> seen = dfs(graph, "Bob");
        seen.forEach(System.out::println);

    }

    public static Set<String> dfs(Graph<String> g, String root){
        Stack<String> stack = new Stack<>();
        Set<String> seen = new LinkedHashSet<>();
        //add all vertex to set 
        stack.push(root);
        while (!stack.isEmpty()) {
            String v = stack.pop();
            if(!seen.contains(v)){
                seen.add(v);
                System.out.println("visited node :"+v);
                for(String u: g.getVertices(v)){
                    stack.push(u);
                }
            }
        }
        return seen;
       
    }

    public static Graph<String> createGraph() {
        Graph<String> graph = new Graph<>();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice", false);
        graph.addEdge("Bob", "Rob", false);
        graph.addEdge("Alice", "Mark", false);
        graph.addEdge("Rob", "Mark", false);
        graph.addEdge("Alice", "Maria", false);
        graph.addEdge("Rob", "Maria", false);
        return graph;
    }
}