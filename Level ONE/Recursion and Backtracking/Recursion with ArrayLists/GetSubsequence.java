import java.util.*;
public class GetSubsequence {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String>ans_list = gss(str);
        System.out.println(ans_list);
    }

    public static ArrayList < String > gss(String str) {
        if(str.length() == 0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        
        ArrayList<String>ans_list = gss(str.substring(1));
        int size = ans_list.size();
        for(int i=0; i<size; i++){
            ans_list.add(str.substring(0,1) + ans_list.get(i));
            // ans_list.add(str.charAt(0) + ans_list.get(i));
        }
        
        return ans_list;
    }
}
