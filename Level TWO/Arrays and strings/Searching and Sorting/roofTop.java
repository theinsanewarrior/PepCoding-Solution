import java.util.*;
public class roofTop {
    public static int findMaxSteps(int[]arr) {
        //write your code here
        int maxSteps = 0, currSteps = 0;
        for(int i=1; i<arr.length; i++){
            if(arr[i] > arr[i-1]) currSteps++;
            else currSteps = 0;
            maxSteps = Math.max(currSteps, maxSteps);
        }
        return maxSteps;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int ans = findMaxSteps(arr);
        System.out.println(ans);
    }
}
