import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if (Character.isDigit(c)){
                int tmp=0;
                while (!Character.isSpaceChar(c)){
                    tmp=tmp*10+(c-'0');
                    i++;
                    c=s.charAt(i);
                }
                stack.push(tmp);
            }
            else if (c=='+') {
                int a=stack.pop();
                int b=stack.pop();
                stack.push(a+b);
            }
            else if (c=='*') {
                int a=stack.pop();
                int b=stack.pop();
                stack.push(a*b);
            }
        }
        System.out.println(stack.pop());
    }
}