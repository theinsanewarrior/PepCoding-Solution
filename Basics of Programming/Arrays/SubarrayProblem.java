// package Basics of Programming.Arrays;
import java.util.*;
public class SubarrayProblem {
    public static void main(String[] args) throws Exception {
        // write your code here
        int n;
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        for (int st = 0; st < arr.length; st++) {
            for (int et = st; et < arr.length; et++) {
                for (int i = st; i <= et; i++) {
                    
                    System.out.print(arr[i] + "	");
                }
                System.out.println();
            }
        }

    }
}
