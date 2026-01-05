import java.util.Scanner;

public class bst_ex1 {
    static int funkcija(BNode<Integer> node, int br, int level) {
        if (node == null) {
            return -1;
        }
        if (node.info == br) {
            return level;
        }
        if (br < node.info) {
            return funkcija(node.left, br, level+1);
        } else {
            return funkcija(node.right, br, level+1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i=0; i<n+m; i++){
            String[] s = sc.nextLine().split(" ");
            if (s[0].equals("insert")){
                bst.insert(Integer.parseInt(s[1]));
            }
            else{
                int level = funkcija(bst.getRoot(), Integer.parseInt(s[1]), 1);
                System.out.println(level);
            }
        }
    }
}
