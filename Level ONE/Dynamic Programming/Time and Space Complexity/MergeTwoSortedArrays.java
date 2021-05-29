import java.util.*;
public class MergeTwoSortedArrays {
    public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
        //write your code here
        int n = a.length + b.length;
        int[] arr = new int[n];
        int ap = 0, bp = 0, arrp = 0;
        while(arrp<n){
            
            if(ap>=a.length){
                arr[arrp] = b[bp];
                bp++;
                arrp++;
                continue;
            }
            if(bp>=b.length){
                arr[arrp] = a[ap];
                ap++;
                arrp++;
                continue;
            }
            
            if(a[ap] >= b[bp] ){
                arr[arrp] = b[bp];
                bp++;
                arrp++;
            }
            else{
                arr[arrp] = a[ap];
                ap++;
                arrp++;
            }
        
        }

        return arr;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scn.nextInt();
        }
        int m = scn.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scn.nextInt();
        }
        int[] mergedArray = mergeTwoSortedArrays(a, b);
        print(mergedArray);
    }
}
