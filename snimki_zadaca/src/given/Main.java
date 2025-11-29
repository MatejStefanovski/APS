package given;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DLL<Integer> dll = new DLL<Integer>();
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int tmp=sc.nextInt();
            dll.insertLast(tmp);
        }
        System.out.println(dll.toString()+"\n");
        dll.remove_duplicates();
        System.out.println(dll.toString()+"\n");
    }
}