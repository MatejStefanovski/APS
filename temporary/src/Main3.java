import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        int n= input.nextInt();

        int[] pocetoci=new int[n];
        int[] zavrsetoci=new int[n];

        for(int i=0;i<n;i++){
            pocetoci[i]= input.nextInt();
            zavrsetoci[i]= input.nextInt();
        }

        System.out.println(Arrays.toString(pocetoci));
        System.out.print(Arrays.toString(zavrsetoci));

        Arrays.sort(pocetoci);
        Arrays.sort(zavrsetoci);

        int sobi=0;
        int j=0;


        for(int i=0;i<n;i++){
            if(pocetoci[i]<=zavrsetoci[j]){
                sobi++;
            }
            else {
                j++;
            }
        }
        System.out.println();
        System.out.println(sobi);
    }
}
