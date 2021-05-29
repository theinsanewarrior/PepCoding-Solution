// package Basics of Programming.Arrays;
import java.util.*;
public class FindElementInArray {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int num = scn.nextInt();
        int idx = -1;
        
        for(int i=0; i<n; i++){
            if(arr[i] == num ){
                idx = i;
                break;
            }
        }
        
        System.out.print(idx);
        
    }
}
