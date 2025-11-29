import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<Integer> dll = new DLL<>();
        for (int i=0; i<n; i++){
            int temp=sc.nextInt();
            dll.insertLast(temp);
        }
        int a1, b1, a2, b2;
        a1 = sc.nextInt();
        a1--;
        b1 = sc.nextInt();
        a2 = sc.nextInt();
        a2--;
        b2 = sc.nextInt();
        DLL<Integer> prva = new DLL<>();
        DLL<Integer> vtora = new DLL<>();
        DLLNode<Integer> node=dll.getFirst();
        int k=0;
        while (k<a1){
            k++;
            node=node.succ;
        }
        while (k<b1){
            prva.insertLast(node.element);
            node=node.succ;
            k++;
        }
        k=0;
        node=dll.getFirst();
        while (k<a2){
            k++;
            node=node.succ;
        }
        while (k<b2){
            vtora.insertLast(node.element);
            node=node.succ;
            k++;
        }
//        System.out.println(prva.toString());
//        System.out.println(vtora.toString());
        DLL<Integer> kraj = new DLL<>();
        k=0;
        node=dll.getFirst();
        DLLNode<Integer> nprva = prva.getFirst();
        DLLNode<Integer> nvtora = vtora.getFirst();
        while (k<a1){
            kraj.insertLast(node.element);
            k++;
            node=node.succ;
        }
        while (k<b1){
            kraj.insertLast(nvtora.element);
            nvtora=nvtora.succ;
            node=node.succ;
            k++;
        }
        while (k<a2){
            kraj.insertLast(node.element);
            node=node.succ;
            k++;
        }
        while (k<b2){
            kraj.insertLast(nprva.element);
            nprva=nprva.succ;
            node=node.succ;
            k++;
        }
        while (node!=null){
            kraj.insertLast(node.element);
            node=node.succ;
        }
        System.out.println(kraj.toString());
    }
}
