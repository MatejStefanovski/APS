import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, ArrayList<String>> map = new HashMap<>(2 * n);
        for (int i = 0; i < n; i++) {
            String clen = sc.next();
            String oblast = sc.next();
            if (!map.containsKey(clen)) {
                map.put(clen, new ArrayList<>());
            }
            if (!map.get(clen).contains(oblast)) {
                map.get(clen).add(oblast);
            }
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String clen = sc.next();
            String oblast1 = sc.next();
            String oblast2 = sc.next();
            if (map.containsKey(clen) && map.get(clen).contains(oblast1) && map.get(clen).contains(oblast2)) {
                System.out.println("GRANTED");
            }
            else {
                System.out.println("DENIED");
            }
        }
    }
}
