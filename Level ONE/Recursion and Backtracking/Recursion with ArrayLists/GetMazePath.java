import java.util.*;
public class GetMazePath {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int row = scn.nextInt();
        int col = scn.nextInt();
        
        ArrayList<String>ans = getMazePaths(0, 0, row-1, col-1);
        System.out.println(ans);
        
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList < String > getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        if(sr == dr){
            ArrayList<String> base1 = getMazePaths(sr, sc+1, dr, dc);
            for(int i=0; i<base1.size(); i++){
                base1.add("h" + base1.get(i) );
                base1.remove(i);
            }
            return base1;
        }
        if(sc == dc){
            ArrayList<String> base2 = getMazePaths(sr+1, sc, dr, dc);
            for(int i=0; i<base2.size(); i++){
                base2.add("v" + base2.get(i) );
                base2.remove(i);
            }
            return base2;
        }
        
        ArrayList<String> ans_list = new ArrayList<>();
        
        ArrayList<String> right_list = getMazePaths(sr, sc+1, dr, dc);
        for(int i=0; i<right_list.size(); i++){
            ans_list.add("h" + right_list.get(i) );
        }
        
        ArrayList<String> down_list = getMazePaths(sr+1, sc, dr, dc);
        for(int i=0; i<down_list.size(); i++){
            ans_list.add("v" + down_list.get(i) );
        }
        
        
        return ans_list;
    }

}
