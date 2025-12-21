import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static AdjacencyListGraph<Integer> graph;
    static int dfs(int current, int br, int suma){
        br+=current;
        if (suma == br){
            return 1;
        }
        if (suma < br){
            return 0;
        }
        int kraj=0;
        ArrayList<Integer> lista = new ArrayList<>(graph.getNeighbors(current));
        for (int i = 0; i < lista.size(); i++) {
            kraj += dfs(lista.get(i), br, suma);
        }
        return kraj;
    }
    static int pat(int start, int suma){
        return dfs(start, 0, suma);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        graph = new AdjacencyListGraph<>();
        for (int i=0; i<m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }
        int v = sc.nextInt();
        int n = sc.nextInt();
        int rezultat = pat(v, n);
        System.out.println(rezultat);
    }
}
