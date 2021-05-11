import java.util.*;
public class GetCommonElements2 {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        HashMap<Integer, Integer> a1 = new HashMap<>();
        for(int i=0; i<n1; i++){
            int num = scn.nextInt();
            if(a1.containsKey(num))
                a1.put(num, a1.get(num)+1);
            else
                a1.put(num, 1);
        }
        int n2 = scn.nextInt();
        int[] a2 = new int[n2];
        for(int i=0; i<n2; i++){
            a2[i] = scn.nextInt();
            if(a1.containsKey(a2[i])){
                if(a1.get(a2[i]) > 1){
                    System.out.println(a2[i]);
                    a1.put(a2[i], a1.get(a2[i])-1);
                }
                else{
                    System.out.println(a2[i]);
                    a1.remove(a2[i]);
                }
            }
        }
        
        
    }
}
