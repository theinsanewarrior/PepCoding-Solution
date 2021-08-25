import java.util.*;
public class countDistinctElementsinEveryWindowOfSizeK {
    public static ArrayList<Integer> solution(int[] arr, int k) {
		//write your code here
		HashMap<Integer, Integer> hm = new HashMap();
        int i=0, j=i+k-1;
        for(i=0; i<=j; i++){
            if(hm.containsKey(arr[i])) hm.put(arr[i], hm.get(arr[i])+1);
            else hm.put(arr[i], 1);
        }
        i=1;
        j++;
        ArrayList<Integer> ans = new ArrayList();
        ans.add(hm.size());
        while(j<arr.length){
            if(hm.get(arr[i-1]) > 1) hm.put(arr[i-1], hm.get(arr[i-1])-1);
            else hm.remove(arr[i-1]);
            
            if(hm.containsKey(arr[j])) hm.put(arr[j], hm.get(arr[j])+1);
            else hm.put(arr[j], 1);
            
            ans.add(hm.size());
            
            i++;
            j++;
        }
        
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] arr = new int[scn.nextInt()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		ArrayList<Integer> ans = solution(arr,k);
		for(int a : ans){
			System.out.print(a + " ");
		}
	}
}
