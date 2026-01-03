import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Salaries2 {
    static class Person{
        String name;
        int salary;
        String ip;
        String time;
        String town;
        int cost;
        Person(){}
        Person(String name, int salary, String ip, String time, String town, int cost){
            this.name = name;
            this.salary = salary;
            this.ip = ip;
            this.time = time;
            this.town = town;
            this.cost = cost;
        }
        void print(){
            System.out.println(name+" with salary "+salary+" from address "+ip+" who logged in at "+time);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<String, ArrayList<Person>> map = new HashMap<String, ArrayList<Person>>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            Person p = new Person(parts[0]+" "+parts[1], Integer.parseInt(parts[2]), parts[3], parts[4], parts[5], Integer.parseInt(parts[6]));
            if (!map.containsKey(parts[5])) {
                map.put(parts[5], new ArrayList<>());
                map.get(parts[5]).add(p);
            }
            else{
                map.get(parts[5]).add(p);
            }
        }
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            int after11_59=0;
            int earliest=25, earliest1=60;
            Person p = null;
            for (int j=0; j<map.get(parts[5]).size(); j++){
                String time = map.get(parts[5]).get(j).time;
                int t1 = Integer.parseInt(time.substring(0, 2));
                int t2 = Integer.parseInt(time.substring(3, 5));
                if (t1>=12 && t1<=24){
                    after11_59++;
                    if (t1<earliest){
                        earliest=t1;
                        earliest1=t2;
                        p=map.get(parts[5]).get(j);
                    }
                    else if (t1==earliest && t2<earliest1){
                        earliest1=t2;
                        p=map.get(parts[5]).get(j);
                    }
                }
            }
            System.out.println("City: "+parts[5]+" has the following number of customers:");
            System.out.println(after11_59);
            System.out.println("The user who logged on earliest after noon from that city is:");
            p.print();
            System.out.println(" ");
        }
    }
}
