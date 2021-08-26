import java.util.*;
public class canDivideArrayIntoPairsDivisibleByK {
    public static boolean solution(int[] arr, int k){
		//write your code here
        HashMap<Integer, Integer> hm = new HashMap();
        for(int i=0; i<arr.length; i++){
            int val = arr[i]%k;
            if(hm.containsKey(val)) hm.put(val, hm.get(val)+1);
            else hm.put(val, 1);
        }
        
        for(int val : hm.keySet()) {
            if(val == 0){
                if(hm.get(val)%2!=0) return false;
            }
            else if(k%2==0 && val==k/2){
                if(hm.get(val)%2!=0) return false;
            }
            else if(!hm.containsKey(k-val) || hm.get(k-val)!=hm.get(val)) return false;
        }
        
        return true;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		System.out.println(solution(arr,k));
	}
}
