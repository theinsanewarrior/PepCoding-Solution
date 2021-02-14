// package Basics of Programming.Arrays;
import java.util.*;
public class SumOftwoArrays {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = scn.nextInt();
        }

        int max = n1;
        if (n2 > n1) {
            max = n2;
        }
        int max2 = max;
        int[] ans = new int[max + 1];
        ans[0] = 0;

        int np1 = n1 - 1, np2 = n2 - 1, carry = 0, val = 0;
        while (max > 0 || carry > 0) {
            if (np1 <= -1 && np2 <= -1)
                val = carry;
            else if (np1 <= -1)
                val = arr2[np2] + carry;
            else if (np2 <= -1)
                val = arr1[np1] + carry;
            else
                val = arr1[np1] + arr2[np2] + carry;
            carry = val / 10;
            val = val % 10;
            ans[max] = val;
            max--;
            np1--;
            np2--;

        }

        if (ans[0] != 0) {
            System.out.println(ans[0]);
        }
        for (int i = 1; i < max2 + 1; i++) {
            System.out.println(ans[i]);
        }
    }
}
