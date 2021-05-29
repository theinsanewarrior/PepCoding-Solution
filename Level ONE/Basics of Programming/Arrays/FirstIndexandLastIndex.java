// package Basics of Programming.Arrays;
import java.util.*;
public class FirstIndexandLastIndex {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int find = scn.nextInt();

        int firstIdx = -1, lastIdx = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == find) {
                firstIdx = i;
                for (int j = i; j < n; j++) {
                    if (arr[j] == find) {
                        lastIdx = j;
                        continue;
                    } else {
                        break;
                    }
                }
                break;
            }
            
        }

        System.out.println(firstIdx + "" + lastIdx);

    }
}
