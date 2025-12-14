import java.util.Scanner;

public class Main4 {
    static int result=0;
    static void LCARecursive(BNode<Integer> node, int l, int r) {
        if (node == null) {
            return;
        }
        if (l<node.info && r<node.info) {
            LCARecursive(node.left, l, r);
        }
        else if (l>node.info && r>node.info) {
            LCARecursive(node.right, l, r);
        }
        else{
            result=node.info;
            return;
        }
    }
    static int LCA(BinarySearchTree bst, int l, int r) {
        LCARecursive(bst.getRoot(), l, r);
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            bst.insert(k);
        }
        int l = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(LCA(bst, l, r));
    }
}
