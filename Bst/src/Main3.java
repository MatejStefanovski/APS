import java.util.Scanner;    //Suma pomegju l i r

public class Main3 {
    static int sum=0;
    static void SumBetweenRecursive(BNode<Integer> node, int l, int r){
        if (node==null){
            return;
        }
        SumBetweenRecursive(node.left,l,r);
        if (node.info>=l && node.info<=r){
            sum+=node.info;
        }
        SumBetweenRecursive(node.right,l,r);
    }
    static int SumBetween(BinarySearchTree<Integer> bst, int l, int r) {
        SumBetweenRecursive(bst.getRoot(), l, r);
        return sum;
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
        System.out.println(SumBetween(bst, l, r));
    }
}
