import java.util.Scanner;

public class Building_BTree_ex4 {
    static int br_deca(BNode<String> node){
        if (node == null) {
            return 0;
        }
        return 1+br_deca(node.left)+br_deca(node.right);
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
                int t = br_deca(tree.find(parts[1]));
                System.out.println(t-1);
            }
        }
    }
}
