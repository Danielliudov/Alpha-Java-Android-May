package com.minkov.app.base;

import java.util.function.Consumer;

public interface Graph<T> {
    void addEdge(T x, T y);

    void addDirectedEdge(T from, T to);

    void dfs(T vertex, Consumer<T> action);

    void bfs(T vertex, Consumer<BfsPair<T>> action);


    public class BfsPair<T> {
        private T vertex;
        private int level;

        public BfsPair(T vertex, int level) {
            setVertex(vertex);
            setLevel(level);
        }

        public T getVertex() {
            return vertex;
        }

        public void setVertex(T vertex) {
            this.vertex = vertex;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        @Override
        public String toString() {
            return String.format(
                "-------%nVertex: %s%nLevel: %d%n-------",
                getVertex(), getLevel()
            );
        }
    }
}
