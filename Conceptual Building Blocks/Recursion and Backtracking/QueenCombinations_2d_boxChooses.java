import java.util.*;
public class QueenCombinations_2d_boxChooses{
    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        // write your code here
        if(row == tq && col == 0){
            if(qpsf == tq){
                System.out.println(asf);
            }
            return;
        }
        int r, c;
        String pasf, npasf;
        if(col == tq-1){
            r = row+1;
            c = 0;
            pasf = asf+"q\n";
            npasf = asf+"-\n";
        }
        else{
            r=row;
            c = col+1;
            pasf = asf+"q";
            npasf = asf+"-";
        }
        // yes
        queensCombinations(qpsf+1, tq, r, c, pasf);
        // no
        queensCombinations(qpsf, tq, r, c, npasf);
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}