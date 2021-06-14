import java.util.*;
public class CoinChangePermutation2 {
    public static void coinChange(int[] coins, int amtsf, int tamt, String asf) {
        // write your code here
        if(amtsf == tamt){
            System.out.println(asf+".");
            return;
        }
        for(int i=0; i<coins.length; i++){
            int val = coins[i];
            if(amtsf+val<=tamt)
                coinChange(coins, amtsf+val, tamt, asf+val+"-");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        coinChange(coins, 0, amt, "");
    }
}
