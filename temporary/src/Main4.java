import java.util.Scanner;

//Listata treba da se napravi zig zag
//1. Dokolku elementot e 0 se brise
//2.Ako ima dva pozitivni eden do drug se brise vtoriot
//3.AKo ima dva negativni eden do drug izmegju se niv dodava nov jazel so vrednost absoluten broj od prviot jazel
//input: 4 7 -3 -2 0 7 7 9
//output: 4 -3 3 -2 7

//https://github.com/DamjanSandev/APS/tree/master/src/Kolokvium

public class Main4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        SLL<Integer> sll=new SLL<Integer>();
        for (int i = 0; i < n; i++) {
            int a=sc.nextInt();
            sll.insertLast(a);
        }
        SLLNode<Integer> node=sll.getFirst();
        while (node.succ!=null) {
            if (node.element.equals(0)){
                sll.delete(node);
            }
            else if (node.element>0 && node.succ.element>0){
                sll.delete(node.succ);
            }
            else if (node.getElement()<0 && node.succ.getElement()<0){
                sll.insertAfter(node.getElement()*(-1), node);
            }
            node=node.succ;
        }
        System.out.println(sll.toString());
    }
}
