package com.minkov.app.graphs;

import java.util.List;

public class GraphEdges {
    List<Edge> edges;

    void addEdge(int x, int y) {
        this.edges.add(
            new Edge(x, y)
        );

        this.edges.add(
            new Edge(y, x)
        );
    }

    void getNeighbours(int x) {

    }


    private class Edge {
        public int from;
        public int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
}
