import java.util.*;
public class GetKPC {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        ArrayList<String> ans = getKPC(str);
        System.out.println(ans);
    }

    public static ArrayList < String > getKPC(String str) {
        if(str.length() == 0){
            ArrayList<String>base = new ArrayList<>();
            base.add("");
            return base;
        }
        
        String[] keypad_values = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
        ArrayList<String>faith_list = getKPC(str.substring(1));
        ArrayList<String>ans_list = new ArrayList<>();
        int num = str.charAt(0) - '0';
        
        for(int i=0; i<(keypad_values[num].length()); i++){
            for(int j=0; j<faith_list.size(); j++){
                char chr = keypad_values[num].charAt(i);
                String str1 = faith_list.get(j);
                ans_list.add(chr+str1);
            }
        }
        
        return ans_list;
    }
}
