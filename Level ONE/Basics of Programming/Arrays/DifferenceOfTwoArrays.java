// package Basics of Programming.Arrays;
import java.util.*;
public class DifferenceOfTwoArrays {
    
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] a1 = new int[n1];
        for(int i=0; i<n1; i++){
            a1[i] = scn.nextInt();
        }
        
        int n2 = scn.nextInt();
        int[] a2 = new int[n2];
        for(int i=0; i<n2; i++){
            a2[i] = scn.nextInt();
        }
        
        // n2>n1
        int[] ans = new int[n2];
        int np1 = n1-1;
        int np2 = n2-1;
        int val = 0;
        int borrow=0;
        
        while(np2>=0 || borrow!=0){
            if(np1<0)
                val = a2[np2] - borrow;
            else
                val = a2[np2] - a1[np1] - borrow;
            borrow = 0;
            if(val<0){
                borrow = 1;
                val+=10;
            }
            ans[np2] = val;
            np2--;
            np1--;
            
        }
        
        for(int i=0; i<n2; i++){
            if(i==0 && ans[0] == 0)
                continue;
            System.out.println(ans[i]);
        }
        
    }
    
    
}
