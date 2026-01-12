import java.util.*;
import java.util.Map.Entry;

public class zadacaaaaaa {
    static class AdjacencyListGraph<T> {
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
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String[]> list = new ArrayList<>();
        Map<String, Integer> cost = new HashMap<>();
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        for (int i = 0; i < n; i++) {
            String[] line = sc.nextLine().split(" ");
            cost.put(line[0], Integer.parseInt(line[1]));
        }
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] line = sc.nextLine().split(" ");
            graph.addEdge(line[0], line[1], cost.get(line[1]));
        }
        int totalcost = 0;
        for (String[] pair : list) {
            totalcost += graph.shortestPath(pair[0], pair[1]);
        }
        System.out.println(totalcost);
    }
}
