import java.util.HashMap;
import java.util.Scanner;

public class IPAddress {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++){
            String ip = sc.next();
            String[] parts = ip.split("\\.");
            String s = parts[0]+"."+parts[1]+"."+parts[2]+".0";
            if (map.containsKey(s)){
                int temp = map.get(s);
                map.put(s,temp+1);
            }
            else{
                map.put(s, 1);
            }
        }
        int m = sc.nextInt();
        for (int i=0; i<m; i++){
            String ip = sc.next();
            int tmp = map.getOrDefault(ip, 0);
            System.out.println(tmp);
        }
    }
}
