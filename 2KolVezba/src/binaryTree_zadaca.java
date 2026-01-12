import java.util.Scanner;

public class binaryTree_zadaca {
    static int max=0;
    static void funkcija(BNode<Integer> node, int t) {
        if (node == null) {
            return;
        }
        funkcija(node.left, t+1);
        funkcija(node.right, t+1);
        if (t>max){
            max=t;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BTree<Integer> tree = new BTree<>();
        int root = sc.nextInt();
        tree.makeRoot(root);
        for (int i = 0; i < n-1; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            int strana = sc.next().equals("LEFT") ? 1:2;
            BNode<Integer> node = tree.find(parent);
            tree.addChild(node, strana, child);
        }
        funkcija(tree.root, 0);
        int levo = max;
        max=0;
        funkcija(tree.root, 0);
        int desno=max;
        System.out.println(levo+desno);
    }
}
