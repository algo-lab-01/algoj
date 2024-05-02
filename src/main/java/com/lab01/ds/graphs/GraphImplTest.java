package com.lab01.ds.graphs;

/**
 * GraphMain
 */
public class GraphImplTest {
    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.addEdge("Hemant", "Nikhil", true);
        graph.addEdge("Hemant", "Ankur", true);
        graph.addEdge("Hemant", "Anand", true);
        graph.addEdge("Hemant", "Ankit", true);
        System.out.println(graph);
    }
}


