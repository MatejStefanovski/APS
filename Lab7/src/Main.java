import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CBHT<String, ArrayList<String>> hashtable = new CBHT<>(2*n);
        for (int i = 0; i < n; i++) {
            String clen = sc.next();
            String oblast = sc.next();
            SLLNode<MapEntry<String, ArrayList<String>>> node = hashtable.search(clen);
            if (node == null) {
                ArrayList<String> list = new ArrayList<>();
                list.add(oblast);
                hashtable.insert(clen, list);
            } else {
                if (!node.element.value.contains(oblast)) {
                    node.element.value.add(oblast);
                }
            }
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String clen = sc.next();
            String oblast1 = sc.next();
            String oblast2 = sc.next();
            SLLNode<MapEntry<String, ArrayList<String>>> node = hashtable.search(clen);
            if (node != null && node.element.value.contains(oblast1) && node.element.value.contains(oblast2)) {
                System.out.println("GRANTED");
            }
            else {
                System.out.println("DENIED");
            }
        }
    }
}
