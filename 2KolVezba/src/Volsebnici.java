import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Volsebnici {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for (int i=0; i<n; i++){
            String key = sc.next();
            String value = sc.next();
            if (!map.containsKey(key)){
                map.put(key, new HashSet<>());
            }
            map.get(key).add(value);
        }
        int m = sc.nextInt();
        for (int i=0; i<m; i++){
            String key = sc.next();
            String value1 = sc.next();
            String value2 = sc.next();
            String value3 = sc.next();
            if (map.containsKey(key) && map.get(key).contains(value1) && map.get(key).contains(value2) && map.get(key).contains(value3)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
