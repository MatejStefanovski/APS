import java.util.Scanner;

public class Building_BTree_ex2 {
    static int jazli_so_2(BNode<String> node){
        if (node == null) {
            return 0;
        }
        if (node.left != null && node.right != null) {
            return 1+jazli_so_2(node.left) + jazli_so_2(node.right);
        }
        else{
            return jazli_so_2(node.left)+jazli_so_2(node.right);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        sc.nextLine();
        BTree<String> tree = new BTree<>();
        for (int i = 0; i < n+q; i++) {
            String[] parts = sc.nextLine().split(" ");
            if (parts[0].equals("root")){
                tree.makeRoot(parts[1]);
            }
            else if (parts[0].equals("add")){
                String root = parts[1];
                String child = parts[2];
                int side = parts[3].equals("LEFT") ? 1:2;
                tree.addChild(tree.find(root), side, child);
            }
            else{
                int t = jazli_so_2(tree.find(parts[1]));
                System.out.println(t);
            }
        }
    }
}
