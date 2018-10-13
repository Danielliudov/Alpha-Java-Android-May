package com.minkov.app.graphs;

import com.minkov.app.base.Graph;

import java.util.*;
import java.util.function.Consumer;

public class GraphImpl<T> implements Graph<T> {

    private Map<T, Set<T>> vertices;

    public GraphImpl() {
        vertices = new HashMap<>();
    }

    @Override
    public void addEdge(T x, T y) {
        addDirectedEdge(x, y);
        addDirectedEdge(y, x);
    }

    @Override
    public void addDirectedEdge(T from, T to) {
        if (!vertices.containsKey(from)) {
            vertices.put(from, new HashSet<>());
        }

        vertices.get(from)
            .add(to);
    }

    @Override
    public void dfs(T vertex, Consumer<T> action) {
        Set<T> used = new HashSet<>();
        used.add(vertex);
        dfs(vertex, used, action);
    }

    @Override
    public void bfs(T vertex, Consumer<BfsPair<T>> action) {
        Queue<BfsPair<T>> queue = new ArrayDeque<>();
        Set<T> used = new HashSet<>();
        queue.offer(new BfsPair<>(vertex, 0));
        used.add(vertex);

        while (!queue.isEmpty()) {
            BfsPair<T> current = queue.poll();
            action.accept(current);

            if (!vertices.containsKey(current.getVertex())) {
                continue;
            }

            vertices.get(current.getVertex())
                .stream()
                .filter(nextVertex -> !used.contains(nextVertex))
                .forEach(nextVertex -> {
                    used.add(nextVertex);
                    queue.offer(new BfsPair<>(nextVertex, current.getLevel() + 1));
                });
        }
    }

    private void dfs(T vertex, Set<T> used, Consumer<T> action) {
        action.accept(vertex);
        if (!vertices.containsKey(vertex)) {
            return;
        }

        vertices.get(vertex)
            .stream()
            .filter(nextVertex -> !used.contains(nextVertex))
            .forEach(nextVertex -> {
                used.add(nextVertex);
                dfs(nextVertex, used, action);
            });
    }
}
