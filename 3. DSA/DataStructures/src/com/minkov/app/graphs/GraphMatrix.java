package com.minkov.app.graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphMatrix {
    private final boolean[][] matrix;

    public GraphMatrix(int n) {

        matrix = new boolean[n + 1][n + 1];
    }

    public void addEdge(int x, int y) {
        matrix[x][y] = true;
        matrix[y][x] = true;
    }

    public void getNeighbours(int x) {
        List<Integer> neighbours = new ArrayList<>();
        for (int v = 0; v < matrix.length; v++) {
            if (matrix[x][v]) {
                neighbours.add(v);
            }
        }
    }
}
