import java.util.ArrayList;
import java.util.Scanner;

public class Hash_IPs_2 {
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
        CBHT<String, ArrayList<Person>> map = new CBHT<>(n);
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String[] ip = parts[3].split("\\.");
            String ipaddr = ip[0]+"."+ip[1]+"."+ip[2];
            Person p = new Person(parts[0]+" "+parts[1], Integer.parseInt(parts[2]), parts[3], parts[4], parts[5], Integer.parseInt(parts[6]));
            SLLNode<MapEntry<String, ArrayList<Person>>> node = map.search(ipaddr);
            if (node == null){
                ArrayList<Person> list = new ArrayList<>();
                list.add(p);
                map.insert(ipaddr, list);
            }
            else{
                node.element.value.add(p);
            }
        }
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] parts = sc.nextLine().split("\\s+");
            String[] ip = parts[3].split("\\.");
            String ipaddr = ip[0] + "." + ip[1] + "." + ip[2];
            SLLNode<MapEntry<String, ArrayList<Person>>> node = map.search(ipaddr);
            ArrayList<Person> list = node.element.value;
            int max_iznos = 0;
            int count = 0;
            Person user = new Person();
            for (Person p : list){
                if (p.salary >= p.cost){
                    count++;
                    if (p.cost > max_iznos){
                        max_iznos = p.cost;
                        user = p;
                    }
                }
            }
            System.out.println("IP network: " + ipaddr + " has the following number of users:");
            System.out.println(count);
            System.out.println("The user who spent the most from that network is:");
            user.print();
            System.out.println();
        }
    }
}
