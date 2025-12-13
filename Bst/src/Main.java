import java.util.Scanner;

public class Main {
    static int sum = 0;
    static void transform(BNode<Integer> node) {
        if (node == null) {
            return;
        }
        transform(node.left);
        node.info= node.info+sum;
        sum = node.info;
        transform(node.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < n; i++) {
            bst.insert(sc.nextInt());
        }
        transform(bst.getRoot());
        bst.printTreeWithIndent();
    }
}
