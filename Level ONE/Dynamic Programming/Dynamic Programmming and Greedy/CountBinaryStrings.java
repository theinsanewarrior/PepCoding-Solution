import java.util.*;
public class CountBinaryStrings{
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int prev0 = 0, prev1 = 0, curr0 = 1, curr1 = 1;
        for(int i=2; i<=n; i++){
            prev0 = curr0;
            prev1 = curr1;
            curr0 = prev1;
            curr1 = prev0+prev1;
        }
        System.out.println(curr0 + curr1);
        
     }
    
}