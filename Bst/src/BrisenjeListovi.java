import java.util.Scanner;

public class BrisenjeListovi {
    static BinarySearchTree<Integer> bst = new BinarySearchTree<>();
    static void brisiListovi(BNode<Integer> node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            bst.remove(node.info);
            return;
        }
        brisiListovi(node.left);
        brisiListovi(node.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < n; i++) {
            bst.insert(sc.nextInt());
        }
        bst.printTree();
        System.out.println("--------------------------------------------\n");
        brisiListovi(bst.getRoot());
        bst.printTree();
    }
}
