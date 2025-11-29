import java.util.Scanner;

public class LightStreet {
    static void sortiraj(int n,int[] niza){
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(niza[i]>niza[j]){
                    int temp=niza[i];
                    niza[i]=niza[j];
                    niza[j]=temp;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int[] pozicii=new int[n];
        for(int i=0;i<n;i++){
            pozicii[i]=in.nextInt();
        }
        sortiraj(n,pozicii);
        int svetilki=0;
        int i=1;
        int j=0;
        while(i<=m){
            int best=-1;
            while((j<n) && (pozicii[j]<=i+2)){
                best=pozicii[j];
                j++;
            }
            if(best==-1){
                System.out.println(svetilki);
                return;
            }
            svetilki++;
            i=best+3;
        }
        System.out.println(svetilki);
    }
}
