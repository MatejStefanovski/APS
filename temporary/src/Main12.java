import java.util.Scanner;

public class Main12 {
    static class Vraboten{
        public int id;
        public int plata;
        Vraboten(int id, int plata){
            this.id = id;
            this.plata = plata;
        }
        int getId(){
            return id;
        }
        int getPlata(){
            return plata;
        }
        void print(){
            System.out.println("id: " + id + " plata: " + plata);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        SLL<Vraboten> sll = new SLL<>();
        for (int i = 0; i < n; i++) {
            int id=sc.nextInt();
            int plata=sc.nextInt();
            sll.insertLast(new Vraboten(id, plata));
        }
        int iznos=sc.nextInt();
        SLLNode<Vraboten> node=sll.getFirst();
        for (SLLNode<Vraboten> i=sll.getFirst(); i!=null; i=i.succ){
            for (SLLNode<Vraboten> j=sll.getFirst(); j!=null; j=j.succ){
                if (i.element.getId()<j.element.getId()){
                    Vraboten temp=i.element;
                    i.element=j.element;
                    j.element=temp;
                }
            }
        }
        while(node!=null){
            if (node.element.getPlata()<iznos){
                sll.delete(node);
            }
            node=node.succ;
        }
        SLLNode<Vraboten> k=sll.getFirst();
        while (k!=null){
            k.element.print();
            k=k.succ;
        }
    }
}
