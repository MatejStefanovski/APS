import java.util.Scanner;
import java.util.Vector;

public class Main {

    static void Merge(int[] niza, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1];
        int left=low, right=mid+1, br=0;
        while (left <= mid && right <= high) {
            if (niza[left] < niza[right]) {
                tmp[br] = niza[left];
                left++;
            }
            else{
                tmp[br] = niza[right];
                right++;
            }
            br++;
        }
        while (left <= mid) {
            tmp[br] = niza[left];
            left++;
            br++;
        }
        while (right <= high) {
            tmp[br] = niza[right];
            right++;
            br++;
        }
        for (int i = 0; i < tmp.length; i++) {
            niza[low+i]=tmp[i];
        }
    }

    static void MergeSort(int[] niza, int low, int high){
        if (low>=high) return;
        int mid=(low+high)/2;
        MergeSort(niza, low, mid);
        MergeSort(niza, mid+1, high);
        Merge(niza, low, mid, high);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] niza=new int[n];
        for (int i=0; i<n; i++){
            niza[i]=sc.nextInt();
        }
        MergeSort(niza, 0,niza.length-1);
        String s="";
        for (int i=0; i<n; i++){
            s+=niza[i];
            s+=" ";
        }
        System.out.println(s);
    }
}
