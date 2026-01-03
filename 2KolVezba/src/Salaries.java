import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Salaries {
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
            System.out.println(name+" with salary "+salary+" from address "+ip+" who spent "+cost);
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
            int can_afford=0;
            int max_spent=0;
            Person p = new Person();
            for (int j=0; j<map.get(parts[5]).size(); j++){
                if (map.get(parts[5]).get(j).salary>=map.get(parts[5]).get(j).cost){
                    can_afford++;
                    if (map.get(parts[5]).get(j).cost>max_spent){
                        max_spent=map.get(parts[5]).get(j).cost;
                        p=map.get(parts[5]).get(j);
                    }
                }
            }
            System.out.println("City: "+parts[5]+" has the following number of customers:");
            System.out.println(can_afford);
            System.out.println("The user who spent the most purchasing for that city is:");
            p.print();
            System.out.println(" ");
        }
    }
}
