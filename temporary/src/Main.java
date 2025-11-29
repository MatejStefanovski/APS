import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int [n];
        int[] dep=new int [n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
            dep[i]=sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i]<arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
                if (dep[i]<dep[j]){
                    int temp=dep[i];
                    dep[i]=dep[j];
                    dep[j]=temp;
                }
            }
        }

        int i=1, j=0;
        int res=1, platformi=1;

        while(i<n && j<n){
            if (arr[i]<=dep[j]){
                i++;
                platformi++;
            }
            else{
                j++;
                platformi--;
            }
            if (res<platformi)
                res=platformi;
        }

        System.out.println(res);
    }
}