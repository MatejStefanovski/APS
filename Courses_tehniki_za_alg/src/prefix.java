import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// * + * 5 8 3 + 3 3    rez: 132

public class prefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str=s.split(" ");
        int temp1=0, temp2=0;
        Queue<String> q = new LinkedList<>();
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("+") || str[i].equals("*")) {
                q.add(str[i]);
            }
            else if (Character.isDigit(str[i].charAt(0))) {
                temp2 = temp1;
                temp1 = Integer.parseInt(str[i]);
            }
            if (temp1!=0 && temp2!=0) {
                String c=q.poll();
                if (c.equals("+")){
                    temp1+=temp2;
                    temp2=0;
                }
                else{
                    temp1*=temp2;
                    temp2=0;
                }
            }
        }
        System.out.println(temp1);
    }
}
