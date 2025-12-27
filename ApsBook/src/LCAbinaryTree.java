import java.util.Scanner;

public class LCAbinaryTree {
    static int FindLCA(BNode<Integer> node, int prv, int vtor) {
        if (node == null) {
            return 0;
        }
        if (node.info == prv || node.info == vtor){
            return node.info;
        }
        int findLeft = FindLCA(node.left, prv, vtor);
        int findRight = FindLCA(node.right, prv, vtor);
        if (findRight != 0 && findLeft != 0){
            return node.info;
        }
        else if (findLeft != 0 && findRight == 0){
            return findLeft;
        }
        else if (findLeft == 0 && findRight != 0){
            return findRight;
        }
        else {
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BTree<Integer> tree =  new BTree<>();
        int root = sc.nextInt();
        tree.makeRoot(root);
        for (int i=0; i<n-1; i++){
            int parent = sc.nextInt();
            int child = sc.nextInt();
            int side = sc.next().equals("LEFT") ? 1:2;
            BNode<Integer> parentNode = tree.find(parent);
            tree.addChild(parentNode, side, child);
        }
        int prvo = sc.nextInt();
        int vtoro = sc.nextInt();
        int lca = FindLCA(tree.root, prvo, vtoro);
        System.out.println(lca);
    }
}
