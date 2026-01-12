import java.util.*;

public class Patarini {
    static class AdjacencyListGraph<T> {
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
            //adjacencyList.get(destination).put(source, weight);
        }

        public Map<T, Integer> getNeighbors(T vertex) {
            return adjacencyList.getOrDefault(vertex, new HashMap<>());
        }

        public void DFS(T startVertex) {
            Set<T> visited = new HashSet<>();
            DFSUtil(startVertex, visited);
        }

        private void DFSUtil(T vertex, Set<T> visited) {
            visited.add(vertex);
            System.out.print(vertex + " ");
            for (T neighbor : getNeighbors(vertex).keySet()) {
                if (!visited.contains(neighbor)) {
                    DFSUtil(neighbor, visited);
                }
            }
        }

        public void DFSNonRecursive(T startVertex) {
            Set<T> visited = new HashSet<>();
            Stack<T> stack = new Stack<>() {
                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public T peek() {
                    return null;
                }

                @Override
                public void clear() {

                }

                @Override
                public void push(T x) {

                }

                @Override
                public T pop() {
                    return null;
                }
            };
            stack.push(startVertex);

            while (!stack.isEmpty()) {
                T vertex = stack.pop();
                if (!visited.contains(vertex)) {
                    visited.add(vertex);
                    System.out.print(vertex + " ");
                    for (T neighbor : getNeighbors(vertex).keySet()) {
                        if (!visited.contains(neighbor)) {
                            stack.push(neighbor);
                        }
                    }
                }
            }
        }

        public void printPath(T source, T destination) {
            Set<T> visited = new HashSet<>();
            Stack<T> stack = new Stack<>() {
                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public T peek() {
                    return null;
                }

                @Override
                public void clear() {

                }

                @Override
                public void push(T x) {

                }

                @Override
                public T pop() {
                    return null;
                }
            };
            stack.push(source);
            visited.add(source);

            while (!stack.isEmpty() && !stack.peek().equals(destination)) {
                T vertex = stack.peek();
                boolean found = false;

                for (T neighbor : getNeighbors(vertex).keySet()) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        stack.push(neighbor);
                        found = true;
                        break;
                    }
                }

                if (!found) stack.pop();
            }

            Stack<T> path = new Stack<>() {
                public boolean isEmpty() {
                    return false;
                }

                public T peek() {
                    return null;
                }

                public void clear() {

                }

                public void push(T x) {

                }

                public T pop() {
                    return null;
                }
            };
            while (!stack.isEmpty()) {
                path.push(stack.pop());
            }

            while (!path.isEmpty()) {
                System.out.print(path.pop() + " ");
            }
        }

        public void BFS(T startVertex) {
            Set<T> visited = new HashSet<>();
            Queue<T> queue = new LinkedList<>();
            visited.add(startVertex);
            queue.add(startVertex);

            while (!queue.isEmpty()) {
                T vertex = queue.poll();
                System.out.print(vertex + " ");
                for (T neighbor : getNeighbors(vertex).keySet()) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        public Map<T, Integer> shortestPath(T startVertex) {
            Map<T, Integer> distances = new HashMap<>();
            Set<T> visited = new HashSet<>();
            PriorityQueue<T> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));

            for (T v : adjacencyList.keySet()) distances.put(v, Integer.MAX_VALUE);
            distances.put(startVertex, 0);
            pq.add(startVertex);

            while (!pq.isEmpty()) {
                T current = pq.poll();
                if (visited.contains(current)) continue;
                visited.add(current);

                for (Map.Entry<T, Integer> e : getNeighbors(current).entrySet()) {
                    T neighbor = e.getKey();
                    int newDist = distances.get(current) + e.getValue();
                    if (newDist < distances.get(neighbor)) {
                        distances.put(neighbor, newDist);
                        pq.add(neighbor);
                    }
                }
            }

            return distances;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a =  sc.nextInt();
        int b = sc.nextInt();
        int m = sc.nextInt();
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        for (int i = 1; i <= n; i++) {
            graph.addVertex(i);
        }
        for (int i = 0; i < m; i++) {
            int t1 = sc.nextInt();
            int t2 = sc.nextInt();
            int weight = sc.nextInt();
            graph.addEdge(t1, t2, weight);
        }
        Map<Integer, Integer> distances = graph.shortestPath(a);
        if (distances.get(b) == Integer.MAX_VALUE) {
            System.out.println("No path exists");
        } else {
            System.out.println(distances.get(b));
        }
    }
}
/*10
7 8
13
1 2 387
2 3 831
4 1 820
5 4 204
5 6 304
4 7 381
5 8 238
9 5 214
9 10 126
8 6 709
4 3 3
6 7 732
3 1 488
*/