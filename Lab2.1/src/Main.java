import java.util.Scanner;

public class Main {
    static class Task{
        float casovi;
        float zarabotka;

        Task(float casovi, float zarabotka){
            this.casovi = casovi;
            this.zarabotka = zarabotka;
        }
        float getCasovi(){
            return casovi;
        }
        float getZarabotka(){
            return zarabotka;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) {
            float casovi = sc.nextInt();
            float zarabotka = sc.nextInt();
            tasks[i]=new Task(casovi, zarabotka);
        }

        float[] niza=new float[n];
        for (int i = 0; i < n; i++) {
            niza[i]=(tasks[i].getCasovi()+tasks[i].getZarabotka())/2;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (niza[i]<niza[j]) {
                    float temp=niza[i];
                    niza[i]=niza[j];
                    niza[j]=temp;
                    Task tmp=tasks[i];
                    tasks[i]=tasks[j];
                    tasks[j]=tmp;
                }
            }
        }

        /*for (int i = 0; i < n; i++) {
            System.out.println(tasks[i].getCasovi()+" "+tasks[i].getZarabotka());
        }
        */

        float max=40, kraj=0;
        for (int i = 0; i < n; i++) {
            if (max-tasks[i].getCasovi()>0){
                max-=tasks[i].getCasovi();
                kraj+=tasks[i].getZarabotka();
            }
            else{
                float del=tasks[i].getCasovi()/max;
                kraj+=tasks[i].getZarabotka()/del;
                break;
            }
        }

        System.out.println(kraj);
    }
}
