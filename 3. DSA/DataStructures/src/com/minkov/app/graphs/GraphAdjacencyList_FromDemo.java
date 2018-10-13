package com.minkov.app.graphs;

import java.util.*;

public class GraphAdjacencyList_FromDemo {
    List<List<Integer>> vertices;

    public GraphAdjacencyList_FromDemo(int n) {
        // N - number of Vertices
        // M - number of Edges
        vertices = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            vertices.add(new ArrayList<>());
        }
    }

    public void addEdge(int x, int y) {
//        vertices.get(x)
//            .add(y);
//
//        vertices.get(y)
//            .add(x);
        addDirectedEdge(x, y);
        addDirectedEdge(y, x);

        // neightbours of X
        // vertices.get(x)

        // neightbours of Y
        // vertices.get(y)
    }


    public void addDirectedEdge(int from, int to) {
        vertices.get(from)
            .add(to);
    }


    // API
    public void dfs(int vertex) {
        Set<Integer> visited = new HashSet<>();
        visited.add(vertex);
        dfs(vertex, visited);
    }

    // algorithm
    private void dfs(int vertex, Set<Integer> visited) {
        System.out.println(vertex);

        for (int nextVertex : vertices.get(vertex)) {
            if (visited.contains(nextVertex)) {
                continue;
            }

            visited.add(nextVertex);

            dfs(nextVertex, visited);
        }
    }

    public void dfs() {
        Set<Integer> used = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        for (int vertex = 1; vertex < vertices.size(); vertex++) {
            used.clear();
            path.clear();
//            path.add(vertex);
            used.add(vertex);

            allDfs(vertex, used, path);
        }
    }

    private void allDfs(int vertex, Set<Integer> used, List<Integer> path) {
        path.add(vertex);
        System.out.println(path);

        for (int nextVertex : vertices.get(vertex)) {
            if (used.contains(nextVertex)) {
                continue;
            }

            used.add(nextVertex);
//            path.add(nextVertex);

            allDfs(nextVertex, used, path);

            used.remove(nextVertex);
//            path.remove(path.size() - 1);
        }

        path.remove(path.size() - 1);
    }

    public int countConnectedComponents() {
        Set<Integer> used = new HashSet<>();
        int componentsCount = 0;
        for (int vertex = 1; vertex < vertices.size(); vertex++) {
            if (used.contains(vertex)) {
                continue;
            }

            ++componentsCount;
            dfs(vertex, used);
        }

        return componentsCount;
    }

    public void bfs(int vertex) {
        Queue<Integer> queue = new ArrayDeque<>();
//        Queue<Integer> lengths = new ArrayDeque<>();
        Set<Integer> used = new HashSet<>();

        int[] distances = new int[vertices.size()];

        queue.offer(vertex);
//        lengths.offer(0);

        used.add(vertex);
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
//            int currentLength = lengths.poll();
            int currentLength = distances[currentVertex];
            System.out.println(currentVertex + " with " + currentLength);

            vertices.get(currentVertex)
                .stream()
                .filter(nextVertex -> !used.contains(nextVertex))
                .forEach(nextVertex -> {
                    used.add(nextVertex);
                    queue.offer(nextVertex);
                    distances[nextVertex] = currentLength + 1;
//                    lengths.offer(currentLength + 1);
                });
        }

        System.out.println(Arrays.toString(distances));

        int maxPathLength = Arrays.stream(distances)
            .max()
            .getAsInt();
    }
}
