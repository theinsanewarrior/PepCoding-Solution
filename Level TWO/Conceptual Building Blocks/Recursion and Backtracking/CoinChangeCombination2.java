import java.util.*;
public class CoinChangeCombination2 {
    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {
        // write your code here
        if(amtsf == tamt){
            System.out.println(asf+".");
            return;
        }
        for(int n = i; n<coins.length; n++){
            int val = coins[n];
            if(amtsf+val <= tamt)
                coinChange(n, coins, amtsf+val, tamt, asf+""+val+"-");
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
        coinChange(0, coins, 0, amt, "");
    }
}
