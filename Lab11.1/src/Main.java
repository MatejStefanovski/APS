import java.util.*;

public class Main {
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