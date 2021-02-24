// package Dynamic Programming.Dynamic Programmming and Greedy;
import java.util.*;
public class ArrangeBuildings {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        long n = scn.nextInt();
        
        long prev0 = 0, prev1 = 0, curr0 = 1, curr1 = 1;
        for(int i=2; i<=n; i++){
            prev0 = curr0;
            prev1 = curr1;
            curr0 = prev1;
            curr1 = prev0+prev1;
        }
        long ans = (curr0 + curr1)*(curr0 + curr1);
        System.out.println(ans);
        
     }
}
