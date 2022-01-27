// package Basics of Programming.Arrays;
import java.util.*;
import java.io.*;

public class BarChart {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE; //min integer possible
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
            if(arr[i] > max)
                max = arr[i];
        }

        for(int i=0; i<max; i++){
            for(int j=0; j<n; j++){
                if(max-arr[j]<=i)
                    System.out.print("*\t");
                else
                    System.out.print("\t");
            }
            System.out.println();
        }

    }
}
