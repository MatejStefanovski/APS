import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrival = new int[n];
        int[] departure = new int[n];

        for (int i = 0; i < n; i++) {
            arrival[i] = sc.nextInt();
            departure[i] = sc.nextInt();
        }

        Arrays.sort(arrival);
        Arrays.sort(departure);

        int platformsNeeded = 1;
        int result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arrival[i] <= departure[j]) {
                platformsNeeded++;
                i++;
            } else {
                platformsNeeded--;
                j++;
            }
            result = Math.max(result, platformsNeeded);
        }

        System.out.println(result);
    }
}



/*public class Main {
    static class Voz{
        int a;
        int b;

        Voz(int a, int b){
            this.a = a;
            this.b = b;
        }

        int getA(){
            return a;
        }
        int getB(){
            return b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        Voz[] voz = new Voz[n];
        for (int i=0; i<n; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            voz[i] = new Voz(a,b);
        }

        int[] niza=new int[n];
        for(int i=0; i<n; i++){
            niza[i]=voz[i].getB()-voz[i].getA();
        }

        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if (niza[i]>niza[j]){
                    int temp=niza[i];
                    niza[i]=niza[j];
                    niza[j]=temp;
                    Voz tmp=voz[i];
                    voz[i]=voz[j];
                    voz[j]=tmp;
                }
            }
        }

        //for (int i=0; i<n; i++){
            //System.out.println(voz[i].getA()+" "+voz[i].getB());
        //}
    }
}*/