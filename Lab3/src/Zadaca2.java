import java.util.Scanner;

public class Zadaca2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] niza=new int[n];
        for (int i=0;i<n;i++){
            niza[i]=sc.nextInt();
        }
        if (n==1){
            System.out.println("Ima eden element");
        }
        for (int i=1;i<n;i++){
            int j=0;
            while (i!=0 && niza[i]<niza[i-1]){
                int temp=niza[i-1];
                niza[i-1]=niza[i];
                niza[i]=temp;
                i--;
                j++;
            }
            if (j!=0){
                System.out.println(niza[i]+" "+j);
            }
        }
        for (int i=0;i<n;i++){
            System.out.print(niza[i]+" ");
        }
    }
}
