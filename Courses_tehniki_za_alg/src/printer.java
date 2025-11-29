import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class printer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Queue<String> waiting = new LinkedList<>();
        Queue<String> printed = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts=line.split(" ");
            if (parts[0].equals("ADD")){
                int temp=Integer.parseInt(parts[2]);
                String s=parts[1];
                while (temp>0){
                    waiting.add(s);
                    temp--;
                }
            }
            else if (parts[0].equals("PRINT")){
                int temp=Integer.parseInt(parts[1]);
                while (temp>0){
                    printed.add(waiting.poll());
                    temp--;
                }
            }
            else{
                System.out.println("Current status: ");
                Queue<String> queue = new LinkedList<>();
                while (!printed.isEmpty()){
                    queue.add(printed.peek());
                    System.out.println(printed.poll() + " printed");
                }
                while (!queue.isEmpty()){
                    printed.add(queue.poll());
                }
                while (!waiting.isEmpty()){
                    queue.add(waiting.peek());
                    System.out.println(waiting.poll() + " waiting");
                }
                while (!queue.isEmpty()){
                    waiting.add(queue.poll());
                }
            }
        }
    }
}
