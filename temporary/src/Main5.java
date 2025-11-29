import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main5 {

    static int evaluateExpression(String expression){
        Stack<Integer> stack = new Stack<>();
        int proizvod=1;
        char prev=' ';
        for (int i=0; i<expression.length(); i++){
            int temp=0;
            char g=' ';
            while (i<expression.length()){
                int c=expression.charAt(i)-'0';
                if (c==-5 || c==-6){
                    g=expression.charAt(i);
                    break;
                }
                temp=temp*10+c;
                i++;
            }
            if (prev=='+'){
                stack.push(temp);
                prev=g;
            }
            else if (prev=='*'){
                if (!stack.isEmpty()){
                    int v=stack.pop();
                    v*=temp;
                    stack.push(v);
                }
                else{
                    stack.push(temp);
                }
                prev=g;
            }
            else{
                stack.push(temp);
                prev=g;
            }
        }
        int zbir=0;
        while (!stack.isEmpty()){
            int v=stack.pop();
            zbir+=v;
        }
        return zbir;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }
}
