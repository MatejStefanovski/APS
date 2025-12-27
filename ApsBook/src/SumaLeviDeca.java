import java.util.Scanner;

public class SumaLeviDeca {
    static int sum = 0;
    static void SumLeft(BNode<Integer> node){
        if (node == null) {
            return;
        }
        if (node.right == null && node.left != null) {
            sum+=node.info;
        }
        SumLeft(node.left);
        SumLeft(node.right);
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
        SumLeft(tree.root);
        System.out.println(sum);
    }
}
