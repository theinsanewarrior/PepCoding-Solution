import java.util.*;
public class countOfAllSubarraysWith0Sum {
    public static int solution(int[] arr) {
		// write your code here
		HashMap<Integer, Integer> hm = new HashMap();
        int sum = 0;
        int ans=0;
        hm.put(0, 1);
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            if(hm.containsKey(sum)){
                ans+=hm.get(sum);
                hm.put(sum, hm.get(sum)+1);
            }
            else hm.put(sum, 1);
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
		System.out.println(solution(arr));
	}
}
