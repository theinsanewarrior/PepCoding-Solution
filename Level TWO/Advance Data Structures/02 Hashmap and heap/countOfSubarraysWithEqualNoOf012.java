import java.util.*;
public class countOfSubarraysWithEqualNoOf012 {
    public static int solution(int[] arr) {
        // write your code here
        HashMap<String, Integer> hm = new HashMap();
        hm.put("0@0", 1);
        int s0=0, s1=0, s2=0;
        int ans = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0) s0++;
            else if(arr[i]==1) s1++;
            else s2++;
            
            String curr =(s1-s0)+"@"+ (s2-s1);
            
            if(hm.containsKey(curr)){
                ans+=hm.get(curr);
                hm.put(curr, hm.get(curr)+1);
            }
            else {
                hm.put(curr, 1);
            }
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
