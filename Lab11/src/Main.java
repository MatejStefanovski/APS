import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        List<String> gradovi = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String city = sc.nextLine();
            gradovi.add(city);
            graph.addVertex(city);
        }
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] parts = sc.nextLine().split(" ");
            graph.addEdge(parts[0], parts[1], Integer.parseInt(parts[2]));
        }
        List<Edge<String>> mst = graph.kruskal();
        int totalCost = 0;
        for (Edge<String> e : mst) {
            totalCost += e.getWeight();
        }
        System.out.println(totalCost);
    }
}
