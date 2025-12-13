import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KumanovskiDijalekt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        sc.nextLine();
        Map<String, String> map = new HashMap<>();
        for (int i=0; i<n; i++){
            String key = sc.next();
            String value = sc.next();
            map.put(key, value);
            sc.nextLine();
        }
        String text = sc.nextLine();
        String[] parts = text.split(" ");
        String kraj="";
        for (int i=0; i<parts.length; i++){
            char temp=' ';
            boolean flag=false;
            if (parts[i].charAt(parts[i].length()-1)=='.' ||  parts[i].charAt(parts[i].length()-1)==','){
                temp=parts[i].charAt(parts[i].length()-1);
                flag=true;
            }
            String l = parts[i];
            if (flag){
                l=parts[i].substring(0,parts[i].length()-1);
            }
            if (map.containsKey(l)){
                parts[i]=map.get(l);
            }
            kraj+=parts[i];
            if (temp != ' '){
                kraj+=temp;
            }
            kraj+=" ";
        }
        System.out.println(kraj);
    }
}
