import java.util.Arrays;
import java.util.Scanner;

public class Vozovi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arrival = new int[n];
        int[] departure = new int[n];
        for (int i = 0; i < n; i++) {
            arrival[i] = sc.nextInt();
            departure[i] = sc.nextInt();
        }
        Arrays.sort(arrival);
        Arrays.sort(departure);
        int maxvozovi = 1, maxrez=1;
        int i=1, j=0;
        while (i < n && j < n) {
            if (arrival[i]<=departure[j]) {
                maxvozovi++;
                i++;
            }
            else{
                maxvozovi--;
                j++;
            }
            if (maxvozovi>maxrez){
                maxrez=maxvozovi;
            }
        }
        System.out.println(maxrez);
    }
}
