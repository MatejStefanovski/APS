import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class zadacamapa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String task = sc.next();
            int time = sc.nextInt();
            map.put(task, new  ArrayList<>());
            map.get(task).add(time);
        }
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String task = sc.next();
            String dep = sc.next();
            int depTime = map.get(dep).get(map.get(dep).size() - 1);
            map.get(task).add(depTime + map.get(task).get(0));
        }
        int max=0;
        for (String task : map.keySet()) {
            ArrayList<Integer> list = map.get(task);
            int total = list.get(list.size() - 1);
            if (total > max) {
                max = total;
            }
        }
        System.out.println(max);
    }
}
