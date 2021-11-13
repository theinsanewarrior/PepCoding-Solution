import java.util.*;
import java.io.*;
public class guessNumberHigherOrLower {
    public static int guessNumber(int n) {
        //write your code here
        int l=1, h=n;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(guess(mid)==0) return mid;
            else if(guess(mid) < 0) h=mid-1;
            else l=mid+1;
        }
        return -1;
    }

    static int pn = 0; //picked number
    public static int guess(int val) {
        if (val == pn) {
            return 0;
        }
        else if (val < pn) {
            return 1;
        }
        else {
            return -1;
        }
    }
    public static void solve(int n, int pick) {
        pn = pick;
        System.out.println(guessNumber(n));
    }
    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int pick = scn.nextInt();
        solve(n, pick);
    }
}
