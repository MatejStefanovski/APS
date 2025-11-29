import java.util.Scanner;

class PushZero
{
    static void pushZerosToBeginning(int arr[], int n)
    {
        for (int i = 0; i < n; i++){
            if (arr[i] == 0){
                for (int j=i; j>0; j--){
                    arr[j]=arr[j-1];
                }
                arr[0]=0;
            }
        }
        String s="";
        for (int i=0; i<n; i++){
            s+=arr[i];
            s+=" ";
        }
        System.out.println("Transformiranata niza e:");
        System.out.println(s);
    }

    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] niza=new int[n];
        for (int i=0;i<n;i++){
            niza[i]=sc.nextInt();
        }
        pushZerosToBeginning(niza, n);
    }
}


/*import java.util.Scanner;

public class NiziListi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        float prosek=0;
        int[] niza=new int[n];
        String s1="{", s2="{";
        for (int i=0; i<n; i++){
            niza[i]=sc.nextInt();
            prosek+=niza[i];
            s1+=niza[i];
            if (i!=n-1)
                s1+=",";
        }
        System.out.println(s1+"}");
        prosek/=n;
        int[] niza2=new int[n];
        int j=0;
        for(int i=0; i<n; i++){
            if (prosek<=niza[i]){
                niza2[j]=niza[i];
                j++;
            }
        }
        for (int i=0; i<j; i++){
            s2+=niza2[i];
            if (i!=j-1)
                s2+=",";
        }
        System.out.println(s2+"}");
    }
}
*/