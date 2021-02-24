// package Dynamic Programming.Dynamic Programmming and Greedy;
import java.util.*;
public class PaintHouse {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    Scanner scn= new Scanner(System.in);
    int n=scn.nextInt();
    int[][] costs= new int[n][3];
    for(int i=0;i<n;i++){
        for(int j=0;j<3;j++){
            costs[i][j]=scn.nextInt();
        }
    }
     System.out.println(minCost(costs));
  }
  // -----------------------------------------------------
  // This is a functional problem. Only this function has to be written.
  // This function takes as input 2D array
  // It should return the required output

  public static int minCost(int[][] costs) {
        //Write your code here
        
        int red = costs[0][0];
        int blue = costs[0][1];
        int green = costs[0][2];
        
        
        for(int i=1; i<costs.length; i++){
            int r = red;
            int b = blue;
            int g = green;
            red = costs[i][0] + Math.min(b, g);
            blue = costs[i][1] + Math.min(r, g);
            green = costs[i][2] + Math.min(r, b);
        }
        int ans = Math.min(red,Math.min(blue, green) );
        return ans;
        
  }
}
