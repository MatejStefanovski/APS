import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Stack<String> s=new Stack<>();
        while (true){
            String temp=sc.nextLine();
            if (temp.charAt(0)=='f'){
                s.push(temp);
            }
            else if (temp.charAt(0)=='e'){
                String tmp=temp.substring(3);
                if (!tmp.equals(s.peek()) || s.isEmpty()){
                    System.out.println("Invalid");
                    return;
                }
                s.pop();
            }
            else{
                break;
            }
        }
        if (!s.isEmpty()){
            System.out.println("Invalid");
        }
        else{
            System.out.println("Valid");
        }
    }
}
