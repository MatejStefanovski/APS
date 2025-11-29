import java.util.Scanner;      //Kolokviumska za 10ka
import java.util.Stack;

public class Main10 {
    static class Obleka{
        public String ime;
        public int br;
        public Obleka(String ime, int br){
            this.ime = ime;
            this.br = br;
        }
        String getIme(){
            return ime;
        }
        int getBr(){
            return br;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int rez=0;
        Stack<Obleka> stack = new Stack<>();
        Stack<Obleka> pomosen = new Stack<>();
        for (int i=0; i<n; i++){
            String ime = sc.nextLine();
            stack.push(new Obleka(ime, 0));
        }
        for (int i=0; i<m; i++){
            String vadi= sc.nextLine();
            if (vadi.substring(0, 4).equals("Zemi")){
                String temp=vadi.substring(5);
                while (!stack.peek().getIme().equals(temp)){
                    stack.peek().br++;
                    if (stack.peek().getBr() >= 3){
                        stack.peek().br=0;
                        rez++;
                    }
                    pomosen.push(stack.peek());
                    stack.pop();
                }
                Obleka o = stack.pop();
                o.br++;
                if (o.br >= 3) {
                    o.br = 0;
                    rez++;
                }
                pomosen.push(o);
                while (!pomosen.isEmpty()){
                    stack.push(pomosen.peek());
                    pomosen.pop();
                }
            }
            else{
                String temp=vadi.substring(7);
                stack.push(new Obleka(temp, 0));
            }
        }
        System.out.println(rez);
    }
}
