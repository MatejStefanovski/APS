import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int nextPos(int p) {

        if (p <= 7) {
            p = 8 - p;
        }

        for (int i = 0; i < 14; i++) {
            if (p == 1) p = 51;
            else p--;
        }

        return p;
    }

    public static int count(int N){
        int shuffles = 0;
        int pos = N;

        while (pos != 1) {
            pos = nextPos(pos);
            shuffles++;
        }
        return shuffles;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(count(Integer.parseInt(br.readLine())));
    }
}
