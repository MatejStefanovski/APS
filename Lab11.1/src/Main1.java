import java.util.*;

public class Main1 {
    static boolean hasCycle(AdjacencyListGraph<String> graph, String node, Set<String> visited, Set<String> recStack) {
        if (recStack.contains(node)) {
            return true;
        }
        if (visited.contains(node)) {
            return false;
        }
        visited.add(node);
        recStack.add(node);
        for (String neighbor : graph.getNeighbors(node)) {
            if (hasCycle(graph, neighbor, visited, recStack))
            {
                return true;
            }
        }
        recStack.remove(node);
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> modules = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            modules.add(sc.nextLine().trim());
        }
        int m = Integer.parseInt(sc.nextLine());
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        for (String mod : modules) {
            graph.addVertex(mod);
        }
        for (int i = 0; i < m; i++) {
            String[] parts = sc.nextLine().split(" ");
            String before = parts[0];
            String after = parts[1];
            graph.addEdge(before, after, 0);
        }
        Set<String> visited = new HashSet<>();
        Set<String> recStack = new HashSet<>();
        for (String module : modules) {
            if (!visited.contains(module)) {
                if (hasCycle(graph, module, visited, recStack)) {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }
}
