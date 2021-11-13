import java.util.*;
public class firstBadVersion {
    public static int firstBadVersion(int n) {
        //write your code here
        int ans = -1;
        int l=1, h=n;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(isBadVersion(mid)){
                ans = mid;
                h = mid-1;
            }else l = mid+1;
        }
        return ans;
    }

    static int bad = 0;
    public static boolean isBadVersion(int val) {
        if (val >= bad) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void solve(int n, int fbv) {
        bad = fbv;
        System.out.println(firstBadVersion(n));
    }
    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int fbv = scn.nextInt();
        solve(n, fbv);
    }
}
