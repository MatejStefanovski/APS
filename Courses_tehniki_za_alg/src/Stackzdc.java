import java.util.Scanner;
import java.util.Stack;

public class Stackzdc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c-'0'>=0 && c-'0'<=9){
                int temp=0;
                while (s.charAt(i)!=' '){
                    temp=temp*10+(s.charAt(i)-'0');
                    i++;
                }
                stack.push(temp);
            }
            else if (c=='+' || c=='*' || c=='-' || c=='/'){
                if (c=='+'){
                    int temp1=stack.pop();
                    int temp2=stack.pop();
                    stack.push(temp1+temp2);
                }
                else if (c=='*'){
                    int temp1=stack.pop();
                    int temp2=stack.pop();
                    stack.push(temp1*temp2);
                }
                else if (c=='/'){
                    int temp1=stack.pop();
                    int temp2=stack.pop();
                    stack.push(temp2/temp1);
                }
                else{
                    int temp1=stack.pop();
                    int temp2=stack.pop();
                    stack.push(temp2-temp1);
                }
            }
        }
        System.out.println(stack.pop());
    }
}
