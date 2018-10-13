package com.minkov.app;

import com.minkov.app.graphs.WeightedGraph;

public class Solution {
    public static void main(String[] args) {
//        Graph<Integer> graph = new GraphImpl<>();
//        graph.addEdge(3, 4);
//        graph.addEdge(1, 5);
//        graph.addEdge(2, 3);
//        graph.addEdge(1, 2);
//        graph.addEdge(1, 4);
//
////        graph.dfs(2);
////        graph.dfs();
//
////        System.out.println(graph.countConnectedComponents());
////        graph.bfs(1);
////        graph.dfs(2, System.out::println);
//        graph.bfs(2, System.out::println);

        WeightedGraph<Integer> graph = new WeightedGraph<>();

        graph.addEdge(0, 2, 1);
        graph.addEdge(5, 3, 4);
        graph.addEdge(7, 6, 5);
        graph.addEdge(3, 0, 4);
        graph.addEdge(2, 4, 1);
        graph.addEdge(4, 1, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(5, 6, 4);
        graph.addEdge(6, 4, 7);
        graph.addEdge(0, 1, 3);
        graph.addEdge(1, 5, 1);
        graph.addEdge(5, 4, 2);
        graph.addEdge(0, 4, 2);
        graph.addEdge(7, 4, 2);


        System.out.println(graph.dijkstra(5));
        var result = graph.getMinimalSpanningTreeWithPrim();
        System.out.println(result.size());

        result.forEach(System.out::println);
    }
}