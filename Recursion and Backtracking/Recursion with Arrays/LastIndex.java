import java.util.*;
public class LastIndex {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int x = scn.nextInt();
        int ans = lastIndex(arr, 0, x);
        System.out.println(ans);
    }

    public static int lastIndex(int[] arr, int idx, int x) {
        if(idx == arr.length-1){
            if(arr[idx] == x)
                return idx;
            return -1;
        }
        int ans1 = -1;
        if(arr[idx] == x){
            ans1 = idx;
        }
        int ans2 = lastIndex(arr, idx+1, x);
        if(ans2 > ans1)
            return ans2;
        return ans1;
    }
}
