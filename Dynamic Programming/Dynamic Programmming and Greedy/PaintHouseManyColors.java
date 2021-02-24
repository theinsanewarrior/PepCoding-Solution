// package Dynamic Programming.Dynamic Programmming and Greedy;
import java.util.*;
public class PaintHouseManyColors {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int[][] cost = new int[n][k];
        for(int i=0; i<n; i++){
            for(int j=0; j<k; j++){
                cost[i][j] = scn.nextInt();
            }
        }
        
        int[] dp1 = new int[k];
        int[] dp2 = new int[k];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<k; j++){
                dp2[j] = dp1[j];
            }
            for(int j=0; j<k; j++){
                int min = Integer.MAX_VALUE;
                for(int l=0; l<k; l++){
                    if(l==j)
                        continue;
                    if(min>dp2[l])
                        min = dp2[l];
                }
                dp1[j] = cost[i][j] + min;
            }
        }
        
        int min = dp1[0];
        for(int i=1; i<k; i++){
            if(dp1[i]<min)
                min = dp1[i];
        }
        System.out.println(min);
    }
}
