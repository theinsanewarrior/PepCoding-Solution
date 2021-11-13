import java.util.*;
import java.io.*;
public class findPairWithGivenDifference {
    public static void findPair(int[]arr,int target) {
        //write your code here
        Arrays.sort(arr);
        int l=0, h=1;
        while(l<=h && h<arr.length){
            int diff = arr[h]-arr[l];
            if(diff == target){
                System.out.println(arr[l]+" " + arr[h]);
                return;
            }
            else if(diff > target) l++;
            else h++;
        }
        System.out.println(-1);
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int[]arr = new int[n];
        
        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }
        
        int target = scn.nextInt();
        findPair(arr,target);
    }
}
