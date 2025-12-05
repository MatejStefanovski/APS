import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Telefinski_imenik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        Map<String, String> imenik = new HashMap<>();
        for (int i=0; i<n; i++){
            String broj=sc.next();
            String ime=sc.next();
            String br1=broj.substring(1);
            imenik.put(br1,ime);
        }
        String broj=sc.next();
        String br=broj.substring(4);
        if(imenik.containsKey(br)){
            String ime=imenik.get(br);
            System.out.println(ime);
        }
        else{
            System.out.println("Unknown Number");
        }
    }
}
