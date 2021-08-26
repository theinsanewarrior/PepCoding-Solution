import java.util.*;
public class largestSubarrayWith0Sum {
    public static int solution(int[] arr) {
		// write your code here
        HashMap<Integer, Integer> hm = new HashMap();
        int sum = 0;
        int ans=0;
        hm.put(0, -1);
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            if(hm.containsKey(sum)){
                int len = i-hm.get(sum);
                if(len > ans) ans = len;
            }
            else hm.put(sum, i);
        }
		return ans;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}
}
