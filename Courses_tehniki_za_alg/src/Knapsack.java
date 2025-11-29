import java.util.Scanner;

public class Knapsack {
    static class zadaci{
        public float a;
        public float b;
        zadaci(float a, float b){
            this.a = a;
            this.b = b;
        }
        public float getA(){
            return a;
        }
        public float getB(){
            return b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        zadaci[] z= new zadaci[n];
        float[] podredi=new float[n];
        for (int i = 0; i < n; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            z[i]=new zadaci(a,b);
        }
        for(int i=0; i<n; i++){
            podredi[i]=z[i].getA()/z[i].getB();
        }
        for (int i = 0; i < n; i++) {
            for(int j=0; j<n; j++){
                if (podredi[i]<podredi[j]){
                    float temp=podredi[i];
                    podredi[i]=podredi[j];
                    podredi[j]=temp;
                    zadaci temp2=z[i];
                    z[i]=z[j];
                    z[j]=temp2;
                }
            }
        }
        float kraj=40, rez=0;
        int i=0;
        while (kraj>0){
            if (kraj-z[i].getA()>0){
                kraj-=z[i].getA();
                rez+=z[i].getB();
            }
            else{
                float temp=z[i].getA()/kraj;
            }
            i++;
        }
    }
}
