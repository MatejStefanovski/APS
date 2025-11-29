import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        DLL<Integer> dll=new DLL<>();
        for (int i=0; i<n; i++){
            int temp=sc.nextInt();
            dll.insertLast(temp);
        }
        int m, k;
        m=sc.nextInt();
        k=sc.nextInt();
        System.out.println(dll.toString());
        DLLNode<Integer> node=dll.getFirst();
        boolean flag=false;
        int poz=-1;
        for (int i=0; i<n; i++){
            if (node.element==m){
                flag=true;
                poz=i;
                break;
            }
            node=node.succ;
        }
        if (!flag){
            System.out.println("Elementot ne postoi vo listata");
            System.out.println(dll.toString());
            return;
        }
        k = k % n;

        int targetPoz = poz - k;
        if (targetPoz < 0) targetPoz += n+1;

        DLLNode<Integer> temp = dll.getFirst();
        boolean flag2=false;
        for (int i = 0; i < targetPoz; i++) {
            temp = temp.succ;
        }
        if (targetPoz==n-1)
            flag2=true;

        dll.delete(node);
        if (flag2){
            dll.insertBefore(m, temp);
        }
        else{
            dll.insertLast(m);
        }
        System.out.println(dll.toString());
    }
}







/*public class Main6 {                  //Listi 6
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        SLL<String> sll = new SLL<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            sll.insertLast(s);
        }
        System.out.println(sll.toString());
        int l=sc.nextInt();
        int pok=-1;
        SLLNode<String> node=sll.getFirst();
        for (int i = 0; i < n; i++) {
            if (node.element.length()==l){
                pok=i;
            }
            node=node.succ;
        }
        node=sll.getFirst();
        for (int i=0; i<pok; i++){
            node=node.succ;
        }
        sll.delete(node);
        sll.insertFirst(node.element);
        System.out.println(sll.toString());
    }
}
*/








/*public class Main6 {                  //Listi 13
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        DLL<Integer> dll = new DLL<>();
        int prosekpred=0, prosekposle=0, br1=0, br2=0;
        for (int i=0; i<n; i++) {
            int temp=sc.nextInt();
            dll.insertLast(temp);
        }
        int zbir=0;
        for (int i=0; i<n; i++) {
            DLLNode<Integer> iterator1=dll.getFirst();
            DLLNode<Integer> iterator2=dll.getLast();
            br1 = 0;
            br2 = n - 1;
            prosekpred = 0;
            prosekposle = 0;
            while (br1<i){
                prosekpred+=iterator1.element;
                iterator1=iterator1.succ;
                br1++;
            }
            int r=0;
            while (br2>i){
                prosekposle+=iterator2.element;
                iterator2=iterator2.pred;
                br2--;
                r++;
            }
            if (br1 > 0 && br2 < n - 1) {
                if ((float) prosekpred / br1 > (float) prosekposle / r) {
                    zbir++;
                }
            }
        }
        System.out.println(zbir);
    }
}*/







/*public class Main6 {                  //Listi 12
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        DLL<Integer> dll=new DLL<>();
        for (int i=0; i<n; i++){
            int temp=sc.nextInt();
            dll.insertLast(temp);
        }
        int k=sc.nextInt();
        System.out.println(dll.toString());
        for (int i=0; i<k; i++){
            DLLNode<Integer> node=dll.getFirst();
            dll.delete(node);
            dll.insertLast(node.element);
        }
        System.out.println(dll.toString());
    }
}*/