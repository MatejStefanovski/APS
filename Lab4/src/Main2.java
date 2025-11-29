import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();

        while (true) {
            String line = sc.nextLine().trim();

            if (line.equals("x")) break;

            if (line.startsWith("end")) {
                String funcName = line.substring(3);

                if (stack.isEmpty() || !stack.peek().equals(funcName)) {
                    System.out.println("Invalid");
                    return;
                }

                stack.pop();
            } else {
                stack.push(line);
            }
        }

        if (stack.isEmpty()) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }
}

