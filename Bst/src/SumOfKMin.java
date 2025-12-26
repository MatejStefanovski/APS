import java.util.Scanner;

public class SumOfKMin {
    static int br=0;
    static int res=0;
    static int sum=0;
    static BNode<Integer> najmalK(BNode<Integer> node, int k) {
        if (node == null || br>=k) {
            return null;
        }
        najmalK(node.left,k);
        br++;
        if (br==k) {
             res=node.info;
             return node;
        }
        return najmalK(node.right,k);
    }
    static void presmetaj(BNode<Integer> node) {
        if (node == null) {
            return;
        }
        presmetaj(node.left);
        if (node.info <= res) {
            sum += node.info;
        }
        presmetaj(node.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int n = sc.nextInt();
        for  (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            bst.insert(a);
        }
        int k = sc.nextInt();
        BNode<Integer> najmal = najmalK(bst.getRoot(), k);
        System.out.println("Najmal k-ti element: " + res);
        presmetaj(bst.getRoot());
        System.out.println("Zbir na elementi pomali od k-ti najmal element: " + sum);
    }
}
