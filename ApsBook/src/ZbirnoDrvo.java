import java.util.ArrayList;
import java.util.Scanner;

public class ZbirnoDrvo {

    static boolean flag = true;

    static int Proveri(BNode<Integer> node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return node.info;
        }
        int leftSum = Proveri(node.left);
        int rightSum = Proveri(node.right);
        if (node.info != leftSum + rightSum) {
            flag = false;
        }
        return node.info + leftSum + rightSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BTree<Integer> tree = new BTree<>();

        int root = sc.nextInt();
        tree.makeRoot(root);

        for (int i = 0; i < n - 1; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            int strana = sc.next().equals("LEFT") ? 1 : 2;
            BNode<Integer> parentNode = tree.find(parent);
            tree.addChild(parentNode, strana, child);
        }

        Proveri(tree.root);

        if (flag) {
            System.out.println("The given tree is a SumTree");
        } else {
            System.out.println("The given tree is not a SumTree");
        }
    }
}
