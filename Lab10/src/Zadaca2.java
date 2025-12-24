import java.util.*;

public class Zadaca2 {
    static int funkcijaBFS(AdjacencyListGraph<String> graph, String start, int br) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();
        visited.add(start);
        queue.add(start);
        level.add(0);
        int lvl=0;
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            lvl = level.poll();
            for (String neighbor : graph.getNeighbors(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    level.add(lvl+1);
                }
            }
        }
        return lvl;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        AdjacencyListGraph<String> graph = new AdjacencyListGraph<>();
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String vertex = sc.next();
            list.add(vertex);
            graph.addVertex(vertex);
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String mesto1 = sc.next();
            String mesto2 = sc.next();
            graph.addEdge(mesto1, mesto2);
        }
        if (m<n-1){
            System.out.println(-1);
            return;
        }
        int min = list.size()+1;
        String resenie="";
        for (String vertex : list) {
            int level = funkcijaBFS(graph, vertex, list.size());
            if(level==min && vertex.compareTo(resenie)<0){
                resenie=vertex;
            }
            if(level<min){
                min=level;
                resenie=vertex;
            }
        }
        if(resenie.equals(""))
            System.out.println("-1");
        else
            System.out.println(resenie);
    }
}
