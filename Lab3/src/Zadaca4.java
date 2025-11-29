import java.util.Arrays;
import java.util.Scanner;

public class Zadaca4 {
    public static int findTruePosition(int lossyNumber, int[] sortedArr, int start, int end){
        int mid = (int)Math.floor((start + end) / 2);

        if(sortedArr[mid] == lossyNumber)
            return mid;

        if(sortedArr[mid] > lossyNumber)
            return findTruePosition(lossyNumber, sortedArr,  start, mid - 1);

        return findTruePosition(lossyNumber, sortedArr, mid + 1, end);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        int[] sortedArr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
            sortedArr[i] = arr[i];
        }

        Arrays.sort(sortedArr);
        int looseEnds = 0;
        int[] looseNumbers = new int[n];
        int[] truePosition = new int[n];

        for(int i = 1; i < n; i++){
            if(arr[i] < arr[i - 1]){
                looseNumbers[looseEnds] = arr[i];
                truePosition[looseEnds] = i - findTruePosition(arr[i], sortedArr, 0, i);
                looseEnds++;
            }

        }

        System.out.println(looseEnds);

        for(int i = 0; i < looseEnds; i++){
            System.out.println(looseNumbers[i] + " " + truePosition[i]);
        }
    }
}
