import java.util.Scanner;

public class Main {
    static void prevrti(DLL<Integer> dll, int n){
        DLL<Integer> pomosna = new DLL<Integer>();
        DLLNode<Integer> node=dll.getLast();
        for (int i=n-1; i>=0; i--){
            if (node.element%2==0){
                pomosna.insertLast(node.element);
            }
            node=node.pred;
        }
        node=dll.getLast();
        for (int i=n-1; i>=0; i--){
            if (node.element%2==1){
                pomosna.insertLast(node.element);
            }
            node=node.pred;
        }
        System.out.println(pomosna);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLL<Integer> dll = new DLL<Integer>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            dll.insertLast(a);
        }
        System.out.println(dll+"\n");
        prevrti(dll,n);
    }
}
