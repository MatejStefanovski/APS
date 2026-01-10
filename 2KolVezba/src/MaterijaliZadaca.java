import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaterijaliZadaca {
    static class Material{
        String name;
        int cost;
        Material(String name,int cost){
            this.name=name;
            this.cost=cost;
        }
    }
    static class Niza{
        String name1;
        String name2;
        Niza(String name1,String name2){
            this.name1=name1;
            this.name2=name2;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);
        int n = sc.nextInt();
        Map<String, ArrayList<Material>> map = new HashMap<>();
        Niza[] niza = new Niza[n];
        for (int i = 0; i < n; i++) {
            niza[i] = new Niza(sc.next(), sc.next());
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            String name1 = sc.next();
            String name2 = sc.next();
            int cost = sc.nextInt();
            if (!map.containsKey(name1)) {
                map.put(name1, new ArrayList<>());
                map.get(name1).add(new Material(name2, cost));
            }
            else{
                map.get(name1).add(new Material(name2, cost));
            }
        }
        int cost=0;
        for (int i = 0; i < n; i++) {
            if (niza[i].name1.equals(niza[i].name2)) {
                cost+=0;
            }
            else{
                int c = 0;
                for (Material mat : map.get(niza[i].name1)) {
                    if (mat.name.equals(niza[i].name2)) {
                        c = mat.cost;
                        break;
                    }
                }
                cost += c;
            }
        }
        System.out.println(cost);
    }
}
