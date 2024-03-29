import java.util.*;
public class Permutations2 {
    public static void permutations(int cb, int tb, boolean[] items, int ssf, int ts, String asf){
        // write your code here
        if(cb == tb){
            if(ssf == ts){
                System.out.println(asf);
            }
            return;
        }
        // include
        for(int i=0; i<items.length; i++){
            if(items[i]==false){
                items[i] = true;
                permutations(cb+1, tb, items, ssf+1, ts, asf+(i+1));
                items[i] = false;
            }
        }
        // exclude
        permutations(cb+1, tb, items, ssf, ts, asf+"0");
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(0, nboxes, new boolean[ritems], 0, ritems, "");
      }
    
}
