import java.util.*;

class AdjacencyListGraph<T> {

    private Map<T, Map<T, Integer>> adjacencyList;

    public AdjacencyListGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(T vertex) {
        adjacencyList.putIfAbsent(vertex, new HashMap<>());
    }

    public void addEdge(T source, T destination, int weight) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).put(destination, weight);
        adjacencyList.get(destination).put(source, weight);
    }

    public Map<T, Integer> getNeighbors(T vertex) {
        return adjacencyList.get(vertex);
    }

    private List<Edge<T>> getAllEdges() {
        List<Edge<T>> edges = new ArrayList<>();
        Set<String> seen = new HashSet<>();

        for (T u : adjacencyList.keySet()) {
            for (Map.Entry<T, Integer> v : adjacencyList.get(u).entrySet()) {
                String key1 = u.toString() + "-" + v.getKey().toString();
                String key2 = v.getKey().toString() + "-" + u.toString();

                if (!seen.contains(key1) && !seen.contains(key2)) {
                    edges.add(new Edge<>(u, v.getKey(), v.getValue()));
                    seen.add(key1);
                    seen.add(key2);
                }
            }
        }
        return edges;
    }

    private void union(T u, T v, Map<T, T> parent) {
        T rootU = find(u, parent);
        T rootV = find(v, parent);

        for (T key : parent.keySet()) {
            if (parent.get(key).equals(rootV)) {
                parent.put(key, rootU);
            }
        }
    }

    private T find(T x, Map<T, T> parent) {
        return parent.get(x);
    }

    public List<Edge<T>> kruskal() {
        List<Edge<T>> mst = new ArrayList<>();
        List<Edge<T>> edges = getAllEdges();

        edges.sort(Comparator.comparingInt(Edge::getWeight));

        Map<T, T> parent = new HashMap<>();
        for (T v : adjacencyList.keySet()) {
            parent.put(v, v);
        }

        for (Edge<T> e : edges) {
            T u = e.getFrom();
            T v = e.getTo();

            if (!find(u, parent).equals(find(v, parent))) {
                mst.add(e);
                union(u, v, parent);
            }
        }

        return mst;
    }
}
