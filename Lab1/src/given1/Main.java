package given1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DLL<Integer> dll = new DLL<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int tmp=sc.nextInt();
            dll.insertLast(tmp);
        }
        int k=sc.nextInt();
        dll.premesti(k);
        System.out.println(dll.toString());
    }
}