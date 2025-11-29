import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        n=Integer.parseInt(sc.nextLine());
        Stack<Character> stack=new Stack<>();
        for (int i=0; i<n; i++){
            String s=sc.nextLine();
            if (s.equals("SHOW")){
                break;
            }
            if (s.charAt(0)=='U'){
                stack.pop();
            }
            else{
                char t=s.charAt(s.length()-1);
                stack.push(t);
            }
        }
        String kraj="", kraj1="";
        while (!stack.isEmpty()){
            kraj+=stack.pop();
        }
        for (int i=kraj.length()-1; i>=0; i--){
            kraj1+=kraj.charAt(i);
        }
        System.out.println(kraj1);
    }
}