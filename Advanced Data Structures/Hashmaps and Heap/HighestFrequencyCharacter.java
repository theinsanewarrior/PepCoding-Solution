import java.util.*;
public class HighestFrequencyCharacter {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        char ans = str.charAt(0);
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch)+1);
                if(hm.get(ch) > hm.get(ans))
                    ans = ch;
            }
            else{
                hm.put(ch, 1);
            }
        }
        System.out.println(ans);
    }
}
