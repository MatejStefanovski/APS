import java.util.Scanner;

public class bTree_ex {
    static boolean flag = true;
    static int t=0;
    static void proveri(BNode<Integer> node){
        if (node==null){
            return;
        }
        proveri(node.left);
        proveri(node.right);
        t+= node.info;
    }
    static void sum_tree(BNode<Integer> node){
        if (node == null) {
            return;
        }
        if (node.left != null || node.right != null) {
            t=0;
            proveri(node);
            t -= node.info;
            if (t!=node.info){
                flag=false;
            }
        }
        if (node.left != null){
            sum_tree(node.left);
        }
        if (node.right != null){
            sum_tree(node.right);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int root = sc.nextInt();
        BTree<Integer> tree = new BTree<>();
        tree.makeRoot(root);
        for (int i=0; i<n-1; i++){
            int parent = sc.nextInt();
            int child = sc.nextInt();
            int position = sc.next().equals("LEFT") ? 1:2;
            BNode<Integer> node = tree.find(parent);
            tree.addChild(node, position, child);
        }
        sum_tree(tree.root);
        if (!flag) {
            System.out.println("Ne e zbirno drvo");
        } else {
            System.out.println("Zbirno drvo");
        }
    }
}
