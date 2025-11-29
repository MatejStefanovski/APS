import java.util.Scanner;

public class Kolokvium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> dll = new DLL<>();
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            dll.insertLast(temp);
        }
        DLLNode<Integer> node1=dll.getFirst();
        DLLNode<Integer> node2=dll.getLast();
        int poz1=0, poz2=0;
        while (node1!=null){
            if (node1.element%2==0){
                break;
            }
            node1=node1.succ;
            poz1++;
        }
        while (node2!=null){
            if (node2.element%2==1){
                break;
            }
            node2=node2.pred;
            poz2++;
        }
        dll.insertBefore(node2.element, node1);
        dll.insertBefore(node1.element, node2);
        dll.delete(node1);
        dll.delete(node2);
        System.out.println(dll.toString());
    }
}
