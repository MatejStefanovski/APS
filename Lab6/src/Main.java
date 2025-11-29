import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String ip = sc.nextLine();
            String[] parts = ip.split("\\.");
            String key = parts[0] + "." + parts[1] + "." + parts[2];
            if (map.get(key) == null) {
                map.put(key, 1);
            }
            else {
                map.put(key, map.get(key) + 1);
            }
        }
        int M = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < M; i++) {
            String baranje = sc.nextLine();
            String[] parts = baranje.split("\\.");
            String key = parts[0] + "." + parts[1] + "." + parts[2];
            if (map.get(key) == null) {
                System.out.println(0);
            }
            else{
                System.out.println(map.get(key));
            }
        }
    }
}
