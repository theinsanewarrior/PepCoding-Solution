import java.util.*;
public class GetCommonElements1 {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n1; i++){
            int val = scn.nextInt();
            if(hm.containsKey(val))
                hm.put(val, hm.get(val)+1);
            else
                hm.put(val, 1);
        }
        int n2 = scn.nextInt();
        int[] arr = new int[n2];
        for(int i=0; i<n2; i++){
            arr[i] = scn.nextInt();
            if(hm.containsKey(arr[i])){
                System.out.println(arr[i]);
                hm.remove(arr[i]);
            }
        }
        
        
        
     }
}
