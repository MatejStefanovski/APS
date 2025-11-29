import java.util.Scanner;

/*class Klasa1{        //Klasa bez generik
    private int a;
    private int b;

    public void funkcija(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString(){
        return "Klasa1{" + "a=" + a + ", b=" + b + '}';
    }
}*/

class Klasa2<T>{
    private T t;
    void setT(T t){
        this.t = t;
    }
    @Override
    public String toString(){
        return "Klasa 2: " + t;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.printf("Hello and welcome!\n");
        /*Scanner cin=new Scanner(System.in);
        int n=cin.nextInt();
        int[] a=new int[n];
        for (int i=0; i<n; i++){
            a[i]=cin.nextInt();
        }
        int parni=0, neparni=0;
        double prosek=0.0;
        for (int i=0; i<n; i++){
            System.out.print(a[i]+"\n");
            if (a[i]%2==0){
                parni++;
            }
            else{
                neparni++;
            }
            prosek+=a[i];
        }
        System.out.println("Prosek: "+prosek/n + "  Parni: "+parni + "  Neparni: "+neparni);*/


        /*Klasa1 k1 = new Klasa1();
        k1.funkcija(5, 10);
        System.out.println(k1);*/


        Klasa2<Integer> k2=new Klasa2<Integer>();
        k2.setT(10);
        System.out.println(k2);
    }
}