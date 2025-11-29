import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Student{
        String ime;
        int dokumenti;
        int indeks;
        int sredno;
        Student(String ime, int dokumenti, int indeks, int sredno){
            this.ime = ime;
            this.dokumenti = dokumenti;
            this.indeks = indeks;
            this.sredno = sredno;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        Student[] studenti = new Student[n];
        Queue<Student> dokumenti = new LinkedList<>();
        Queue<Student> indeks = new LinkedList<>();
        Queue<Student> sredno = new LinkedList<>();
        for (int i=0; i<n; i++){
            String ime = sc.nextLine();
            int dokumenti1 = sc.nextInt();
            int indeks1 = sc.nextInt();
            int sredno1 = sc.nextInt();
            sc.nextLine();
            studenti[i]=new Student(ime,dokumenti1,indeks1,sredno1);
        }
        for (int i=0; i<n; i++){
            if (studenti[i].dokumenti==1){
                dokumenti.add(studenti[i]);
                continue;
            }
            if (studenti[i].indeks==1){
                indeks.add(studenti[i]);
                continue;
            }
            if (studenti[i].sredno==1){
                sredno.add(studenti[i]);
            }
        }
        while (!dokumenti.isEmpty()){
            Student student = dokumenti.peek();
            boolean flag=false;
            if (student.indeks==1){
                indeks.add(student);
                flag=true;
            }
            else if (student.sredno==1){
                sredno.add(student);
                flag=true;
            }
            dokumenti.poll();
            if (!flag){
                System.out.println(student.ime);
            }
        }
        while (!indeks.isEmpty()){
            Student student = indeks.peek();
            boolean flag=false;
            if (student.sredno==1){
                sredno.add(student);
                flag=true;
            }
            indeks.poll();
            if (!flag){
                System.out.println(student.ime);
            }
        }
        while (!sredno.isEmpty()){
            Student student = sredno.peek();
            sredno.poll();
            System.out.println(student.ime);
        }
    }
}
