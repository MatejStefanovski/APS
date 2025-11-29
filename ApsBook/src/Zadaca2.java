import java.util.Scanner;

public class Zadaca2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> dll = new DLL<Integer>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            dll.insertLast(a);
        }
        int a = sc.nextInt();
        DLL<Integer> vtora = new DLL<Integer>();
        for (int i = 0; i < a; i++) {
            int b = sc.nextInt();
            vtora.insertLast(b);
        }
        /*System.out.println(dll);
        System.out.println(vtora);*/
        DLLNode<Integer> node1=vtora.getFirst();
        DLLNode<Integer> node=dll.getFirst();
        for (int i = 0; i < n; i++) {
            if (node.element.equals(node1.element)){
                int br=1;
                while (br<a){
                    if (!node.element.equals(node1.element)){
                        break;
                    }
                    node=node.succ;
                    node1=node1.succ;
                    br++;
                }
                if (br==a){
                    while(br!=0){
                        dll.delete(node);
                        node=node.pred;
                        br--;
                    }
                }
            }
            node1=vtora.getFirst();
            node=node.succ;
            if (node.equals(dll.getLast())){
                break;
            }
        }
        System.out.println(dll.toString());
        System.out.println(vtora.toString());
    }
}
