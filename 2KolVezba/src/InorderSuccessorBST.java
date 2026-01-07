import java.util.ArrayList;
import java.util.Scanner;

public class InorderSuccessorBST {
    static ArrayList<Integer> list = new ArrayList<>();
    static void funkcija(BNode<Integer> node){
        if (node == null) {
            return;
        }
        funkcija(node.left);
        list.add(node.info);
        funkcija(node.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for(int i=0;i<n;i++) {
            bst.insert(sc.nextInt());
        }
        funkcija(bst.getRoot());
        for (int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
