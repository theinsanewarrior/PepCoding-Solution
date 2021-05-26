import java.util.*;
public class QueenCombinations_1d_queenChooses {
    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lcno) {
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
        for(int n=lcno+1; n<tq*tq; n++){
            int i = n/tq;
            int j = n%tq;
            chess[i][j] = true;
            queensCombinations(qpsf+1, tq, chess, n);
            chess[i][j] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}
