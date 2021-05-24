import java.util.*;
public class Permutation1 {
    public static void permutations(int[] boxes, int ci, int ti){
        // write your code here
        if(ti==0){
            for(int i=0; i<boxes.length; i++){
                System.out.print(boxes[i]);
            }
            System.out.println();
            return;
        }
        for(int i=0; i<boxes.length; i++){
            if(boxes[i]!=0)
                continue;
            boxes[i] = ci;
            permutations(boxes, ci+1, ti-1);
            boxes[i] = 0;
        }
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(new int[nboxes], 1, ritems);
      }
}
