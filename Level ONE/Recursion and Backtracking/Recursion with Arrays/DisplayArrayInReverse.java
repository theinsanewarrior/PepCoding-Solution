import java.util.*;
public class DisplayArrayInReverse {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        displayArrinReverse(arr, 0);
    }

    public static void displayArrinReverse(int[] arr, int idx) {
        if (idx >= arr.length)
            return;

        displayArrinReverse(arr, idx + 1);
        System.out.println(arr[idx]);
    }
}
