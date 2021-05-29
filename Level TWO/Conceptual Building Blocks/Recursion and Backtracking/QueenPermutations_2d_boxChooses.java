import java.util.*;
public class QueenPermutations_2d_boxChooses {
    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        // write your code here
        if(row == tq && col == 0){
            if(qpsf == tq)
                System.out.println(asf+"\n");
            return;
        }
        if(col == tq-1){
            // include
            for(int i=1; i<=tq; i++){
                if(queens[i-1] == false){
                    queens[i-1] = true;
                    queensPermutations(qpsf+1, tq, row+1, 0, asf+"q"+i+"\n", queens);
                    queens[i-1] = false;
                }
            }
            // exclude
            queensPermutations(qpsf, tq, row+1, 0, asf+"-\n", queens);
        }
        else{
            // include
            for(int i=1; i<=tq; i++){
                if(queens[i-1] == false){
                    queens[i-1] = true;
                    queensPermutations(qpsf+1, tq, row, col+1, asf+"q"+i+"\t", queens);
                    queens[i-1] = false;
                }
            }
            // exclude
            queensPermutations(qpsf, tq, row, col+1, asf+"-\t", queens);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}
