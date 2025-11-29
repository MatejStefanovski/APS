import java.util.Scanner;

class Student{
    public String name;
    public String surname;
    public String index;

    Student(String n, String s, String i){
        name = n;
        surname = s;
        index = i;
    }

    public String getIndex(){
        return index;
    }

    @Override
    public String toString() {
        System.out.println(name + " " + surname);
        return super.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            String a1, a2, a3;
            a1 = sc.next();
            a2 = sc.next();
            a3 = sc.next();
            Student s = new Student(a1, a2, a3);
            students[i] = s;
        }
        int t=sc.nextInt();
        for (int i = 0; i < n; i++) {
            String ind=sc.next();
            int poeni=sc.nextInt();
            for (int j=0; j<n; j++){
                if (ind.equals(students[j].index) && poeni>t){
                    students[j].toString();
                }
            }
        }
    }
}