import java.util.*;
public class maxSizeSubarraySumEqualsK {
    public static int maxLenSubarray(int[] nums, int k) {
        // write your code here.
        HashMap<Integer, Integer> hm = new HashMap();
        hm.put(0, -1);
        int sum = 0;
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            int remSum = sum-k;
            if(hm.containsKey(remSum)){
                int length = i-hm.get(remSum);
                if(length > ans) ans = length;
            }
            
            if(!hm.containsKey(sum)) hm.put(sum, i);
            
        }
        return ans;
        
    }
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
 
         // Input for length of first array.
         int N = sc.nextInt();
 
         int[] arr1 = new int[N];
 
         // Input for array1 elements.
         for (int i = 0; i < arr1.length; i++) {
             arr1[i] = sc.nextInt();
         }
 
         int K = sc.nextInt();
 
         int result = maxLenSubarray(arr1, K);
 
         System.out.println(result);
 
     }
 
     // Function to display an array.
     public static void display(int[] arr) {
 
         for (int i = 0; i < arr.length; i++) {
             System.out.print(arr[i] + " ");
         }
 
         System.out.println();
     }
}
