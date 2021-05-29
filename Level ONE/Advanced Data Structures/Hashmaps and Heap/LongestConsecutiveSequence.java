import java.util.*;
public class LongestConsecutiveSequence {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for(int i=0; i<n; i++){
            hm.put(scn.nextInt(), true);
        }
        Set<Integer> set = hm.keySet();
        for(Integer val : set){
            if(hm.containsKey(val-1)){
                hm.put(val, false);
            }
        }
        
        int size = 1;
        int ansStart = 0;
        for(Integer val : set){
            if(hm.get(val) == true){
                int i=1;
                int v = val+1;
                while(hm.containsKey(v)){
                    i++;
                    v++;
                }
                if(i>size){
                    size = i;
                    ansStart = val;
                }
            }
        }
        
        for(int i=1; i<=size; i++){
            System.out.println(ansStart);
            ansStart++;
        }
        
     }
}
