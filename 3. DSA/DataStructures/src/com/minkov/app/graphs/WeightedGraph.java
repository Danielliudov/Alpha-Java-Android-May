package com.minkov.app.graphs;

import java.util.*;

public class WeightedGraph<TVertex> {
    Map<TVertex, List<Vertex<TVertex>>> vertices;

    public WeightedGraph() {
        this.vertices = new HashMap<>();
    }

    public void addEdge(TVertex x, TVertex y, Integer weight) {
        addDirectedEdge(x, y, weight);
        addDirectedEdge(y, x, weight);
    }

    private void addDirectedEdge(TVertex from, TVertex to, Integer weight) {
        if (!vertices.containsKey(from)) {
            vertices.put(from, new ArrayList<>());
        }

        vertices.get(from)
            .add(new Vertex<>(to, weight));
    }

    public Map<TVertex, Integer> dijkstra(TVertex vertex) {
        Set<TVertex> used = new HashSet<>();

        Map<TVertex, Integer> distances = new HashMap<>();

        distances.put(vertex, 0);
        PriorityQueue<Vertex<TVertex>> queue = new PriorityQueue<>();

        queue.add(new Vertex<>(vertex, 0));

        // repeat
        while (!queue.isEmpty()) {
            // select best
            Vertex<TVertex> best = queue.poll();
            if (used.contains(best.getName())) {
                continue;
            }

            used.add(best.getName());

            // for each unused next of best:
            for (Vertex<TVertex> next : vertices.get(best.getName())) {
                if (used.contains(next.getName())) {
                    continue;
                }

                // update distances
                int newDistanceToNext =
                    distances.get(best.getName()) + next.getWeight();

                if (!distances.containsKey(next.getName())) {
                    distances.put(next.getName(), newDistanceToNext);
                    queue.offer(new Vertex<>(next.getName(), newDistanceToNext));
                } else {
                    int currentDistanceToNext =
                        distances.get(next.getName());

                    if (newDistanceToNext < currentDistanceToNext) {
                        distances.put(next.getName(), newDistanceToNext);
                        queue.offer(new Vertex<>(next.getName(), newDistanceToNext));
                    }
                }
            }
        }

        return distances;
    }

    public List<Edge<TVertex>> getMinimalSpanningTreeWithPrim() {
        TVertex startVertex = (TVertex) vertices.keySet().toArray()[0];

        // create sorted collection edges
        PriorityQueue<Edge<TVertex>> edgesHeap = new PriorityQueue<>(
            Comparator.comparingInt(Edge::getWeight)
        );
        List<Edge<TVertex>> tree = new ArrayList<>();

        Set<TVertex> used = new HashSet<>();

        edgesHeap.offer(
            new Edge<>(null, startVertex, 0));

        // while edges is not empty:
        while (!edgesHeap.isEmpty()) {
            Edge<TVertex> current = edgesHeap.poll();

            TVertex vertex = current.getV2();
            if (used.contains(vertex)) {
                continue;
            }

            used.add(vertex);

            tree.add(current);

            for (Vertex<TVertex> nextVertex : vertices.get(vertex)) {
                if (used.contains(nextVertex.getName())) {
                    continue;
                }

                edgesHeap.offer(
                    new Edge<>(vertex, nextVertex.getName(), nextVertex.getWeight())
                );
            }
        }

        return tree;
    }


    public class Edge<TVertex> {
        private TVertex v1;
        private TVertex v2;
        private int weight;

        public Edge(TVertex v1, TVertex v2, int weight) {
            setV1(v1);
            setV2(v2);
            setWeight(weight);
        }

        public TVertex getV1() {
            return v1;
        }

        public void setV1(TVertex v1) {
            this.v1 = v1;
        }

        public TVertex getV2() {
            return v2;
        }

        public void setV2(TVertex v2) {
            this.v2 = v2;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return String.format("(%s, %s, %d)",
                getV1(), getV2(), getWeight());
        }
    }

    class Vertex<TVertex> implements Comparable<Vertex<TVertex>> {
        private TVertex name;
        private Integer weight;

        public Vertex(TVertex name, Integer weight) {
            setName(name);
            setWeight(weight);
        }

        public TVertex getName() {
            return name;
        }

        public void setName(TVertex name) {
            this.name = name;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex<TVertex> other) {
//            if (getWeight() == other.weight) {
//                // compare name
//            }

            return getWeight() - other.getWeight();
        }
    }
}
