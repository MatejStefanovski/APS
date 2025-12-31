import java.util.*;

public class Semafori {
    static class Prestap {
        String ime;
        int vreme;
        Prestap(String ime, int vreme) {
            this.ime = ime;
            this.vreme = vreme;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String reg = sc.next();
            String ime = sc.next();
            map.put(reg, ime);
        }
        int maxSpeed = sc.nextInt();
        sc.nextLine();
        String[] parts = sc.nextLine().split(" ");
        ArrayList<Prestap> list = new ArrayList<>();
        for (int i = 0; i < parts.length; i += 3) {
            String reg = parts[i];
            int speed = Integer.parseInt(parts[i + 1]);
            int time = Integer.parseInt(parts[i + 2]);
            if (speed > maxSpeed) {
                list.add(new Prestap(map.get(reg), time));
            }
        }
        list.sort(Comparator.comparingInt(p -> p.vreme));
        for (Prestap p : list) {
            System.out.println(p.ime);
        }
    }
}
