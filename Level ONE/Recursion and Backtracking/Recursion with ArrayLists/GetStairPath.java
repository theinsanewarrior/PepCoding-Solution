import java.util.*;
public class GetStairPath {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<String>ans = getStairPaths(n);
        System.out.println(ans);
    }

    public static ArrayList < String > getStairPaths(int n) {
        if(n==0){
            ArrayList<String>base = new ArrayList<>();
            base.add("");
            return base;
        }
        if(n<0){
            ArrayList<String>base = new ArrayList<>();
            return base;
        }
        
        ArrayList<String>ans = new ArrayList<>();
        
        ArrayList<String>diff3 = getStairPaths(n-3);
        ArrayList<String>diff2 = getStairPaths(n-2);
        ArrayList<String>diff1 = getStairPaths(n-1);
        
        for(int i=0; i<diff1.size(); i++){
            ans.add("1" + diff1.get(i));    
        }
        
        for(int i=0; i<diff2.size(); i++){
            ans.add("2" + diff2.get(i));
        }
        
        for(int i=0; i<diff3.size(); i++ ){
            ans.add("3" + diff3.get(i) );
        }
        
        return ans;
    }
}
