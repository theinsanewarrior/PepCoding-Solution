import java.util.*;
public class largestPerimeterTriangle {
    public static int largestPerimeter(int[]nums) {
        //write your code here
        Arrays.sort(nums);
        int i = nums.length-3;
        while(i>=0){
            if(nums[i]+nums[i+1] > nums[i+2]) return nums[i]+nums[i+1]+nums[i+2];
            else i--;
        }
        return 0;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
    
        int[]nums = new int[n];
    
        for (int i = 0; i < n; i++) {
          nums[i] = scn.nextInt();
        }
    
        System.out.println(largestPerimeter(nums));
    }
}
