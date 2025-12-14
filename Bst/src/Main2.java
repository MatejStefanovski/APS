import java.util.Scanner;

public class Main2 {
    static int result=0;
    static int count=0;
    static void kthlargestSubtree(BNode<Integer> node, int k) {
        if (node == null) {
            return;
        }
        kthlargestSubtree(node.right, k);
        count++;
        if (count == k) {
            result= node.info;
            return;
        }
        kthlargestSubtree(node.left, k);
    }
    static int kthlargest(BinarySearchTree bst, int k) {
        kthlargestSubtree(bst.getRoot(), k);
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < n; i++) {
            bst.insert(sc.nextInt());
        }
        System.out.println(kthlargest(bst, k));
    }
}
