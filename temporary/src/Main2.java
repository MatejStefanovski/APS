import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        int n, m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] niza=new int[n];
        for (int i = 0; i < n; i++) {
            niza[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (niza[i] > niza[j]) {
                    int temp = niza[i];
                    niza[i] = niza[j];
                    niza[j] = temp;
                }
            }
        }
        int svetilki=0, j=0;
        for (int i=m; i>=0; i--){
            int posledna=0, pretposledna=0, treta=0;
            for (j=0; j<n; j++){
                posledna=niza[j];
                pretposledna=niza[j+1];
                treta=niza[j+2];
            }
            if (i-2>0 && m==posledna){

            }
        }
    }
}
