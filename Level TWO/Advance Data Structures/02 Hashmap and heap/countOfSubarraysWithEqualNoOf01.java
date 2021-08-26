import java.util.*;
public class countOfSubarraysWithEqualNoOf01 {
    public static int solution(int[] arr) {
        // write your code here
        for(int i=0; i<arr.length; i++) if(arr[i] == 0) arr[i]=-1;
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
