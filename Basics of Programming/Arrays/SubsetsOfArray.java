// package Basics of Programming.Arrays;
import java.util.*;
public class SubsetsOfArray {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }

        int printLines = (int)Math.pow(2, n);
        for(int i=0; i<printLines; i++){
            int binary = convertToBinary(i);
            int val = (int)Math.pow(10, n-1);
            for(int j=0; j<n; j++){
                if(binary/val == 1){
                    System.out.print(arr[j] + "\t");
                }
                else{
                    System.out.print("-\t");
                }
                binary%=val;
                val/=10;
            }
            System.out.println();
        }

    }

    public static int convertToBinary(int n){
        int ans = 0;
        int pow = 0;
        while(n>0){
            int val = n%2;
            n /= 2;
            ans = ans+ (val*(int)Math.pow(10,pow));
            pow++;
        }
        return ans;
    }
}
