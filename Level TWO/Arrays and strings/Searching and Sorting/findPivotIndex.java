import java.util.*;
public class findPivotIndex {
    public static int pivot_index(int[]nums) {
        //write your code here
        int rsum=0;
        for(int i=0; i<nums.length; i++) rsum+=nums[i];
        int lsum = 0;
        for(int i=0; i<nums.length; i++){
            rsum-=nums[i];
            if(lsum == rsum) return i;
            lsum+=nums[i];
            
        }
        return -1;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i=0; i < arr.length;i++) {
            arr[i] = scn.nextInt();
        }

        int pi = pivot_index(arr);
        System.out.println(pi);
    }
}
