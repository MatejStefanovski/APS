import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            int t=sc.nextInt();
            String kraj="";
            for (int i=0; i<s.length(); i++){
                if (t>0){
                    if (s.charAt(i)!='a'){
                        kraj+='a';
                    }
                    else{
                        kraj+='b';
                    }
                    t--;
                }
                else{
                    kraj+=s.charAt(i);
                }
            }
            System.out.println(kraj);
        }
    }
}
