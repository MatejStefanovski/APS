/*Задача 3. Анаграми
 Користеj´ки хеш табела да се групираат сите анаграми од дадена листа со зборови.
 Анаграми се зборови кои се добиваат со преуредување на буквите од зборот. На
 пример spar е анаграм на rasp.
 Влез: Во првиот ред е даден броjот на зборови N. Во наредните N реда се
 дадени зборовите кои треба да се додадат во табелата. Во следниот ред е даден
 зборот за коj треба да се испечати броjот на анаграми во табелата.
 Излез: Броjот на анаграми во табелата за дадениот збор.
 Пример:
 Влез:
 6
 eat
 tea
 tan
 ate
 nat
 bat
 ant
 Излез:
 2
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramiZadaca {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CBHT<String, Integer> hashtable = new CBHT<>(2*n);
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String wordd = new String(arr);
            if (hashtable.search(wordd)==null){
                hashtable.insert(wordd, 1);
            }
            else{
                SLLNode<MapEntry<String, Integer>> node = hashtable.search(wordd);
                hashtable.insert(wordd, node.element.value+1);
            }
        }
        String kraj = sc.next();
        char[] arr = kraj.toCharArray();
        Arrays.sort(arr);
        String krajd = new String(arr);
        SLLNode<MapEntry<String, Integer>> node = hashtable.search(krajd);
        System.out.println(node.element.value);
    }*/


    //DRUG NACIN SO MAP OD java.util

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < n; i++) {
            String word = sc.next();
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String wordd=new String(arr);
            if (!map.containsKey(wordd)) {
                map.put(wordd, 1);
            }
            else{
                map.put(wordd, map.get(wordd)+1);
            }
        }
        String kraj = sc.next();
        char[] arr = kraj.toCharArray();
        Arrays.sort(arr);
        String krajd = new String(arr);
        System.out.println(map.get(krajd));
    }
}
