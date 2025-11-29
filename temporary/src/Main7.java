/*За дадена сума од цифри и број од цифри, да се најде најмалиот број чиј цифри ја формираат таа сума.


Влез: На влез се дадени два броја, N бројот на цифри и M сумата на цифри


Излез: На излез треба да се испечати најмалиот број со N цифри кој ја формира таа сума. Ако не постои таков број на излез да се испечати "Ne postoi"

Пример:

Влез:
2 10

Излез:
19
*/


import java.util.Arrays;
import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        if (m>n*9 || n==1){
            System.out.println("Ne moze");
            return;
        }
        m-=1;
        int br=1, max=9;
        int[] niza=new int[100];
        int j=0;
        while (m>0){
            while (m-max<0){
                max--;
            }
            m-=max;
            niza[j]=max;
            j++;
        }
        int[] t=new int[100];
        int tt=0;
        for (int i=j-1; i>=0; i--){
            t[tt]=niza[i];
            tt++;
        }
        for (int i=0; i<j; i++){
            niza[i]=t[i];
        }
        while (j+1<n){
            br*=10;
            n--;
        }
        int i=0;
        while(i<j){
            br=br*10+niza[i];
            i++;
        }
        System.out.println(br);
    }
}
