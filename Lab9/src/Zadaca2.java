import java.util.ArrayList;
import java.util.Scanner;

public class Zadaca2 {
    static BNode<Integer> funkcija(BNode<Integer> node, int p, int q){
        if (node == null){
            return null;
        }
        if (p < node.info && q < node.info) {
            return funkcija(node.left, p, q);
        }
        else if (p > node.info && q > node.info) {
            return funkcija(node.right, p, q);
        }
        else {
            return node;
        }
    }
    static void proizvod(BNode<Integer> node, ArrayList<Integer> list, int k){
        if  (node == null || list.size() == k){
            return;
        }
        proizvod(node.left, list, k);
        if (list.size()<k){
            list.add(node.info);
        }
        proizvod(node.right, list, k);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (int i = 0; i < n; i++) {
            bst.insert(sc.nextInt());
        }
        int p=sc.nextInt();
        int q=sc.nextInt();
        int k=sc.nextInt();
        BNode<Integer> roottmp = funkcija(bst.getRoot(), p, q);
        ArrayList<Integer> list = new ArrayList<>();
        proizvod(roottmp, list, k);
        int proizvodd=1;
        for (int i=0; i<list.size();i++){
            proizvodd*=list.get(i);
        }
        System.out.println(proizvodd);
    }
}
