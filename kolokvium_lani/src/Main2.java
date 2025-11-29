import java.util.Scanner;
import java.util.Stack;

class Pair{
    String first;
    String second;
    Pair(String first, String second){
        this.first = first;
        this.second = second;
    }
    String getFirst(){
        return first;
    }
    String getSecond(){
        return second;
    }
}

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        Stack<Pair> stack = new Stack<>();
        for (int i=0; i<n; i++){
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            if (parts[0].equals("ADD")){
                String a = parts[1];
                int b = Integer.parseInt(parts[2]);
                while (b!=0){
                    Pair pair = new Pair(parts[1], "waiting");
                    stack.push(pair);
                    b--;
                }
            }
            else if (parts[0].equals("PRINT")){

            }
        }
    }
}
