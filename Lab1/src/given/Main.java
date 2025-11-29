package given;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SLL<String> sll = new SLL<String>();
        int n, l;
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        for (int i=0; i<n; i++) {
            String s = sc.next();
            sll.insertLast(s);
        }
        l=sc.nextInt();
        SLLNode<String> node=sll.getFirst();
        while (node!=null) {
            if (node.element.length()>l){
                sll.insertBefore("Outlier", node);
            }
            node=node.succ;
        }
        System.out.println(sll.toString());
    }
}
