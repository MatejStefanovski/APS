import java.util.Arrays;             //Zalutani broevi
import java.util.Scanner;

public class Main8 {
    static int funkcija(int[] niza, int pocetok, int kraj, int br){
        int mid=(pocetok+kraj)/2;
        if(br==niza[mid]){
            return mid;
        }
        else if (br>niza[mid]){
            return funkcija(niza, mid+1, kraj, br);
        }
        else{
            return funkcija(niza, pocetok, mid-1, br);
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int[] sortinrana=new int[n];
        for (int i=0;i<n;i++){
            a[i]=sc.nextInt();
            sortinrana[i]=a[i];
        }
        Arrays.sort(sortinrana);
        int[] izgubeni=new int[n];
        int[] izgubenip=new int[n];
        int br=0;
        for (int i=0; i<n; i++){
            if (a[i]<sortinrana[i]){
                int temp=i-funkcija(sortinrana, 0, n, a[i]);
                izgubeni[br]=a[i];
                izgubenip[br]=temp;
                br++;
            }
        }
        System.out.println(br);
        for (int i=0; i<br; i++){
            System.out.println(izgubeni[i] + " " + izgubenip[i]);
        }
    }
}
