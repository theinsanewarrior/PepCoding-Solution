import java.util.*; 
public class KPartitions {
     // rssf == count of non-empty subset so far
     static int count;
     public static void solution(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
         //write your code here
         if(i==n+1){
             if(rssf == k){
                 System.out.print(count+". ");
                 for(int v=0; v<k; v++){
                     System.out.print(ans.get(v)+" ");
                 }
                 System.out.println();
                 count++;
             }
             return;
         }
         //occupying non-empty sets
         for(int v=0; v<k; v++){
             if(ans.get(v).size()!=0){
                 ans.get(v).add(i);
                 solution(i+1, n, k, rssf, ans);
                 ans.get(v).remove(ans.get(v).size()-1);
             }
         }
         //occupying empty sets
         for(int v=0; v<k; v++){
             if(ans.get(v).size()==0){
                 ans.get(v).add(i);
                 solution(i+1, n, k, rssf+1, ans);
                 ans.get(v).remove(0);
                 break;
             }
         }
     }
     public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         int n = scn.nextInt();
         int k = scn.nextInt();
         ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
         for(int i  = 0; i < k; i++) {
             ans.add(new ArrayList<>());
         }
         count = 1;
         solution(1, n, k, 0, ans);
 
     }
}
