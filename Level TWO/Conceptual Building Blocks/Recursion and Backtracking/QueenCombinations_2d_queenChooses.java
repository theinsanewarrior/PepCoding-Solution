import java.util.*;
public class QueenCombinations_2d_queenChooses {
    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){
        // write your code here
        if(qpsf == tq){
            for(int r=0; r<tq; r++){
                for(int c=0; c<tq; c++){
                    if(chess[r][c] == true)
                        System.out.print("q\t");
                    else
                        System.out.print("-\t");
                }
                System.out.println();
            }
            System.out.println();
        }
        for(int r=i; r<tq; r++){
            if(r==i)
                for(int c=j+1; c<tq; c++){
                    chess[r][c] = true;
                    queensCombinations(qpsf+1, tq, chess, r, c);
                    chess[r][c] = false;
                }
            else
                for(int c=0; c<tq; c++){
                    chess[r][c] = true;
                    queensCombinations(qpsf+1, tq, chess, r, c);
                    chess[r][c] = false;
                }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, -1);
    }
}
