import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Substrings {

    static class MapEntry<K extends Comparable<K>,E> implements Comparable<K> {

        K key;
        E value;

        public MapEntry (K key, E val) {
            this.key = key;
            this.value = val;
        }

        public int compareTo (K that) {
            @SuppressWarnings("unchecked")
            MapEntry<K,E> other = (MapEntry<K,E>) that;
            return this.key.compareTo(other.key);
        }

        public String toString () {
            return "(" + key + "," + value + ")";
        }
    }

    static class SLLNode<E> {
        protected E element;
        protected SLLNode<E> succ;

        public SLLNode(E elem, SLLNode<E> succ) {
            this.element = elem;
            this.succ = succ;
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    static class CBHT<K extends Comparable<K>, E> {

        private SLLNode<MapEntry<K,E>>[] buckets;

        @SuppressWarnings("unchecked")
        public CBHT(int m) {
            buckets = (SLLNode<MapEntry<K,E>>[]) new SLLNode[m];
        }

        private int hash(K key) {
            return Math.abs(key.hashCode()) % buckets.length;
        }

        public SLLNode<MapEntry<K,E>> search(K targetKey) {
            int b = hash(targetKey);
            for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
                if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
                    return curr;
            }
            return null;
        }

        public void insert(K key, E val) {		// Insert the entry <key, val> into this CBHT.
            MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
            int b = hash(key);
            for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
                if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                    curr.element = newEntry;
                    return;
                }
            }
            buckets[b] = new SLLNode<MapEntry<K,E>>(newEntry, buckets[b]);
        }

        public void delete(K key) {
            int b = hash(key);
            for (SLLNode<MapEntry<K,E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
                if (key.equals(((MapEntry<K,E>) curr.element).key)) {
                    if (pred == null)
                        buckets[b] = curr.succ;
                    else
                        pred.succ = curr.succ;
                    return;
                }
            }
        }

        public String toString() {
            String temp = "";
            for (int i = 0; i < buckets.length; i++) {
                temp += i + ":";
                for (SLLNode<MapEntry<K,E>> curr = buckets[i]; curr != null; curr = curr.succ) {
                    temp += curr.element.toString() + " ";
                }
                temp += "\n";
            }
            return temp;
        }

    }

    public static void main (String[] args) throws IOException {
        CBHT<String,Integer> tabela = new CBHT<String,Integer>(300);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().trim();
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j <= word.length(); j++) {
                String sub = word.substring(i, j);
                SLLNode<MapEntry<String, Integer>> node = tabela.search(sub);
                if (node == null) {
                    tabela.insert(sub, 1);
                } else {
                    tabela.insert(sub, node.element.value + 1);
                }
            }
        }
        String bestSubstring = "";
        int bestFreq = 0;
        for (int i = 0; i < 300; i++) {
            for (SLLNode<MapEntry<String, Integer>> curr = tabela.buckets[i]; curr != null; curr = curr.succ) {
                String currentSub = curr.element.key;
                int freq = curr.element.value;
                if (freq > bestFreq) {
                    bestFreq = freq;
                    bestSubstring = currentSub;
                } else if (freq == bestFreq) {
                    if (currentSub.length() > bestSubstring.length()) {
                        bestSubstring = currentSub;
                    } else if (currentSub.length() == bestSubstring.length()) {
                        if (currentSub.compareTo(bestSubstring) < 0) {
                            bestSubstring = currentSub;
                        }
                    }
                }
            }
        }
        System.out.println(bestSubstring);
    }
}

