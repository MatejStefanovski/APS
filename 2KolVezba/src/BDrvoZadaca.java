import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BDrvoZadaca {
    static BNode<Integer> lca(BNode<Integer> node, int a, int b){
        if (node == null){
            return null;
        }
        if (node.info.equals(a) || node.info.equals(b)){
            return node;
        }
        BNode<Integer> left = lca(node.left, a, b);
        BNode<Integer> right = lca(node.right, a, b);
        if (left != null && right != null){
            return node;
        }
        if (left!=null){
            return left;
        }
        else{
            return right;
        }
    }
    static int get_level(BNode<Integer> root, int a){
        if (root == null) return -1;
        if (root.info.equals(a)) {
            return 0;
        }
        int left = get_level(root.left, a);
        if (left != -1) {
            return left + 1;
        }
        int right = get_level(root.right, a);
        if (right != -1){
            return right + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        BTree<Integer> tree = new BTree<>();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            if (parts[2].equals("ROOT")) {
                tree.makeRoot(Integer.parseInt(parts[0]));
                map.put(parts[1], Integer.parseInt(parts[0]));
            }
            else{
                int pos = parts[2].equals("LEFT") ? 1:2;
                BNode<Integer> node = tree.find(Integer.parseInt(parts[3]));
                tree.addChild(node, pos, Integer.parseInt(parts[0]));
                map.put(parts[1], Integer.parseInt(parts[0]));
            }
        }
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            String[] parts = sc.nextLine().split(" ");
            Integer a = map.get(parts[0]);
            Integer b = map.get(parts[1]);
            if (a == null || b == null) {
                System.out.println("ERROR");
                continue;
            }
            if (a.equals(b)) {
                System.out.println(0);
                continue;
            }
            BNode<Integer> start = lca(tree.root, a, b);
            int lvla = get_level(start, a);
            int lvlb = get_level(start, b);
            int rez = lvla + lvlb;
            if (rez <= 0) {
                System.out.println("ERROR");
            }
            else {
                System.out.println(2 * rez);
            }
        }
    }
}
