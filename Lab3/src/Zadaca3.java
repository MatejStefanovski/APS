import java.util.Scanner;

public class Zadaca3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        long maxProduct = arr[0];
        long currentProduct = arr[0];
        int start = 0, end = 0;
        int tempStart = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                currentProduct *= arr[i];
            } else {
                currentProduct = arr[i];
                tempStart = i;
            }

            if (currentProduct > maxProduct) {
                maxProduct = currentProduct;
                start = tempStart;
                end = i;
            }
        }
        System.out.println(maxProduct);
    }
}
