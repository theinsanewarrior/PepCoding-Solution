import java.util.*;
public class countOfSubarraysHavingSumK {
    public static int solution(int[] nums, int k){
		// write your code here
		HashMap<Integer, Integer> hm = new HashMap();
        hm.put(0, 1);
        int sum = 0;
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            int remSum = sum-k;
            if(hm.containsKey(remSum)) ans+=hm.get(remSum);
            
            if(!hm.containsKey(sum)) hm.put(sum, 1);
            else hm.put(sum, hm.get(sum)+1);
            
        }
        return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        System.out.println(solution(arr,target));
	}
}
