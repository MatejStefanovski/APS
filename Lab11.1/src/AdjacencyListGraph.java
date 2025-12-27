import java.util.*;
import java.util.Map.Entry;

public class AdjacencyListGraph<T> {
    private Map<T, Set<T>> adjacencyList;
    private Map<T, Map<T, Integer>> weights;

    public AdjacencyListGraph() {
        this.adjacencyList = new HashMap<>();
        this.weights = new HashMap<>();
    }

    public void addVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new HashSet<>());
            weights.put(vertex, new HashMap<>());
        }
    }

    public void addEdge(T source, T destination, int weight) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);   // само ова
        weights.get(source).put(destination, weight); // само source -> destination
    }


    public Set<T> getNeighbors(T vertex) {
        return adjacencyList.getOrDefault(vertex, new HashSet<>());
    }

    public int shortestPath(T startVertex, T endVertex) {
        if (startVertex.equals(endVertex)) return 0;
        Map<T, Integer> dist = new HashMap<>();
        PriorityQueue<T> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));
        dist.put(startVertex, 0);
        pq.add(startVertex);

        while (!pq.isEmpty()) {
            T curr = pq.poll();
            if (curr.equals(endVertex)) return dist.get(curr);

            for (T neighbor : getNeighbors(curr)) {
                int w = weights.get(curr).get(neighbor);
                int newDist = dist.get(curr) + w;
                if (!dist.containsKey(neighbor) || newDist < dist.get(neighbor)) {
                    dist.put(neighbor, newDist);
                    pq.add(neighbor);
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        List<String[]> pairs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            pairs.add(sc.nextLine().split(" "));
        }

        int M = Integer.parseInt(sc.nextLine());
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        for (int i = 0; i < M; i++) {
            String[] parts = sc.nextLine().split(" ");
            String from = parts[0];
            String to = parts[1];
            int weight = Integer.parseInt(parts[2]);
            graph.addEdge(from, to, weight);
        }

        int totalCost = 0;
        for (String[] p : pairs) {
            totalCost += graph.shortestPath(p[0], p[1]);
        }

        System.out.println(totalCost);
    }
}
