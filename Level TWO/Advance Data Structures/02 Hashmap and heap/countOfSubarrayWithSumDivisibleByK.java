import java.util.*;
public class countOfSubarrayWithSumDivisibleByK {
    public static int solution(int[] arr, int k) {
        // write your code here
        HashMap<Integer, Integer> hm = new HashMap();
        hm.put(0, 1);
        int sum = 0;
        int val = 0;
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            int rem = sum%k;
            if(rem<0) rem+=k;
            if(hm.containsKey(rem)){
                ans+=hm.get(rem);
                hm.put(rem, hm.get(rem)+1);
            }
            else hm.put(rem, 1);
            
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        System.out.println(solution(arr, k));
    }
}
