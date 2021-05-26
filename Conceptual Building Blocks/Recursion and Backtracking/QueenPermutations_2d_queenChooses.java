import java.util.*;
public class QueenPermutations_2d_queenChooses {
    public static void queensPermutations(int qpsf, int tq, int[][] chess){
        // write your code here
        if(qpsf == tq){
            for(int i=0; i<tq; i++){
                for(int j=0; j<tq; j++){
                    if(chess[i][j] == 0)
                        System.out.print("-\t");
                    else
                        System.out.print("q" + chess[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for(int i=0; i<tq; i++){
            for(int j=0; j<tq; j++){
                if(chess[i][j] == 0){
                    chess[i][j] = qpsf+1;
                    queensPermutations(qpsf+1, tq, chess);
                    chess[i][j] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];
        
        queensPermutations(0, n, chess);
    }
}
