import java.util.*;

public class ViktorNikolov {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            String name = sc.next();
            String keyId = sc.next();
            if (command.equals("LOST")) {
                map.put(keyId, name);
            }
            else if (command.equals("FOUND")) {
                map.remove(keyId);
            }
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String id = sc.next();
            if (map.containsKey(id)) {
                System.out.println("FOUND " + map.get(id));
            }
            else {
                System.out.println("NOT FOUND");
            }
        }
    }
}
