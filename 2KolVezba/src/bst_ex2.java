import java.util.Scanner;

public class bst_ex2 {
    static int funkcija(BNode<Integer> node, int val){
        if (node == null){
            return 0;
        }
        if (node.info>val) {
            return 1 + funkcija(node.left, val) + funkcija(node.right, val);
        }
        else{
            return funkcija(node.left, val) + funkcija(node.right, val);
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
                BNode<Integer> node = bst.getRoot();
                int elementi = funkcija(node, Integer.parseInt(s[1]));
                System.out.println(elementi);
            }
        }
    }
}
