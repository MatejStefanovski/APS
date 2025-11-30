/* Задача 2. Најдобра понуда

На еден светски познат предавач секојдневно му пристигнуваат понуди да држи предавања. За секоја понуда се дадени
датуми, време на почеток, градот и износот на хонорарот за предавањето (во долари).
Вашата задача е, за даден датум, да го прикажете предавањето кое би му донело најголема заработка на предавачот.
Доколку нема понуди за дадениот датум, да се испечати „No offers”.

Влез:
Во првиот ред од влезот е даден бројот на понуди, а во секој нареден ред се дадени:

датумот и времето на предавањето (во формат dd/mm/yyyy hh:mm),

градот во кој се одржува предавањето и

износот на хонорарот.

Во последниот ред е даден датумот за кој треба да испечате понудата со најголема заработка за тој датум.

Излез:
Деталите за понудата за дадениот датум со најголем хонорар.

Пример:
7
27/01/2016 14:00 NewYork 6000
28/01/2016 08:00 Paris 3000
28/01/2016 14:00 Munich 5000
27/01/2016 09:00 Beijing 8000
27/01/2016 08:00 Seattle 4000
28/01/2016 09:00 SaltLakeCity 10000
28/01/2016 09:00 Lagos 12000
27/01/2016

Излез:
09:00 Beijing 8000
 */

import java.util.*;

class Lecture {
    String date;
    String time;
    String place;
    Integer fee;

    public Lecture(String date, String time, String place, Integer fee) {
        this.date = date;
        this.time = time;
        this.place = place;
        this.fee = fee;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }
}

public class ZadacaHash1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        CBHT<String, ArrayList<Lecture>> hash = new CBHT<>(2*n);
        for (int i=0; i<n; i++) {
            String s=sc.nextLine();
            String[] parts =  s.split(" ");
            Lecture l=new Lecture(parts[0],parts[1],parts[2],Integer.parseInt(parts[3]));
            if (hash.search(parts[0])==null){
                ArrayList<Lecture> list=new ArrayList<>();
                list.add(l);
                hash.insert(parts[0],list);
            }
            else{
                SLLNode<MapEntry<String, ArrayList<Lecture>>> node=hash.search(parts[0]);
                ArrayList<Lecture> list = node.element.value;
                list.add(l);
                hash.insert(parts[0],list);
            }
        }
        String data = sc.nextLine();
        SLLNode<MapEntry<String, ArrayList<Lecture>>> node = hash.search(data);
        if (node == null) {
            System.out.println("No offers");
            return;
        }
        ArrayList<Lecture> list = node.element.value;
        Lecture best = null;
        for (Lecture l : list) {
            if (best == null || l.fee > best.fee) {
                best = l;
            }
        }
        System.out.println(best.time + " " + best.place + " " + best.fee);
    }
}
