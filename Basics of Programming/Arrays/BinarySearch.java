// package Basics of Programming.Arrays;
import java.util.*;
public class BinarySearch {
    public static int search(int[] ar, int key) {

        //Write your code here.
        int left = 0;
        int right = ar.length - 1;
        int ans=-1;
        while(right>=left){
            int mid = (left+right)/2;
            if(ar[mid] == key){
                ans = mid;
                break;
            }
            else if(ar[mid]> key){
                right = mid-1;
            }
            else if(ar[mid] < key){
                left = mid+1;
            }
        }
        
        return ans;

    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = s.nextInt();
        }
        int key = s.nextInt();
        System.out.println(search(ar, key));
    }
}
